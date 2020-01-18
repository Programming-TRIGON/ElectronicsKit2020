/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.Supplier;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Motors;

  /**
   * Creates a new TalonSpeedPID.
   */
public class TalonSpeedPID extends CommandBase {

  WPI_TalonSRX talons[];
  Supplier<Double> velocityOutput;

  public TalonSpeedPID(Motors motors, Supplier<Double> velocityOutput, WPI_TalonSRX... talons) {
    addRequirements(motors);
    this.velocityOutput = velocityOutput;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    talons[1].set(ControlMode.Velocity, velocityOutput.get());
  }

  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
