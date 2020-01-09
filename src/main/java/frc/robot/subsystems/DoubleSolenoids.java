package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** Creates a new DoubleSolenoids. */
public class DoubleSolenoids extends SubsystemBase {
  DoubleSolenoid doubleSolenoids[];

  public DoubleSolenoids(DoubleSolenoid... doubleSolenoids) {
    for (int i = 0; i < doubleSolenoids.length; i++) {
      this.doubleSolenoids[i] = doubleSolenoids[i];
    }
  }

  public void setSolenoids(Value value) {
    for (DoubleSolenoid doubleSolenoid : this.doubleSolenoids) {
      doubleSolenoid.set(value);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
