package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Creates a new Motor, and hold all the functions of said motor.
 */
public class Motors extends SubsystemBase {
  private WPI_TalonSRX motors[];

  public Motors(WPI_TalonSRX... motors) {
    this.motors = motors;
  }

  public Motors(CommandBase command, WPI_TalonSRX... motors) {
    this(motors);
    command.addRequirements(this);
    setDefaultCommand(command);
    
  }

  public void moveMotors(double power) {
    for (SpeedController speedController : this.motors) {
      speedController.set(power);
    }

  }
}
