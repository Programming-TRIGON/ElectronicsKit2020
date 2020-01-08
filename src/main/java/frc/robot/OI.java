package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is the place where we do the joystick stuff 
 */
public class OI {
    private XboxController driver;

    public OI(){
        this.driver = new XboxController(0);
    }

    public XboxController getXboxController(){
        return this.driver;
    }
}
