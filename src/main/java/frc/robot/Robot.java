package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.MoveMotors;
import frc.robot.subsystems.Motors;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  public static OI oi;
  // exm:
  public static Motors motorOneAndThree;

  @Override
  public void robotInit() {
    RobotComponents.talonleft.setInverted(true);
    motorOneAndThree = new Motors(RobotComponents.talonleft, RobotComponents.tslonright);
    oi = new OI();

    SmartDashboard.putData("move motors", new MoveMotors(motorOneAndThree, oi.getXboxController()::getY, () -> false));
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    SmartDashboard.putNumber("voltage", RobotComponents.talonleft.getBusVoltage());
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
