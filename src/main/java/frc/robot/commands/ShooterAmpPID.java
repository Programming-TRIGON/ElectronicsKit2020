package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShooterAmpPID extends CommandBase {
  /**
   * This class does PID on the shooter motors based on the ampere value.
   */
  public ShooterAmpPID(Motors motors) {
    addRequirements(motors);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
