package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Motors;

/**
 * moves the motor
 */
public class MoveMotors extends CommandBase {
  double WAIT_TIME = 4;
  Supplier<Double> power;
  Supplier<Boolean> isFinished;
  double startTime;
  Motors motors;

  public MoveMotors(Motors motors, Supplier<Double> power, Supplier<Boolean> isFinished) {
    addRequirements(motors);
    this.power = power;
    this.motors = motors;
    this.isFinished = isFinished;
  }

  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void execute() {
    motors.moveMotors(power.get());
    SmartDashboard.putBoolean("Put Ball", Timer.getFPGATimestamp() > startTime + WAIT_TIME); 
  }

  @Override
  public boolean isFinished() {
    return this.isFinished.get();
  }

  @Override
  public void end(boolean interrupted) {
    this.motors.moveMotors(0);
  }

}
