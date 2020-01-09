package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

import static frc.robot.Robot.oi;

public class DriveArcade extends CommandBase {
  /**
   * Creates a new DriveArcade.
   */
  public DriveArcade() {
    addRequirements(Robot.drivetrain);
  }

  @Override
  public void execute() {
    Robot.drivetrain.driveArcade(oi.getXboxController().getX(Hand.kLeft), -oi.getXboxController().getY(Hand.kLeft));
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
