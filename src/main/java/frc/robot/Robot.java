package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.MoveMotors;
import frc.robot.commands.ShooterAmpPID;
import frc.robot.subsystems.Motors;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  public static OI oi;
  // exm:
  public static Motors motorOneAndThree;

  @Override
  public void robotInit() {
    SmartDashboard.putNumber("kpleft: ", 0.0);
    SmartDashboard.putNumber("kileft: ", 0.0);
    SmartDashboard.putNumber("kdleft: ", 0.0);
    SmartDashboard.putNumber("setpoint: ", 0.0);
    SmartDashboard.putNumber("kpright: ", 0.0);
    SmartDashboard.putNumber("kiright: ", 0.0);
    SmartDashboard.putNumber("kdright: ", 0.0);
    SmartDashboard.putNumber("motor power: ", 0.0);
    SmartDashboard.putBoolean("pidEnd: ", false);
    RobotComponents.tslonright.setNeutralMode(NeutralMode.Coast);
    RobotComponents.talonleft.setNeutralMode(NeutralMode.Coast);
    motorOneAndThree = new Motors(RobotComponents.talonleft, RobotComponents.tslonright);
    oi = new OI();
    // new MoveMotors(Robot.motorOneAndThree, () -> 0.0, () -> true);
    SmartDashboard.putData(
        new ShooterAmpPID(() -> SmartDashboard.getNumber("kpleft: ", 0.0), () -> SmartDashboard.getNumber("kileft: ", 0),
            () -> SmartDashboard.getNumber("kdleft: ", 0.0), () -> SmartDashboard.getNumber("setpoint: ", 0.0),
            RobotComponents.talonleft, () -> SmartDashboard.getBoolean("pidEnd: ", false))
                .raceWith(new ShooterAmpPID(() -> SmartDashboard.getNumber("kpright: ", 0.0),
                    () -> SmartDashboard.getNumber("kiright: ", 0.0), () -> SmartDashboard.getNumber("kdright: ", 0),
                    () -> SmartDashboard.getNumber("setpoint: ", 0.0), RobotComponents.tslonright, () -> false)));

    // SmartDashboard.putData("move motors", new MoveMotors(motorOneAndThree, () ->
    // -0.6, () -> false);
    // SmartDashboard.putData("stop motors", new MoveMotors(motorOneAndThree, () ->
    // 0.0, () -> false));
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    SmartDashboard.putNumber("voltage 1: ", RobotComponents.talonleft.getStatorCurrent());
    SmartDashboard.putNumber("voltage 2: ", RobotComponents.tslonright.getStatorCurrent());
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }
}
