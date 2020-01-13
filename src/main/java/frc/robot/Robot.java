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
    SmartDashboard.putNumber("kp: ", 0);
    SmartDashboard.putNumber("ki: ", 0);
    SmartDashboard.putNumber("kd: ", 0);
    SmartDashboard.putNumber("setpoint: ", 0);
    SmartDashboard.putNumber("motor power: ", 0);
    RobotComponents.tslonright.setNeutralMode(NeutralMode.Coast);
    RobotComponents.talonleft.setNeutralMode(NeutralMode.Coast);
    motorOneAndThree = new Motors(RobotComponents.talonleft, RobotComponents.tslonright);
    oi = new OI();
    //new MoveMotors(Robot.motorOneAndThree, () -> 0.0, () -> true);
    new ShooterAmpPID(() -> SmartDashboard.getNumber("kp: ", 0), () -> SmartDashboard.getNumber("ki: ", 0),
        () -> SmartDashboard.getNumber("kd: ", 0), () -> SmartDashboard.getNumber("setpoint: ", 0),
        RobotComponents.talonleft);
    new ShooterAmpPID(() -> SmartDashboard.getNumber("kp: ", 0), () -> SmartDashboard.getNumber("ki: ", 0),
        () -> SmartDashboard.getNumber("kd: ", 0), () -> SmartDashboard.getNumber("setpoint: ", 0),
        RobotComponents.tslonright);


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
