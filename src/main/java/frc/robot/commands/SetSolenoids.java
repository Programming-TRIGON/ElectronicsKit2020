package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DoubleSolenoids;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/** Creates a new SetSolenoids. */
public class SetSolenoids extends CommandBase {
  DoubleSolenoids doubleSolenoids;
  Supplier<Value> value;
  Supplier<Boolean> isFinished;

  public SetSolenoids(DoubleSolenoids doubleSolenoids, Supplier<Value> value, Supplier<Boolean> isFinished) {
    addRequirements(doubleSolenoids);
    this.value = value;
    this.doubleSolenoids = doubleSolenoids;
    this.isFinished = isFinished;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    this.doubleSolenoids.setSolenoids(value.get());
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return this.isFinished.get();
  }
}
