package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Creates a new Motor, and hold all the functions of said motor.
 */
public class Motors extends SubsystemBase {
  SpeedController[] motors;

  public Motors(SpeedController... motors) {
    for (int i = 0; i < this.motors.length; i++) {
      this.motors[i] = motors[i];
    }
  }

  public Motors(Command command, SpeedController... motors) {
    this(motors);
    setDefaultCommand(command);
  }

  public void moveMotors(double power) {
    for (SpeedController speedController : this.motors) {
      speedController.set(power);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
