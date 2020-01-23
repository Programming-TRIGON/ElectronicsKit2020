package frc.robot;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.MoveMotors;
import frc.robot.subsystems.Motors;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  public static OI oi;
  // exm:
  public static Motors motorOneAndThree;

  @Override
  public void robotInit() {
    SmartDashboard.putNumber("motor power: ", 0.0);
    SmartDashboard.putNumber("wait time: ", 0.0);

    RobotComponents.talonright.setNeutralMode(NeutralMode.Coast);
    RobotComponents.talonleft.setNeutralMode(NeutralMode.Coast);
    
    RobotComponents.talonright.configOpenloopRamp(1);
    RobotComponents.talonleft.configOpenloopRamp(1);
    
    ErrorCode err = RobotComponents.talonright.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.None,0,0);
    System.out.println(err.toString());

    if(err != ErrorCode.OK)
      System.out.println("Encoder not found!");

    //RobotComponents.talonright.setInverted(true);
    motorOneAndThree = new Motors(RobotComponents.talonleft, RobotComponents.talonright);
    oi = new OI();
    

    SmartDashboard.putData("move motors",
        new MoveMotors(motorOneAndThree, () -> SmartDashboard.getNumber("motor power: ", 0.0), () -> false,
            () -> SmartDashboard.getNumber("wait time: ", 0.0)));
  }

  

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    SmartDashboard.putNumber("Voltage Right: ", RobotComponents.talonleft.getStatorCurrent());
    SmartDashboard.putNumber("Voltage Left: ", RobotComponents.talonright.getStatorCurrent());
    SmartDashboard.putBoolean("is right on speed: ",
        RobotComponents.talonleft.getStatorCurrent() < 31 && RobotComponents.talonleft.getStatorCurrent() > 27);
    SmartDashboard.putBoolean("is left on speed: ",
        RobotComponents.talonright.getStatorCurrent() < 26 && RobotComponents.talonright.getStatorCurrent() > 23);
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }
}
