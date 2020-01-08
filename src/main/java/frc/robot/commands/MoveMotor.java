package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Motors;

/**
 * moves the motor
 */
public class MoveMotor extends CommandBase {

  Supplier<Double> power;
  Motors motors;

  public MoveMotor(Motors motors, Supplier<Double> power) {
    addRequirements(motors);
    this.power = power;
    this.motors = motors;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    motors.moveMotor(power.get());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
