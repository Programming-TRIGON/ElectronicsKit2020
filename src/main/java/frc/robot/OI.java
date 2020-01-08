package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * This class is the place where we do the joystick stuff 
 */
public class OI {

    private XboxController driver;

    public OI(){
        this.driver = new XboxController(0);
    }

    public double getY(Hand hand){
        return this.driver.getY(hand);
    }
}
