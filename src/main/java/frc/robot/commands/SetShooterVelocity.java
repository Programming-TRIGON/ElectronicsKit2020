package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

import static frc.robot.Robot.shooter;


public class SetShooterVelocity extends CommandBase {

    private final PIDController pidController;

    public SetShooterVelocity() {
        pidController = new PIDController(1, 0, 0);
        pidController.setSetpoint(47.3);
        SmartDashboard.putData("pid", pidController);
    }

    @Override
    public void initialize() {
        pidController.reset();
    }

    @Override
    public void execute() {
        double calculation = pidController.calculate(shooter.getVelocity()) +
                SmartDashboard.getNumber("kF", 0);
        shooter.setSpeed(calculation);
        SmartDashboard.putNumber("error", pidController.getPositionError());
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        shooter.setSpeed(0);
    }
}
