package frc.robot.commands;

import java.util.function.Supplier;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpiutil.math.MathUtil;

public class ShooterAmpPID extends CommandBase {
  PIDController pidController;
  Supplier<Double> kP;
  Supplier<Double> kI;
  Supplier<Double> kD;
  Supplier<Double> setpoint;
  Supplier<Double> offset;
  Supplier<Double> waitTime;
  WPI_TalonSRX motor;
  Supplier<Boolean> isFinished;
  double startTime;
  

  /**
   * This class does PID on the shooter motors based on the ampere value.
   */
  public ShooterAmpPID(Supplier<Double> kP, Supplier<Double> kI, Supplier<Double> kD,
      Supplier<Double> setpoint, WPI_TalonSRX motor, Supplier<Boolean> isFinished, Supplier<Double> waitTime, Supplier<Double> offset) {
    this.kP = kP;
    this.kI = kI;
    this.kD = kD;
    this.setpoint = setpoint;
    this.motor = motor;
    this.isFinished = isFinished;
    this.waitTime = waitTime;
    this.offset = offset;
  }

  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
    pidController = new PIDController(kP.get(), kI.get(), kD.get());
    pidController.setSetpoint(Math.abs(setpoint.get()));
  }

  @Override
  public void execute() {
    if (Timer.getFPGATimestamp() > startTime + waitTime.get())
      motor.set(MathUtil.clamp(pidController.calculate(motor.getStatorCurrent()) + offset.get(), 0, 1));
    else 
      motor.set(offset.get());
  }

  @Override
  public void end(boolean interrupted) {
    pidController.close();
    motor.set(0);
  }

  @Override
  public boolean isFinished() {
    return isFinished.get();
  }
}
