/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

  /**
   * Creates a new Motor, and hold all the functions of said motor.
   */
public class Motors extends SubsystemBase {
  VictorSP motors[];

  public Motors(int... motors) {
    for (int i = 0; i < this.motors.length; i++) {
      this.motors[i] = new VictorSP(motors[i]);
    }
  }

  public Motors(){
  }

  public void moveMotors(double power){
    for (VictorSP victor : this.motors){
    victor.set(power);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
