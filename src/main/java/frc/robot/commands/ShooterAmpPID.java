package frc.robot.commands;

import java.util.function.Supplier;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.subsystems.Motors;

public class ShooterAmpPID extends CommandBase {
  PIDController pidController;
  Supplier<Double> kP;
  Supplier<Double> kI;
  Supplier<Double> kD;
  Supplier<Double> setpoint;
  WPI_TalonSRX motor;

  /**
   * This class does PID on the shooter motors based on the ampere value.
   */
  public ShooterAmpPID(Supplier<Double> kP, Supplier<Double> kI, Supplier<Double> kD,
      Supplier<Double> setpoint, WPI_TalonSRX motor) {
    this.kP = kP;
    this.kI = kI;
    this.kD = kD;
    this.setpoint = setpoint;
    this.motor = motor;
  }

  @Override
  public void initialize() {
    pidController = new PIDController(kP.get(), kI.get(), kD.get());
    pidController.setSetpoint(setpoint.get());
  }

  @Override
  public void execute() {
    motor.set(MathUtil.clamp(pidController.calculate(motor.getStatorCurrent()), -1, 1));
  }

  @Override
  public void end(boolean interrupted) {
    pidController.close();
    motor.set(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
