package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

  /**
   * Creates a new DoubleSolenoids.
   */
public class DoubleSolenoids extends SubsystemBase {
  private int doubleSolenoids[];

  public DoubleSolenoids(int... doubleSolenoids) {
    for(int i = 0; i < doubleSolenoids.length; i++){
    //this.doubleSolenoids[i] = new DoubleSolenoid
    }

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
