package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Shooter extends SubsystemBase {
    private static final double SECONDS_FROM_NEUTRAL_TO_FULL = 0.5;
    private WPI_TalonSRX left, right;
    public Shooter() {
        left = new WPI_TalonSRX(RobotMap.LEFT_TALON_SHOOTER);
        right = new WPI_TalonSRX(RobotMap.RIGHT_TALON_SHOOTER);
        right.configOpenloopRamp(SECONDS_FROM_NEUTRAL_TO_FULL);
        left.configOpenloopRamp(SECONDS_FROM_NEUTRAL_TO_FULL);
    }

    public void setSpeed(double speed) {
        left.set(SmartDashboard.getNumber("leftSpeed", 1) *
                speed);
        right.set(speed);
    }

    public double getVelocity() {
        return right.getSelectedSensorVelocity() * 10.0 / 4096;
    }

}

