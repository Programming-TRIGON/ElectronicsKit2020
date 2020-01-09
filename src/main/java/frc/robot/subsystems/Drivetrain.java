package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.DriveArcade;

public class Drivetrain extends SubsystemBase {
  private DifferentialDrive drive; 
  
  /**
   * Creates a new Drivetrain.
   */
  public Drivetrain(SpeedController leftRear, SpeedController leftFront, SpeedController rightRear, SpeedController rightFront) {
    SpeedController leftMotors = new SpeedControllerGroup(leftRear, leftFront); 
    SpeedController rightMotors = new SpeedControllerGroup(rightRear, rightFront);
    drive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void driveArcade(double x, double y) {
    drive.arcadeDrive(y, x); // y and than x is the right input for the arcade drive method  
  }
}
