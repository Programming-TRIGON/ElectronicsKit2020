package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * This class holds all the components of the robot.
 */
public class RobotComponents {

    // public static final VictorSP VICTOR_SP_ONE = new VictorSP(RobotMap.VICTOR_SP_ONE);
    // public static final VictorSP VICTOR_SP_TWO = new VictorSP(RobotMap.VICTOR_SP_TWO);
    // public static final VictorSP VICTOR_SP_THREE = new VictorSP(RobotMap.VICTOR_SP_THREE);

public static final WPI_TalonSRX talonleft = new WPI_TalonSRX(RobotMap.LEFT_TALON_SHOOTER);
public static final WPI_TalonSRX talonright = new WPI_TalonSRX(RobotMap.RIGHT_TALON_SHOOTER);

/*
    public static final DoubleSolenoid DOUBLE_SOLENOID_ONE = new DoubleSolenoid(RobotMap.DOUBLE_SOLENOID_ONE_CHANNEL_A,
            RobotMap.DOUBLE_SOLENOID_ONE_CHANNEL_B);
    public static final DoubleSolenoid DOUBLE_SOLENOID_TWO = new DoubleSolenoid(RobotMap.DOUBLE_SOLENOID_TWO_CHANNEL_A,
            RobotMap.DOUBLE_SOLENOID_TWO_CHANNEL_B);
    public static final DoubleSolenoid DOUBLE_SOLENOID_THREE = new DoubleSolenoid(
            RobotMap.DOUBLE_SOLENOID_THREE_CHANNEL_A, RobotMap.DOUBLE_SOLENOID_THREE_CHANNEL_B);
*/
}
