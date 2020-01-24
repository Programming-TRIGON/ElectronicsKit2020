package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotComponents;

public class SensorCheck extends CommandBase {
  private static final double kTimeToWait = 1;
  private double initTime;
  private double initSensorPosition;
  private boolean hasFoundError;


  /**
   * Creates a new SensorCheck.
   */
  public SensorCheck() {
  }

  @Override
  public void initialize() {
    hasFoundError = false;
    initTime = Timer.getFPGATimestamp();
    initSensorPosition = RobotComponents.talonright.getSelectedSensorPosition();    
  }

  @Override
  public void execute() {
    Robot.motorOneAndThree.moveMotors(0.1);
    if((Timer.getFPGATimestamp() - initTime) >= (kTimeToWait * 0.75)) {
      if(!hasFoundError && initSensorPosition == RobotComponents.talonright.getSelectedSensorPosition()) {
        System.out.println("!!!!!!!!!!! Sensor disconnect !!!!!!!!!!!");
        hasFoundError = true;
      }
    }
  }

  @Override
  public boolean isFinished() {
    return Timer.getFPGATimestamp() - initTime >= kTimeToWait;
  }

  @Override
  public void end(boolean interrupted) {
    Robot.motorOneAndThree.moveMotors(0);
  }
}
