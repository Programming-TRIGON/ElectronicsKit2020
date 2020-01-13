package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.MoveMotors;

/**
 * This class is the place where we do the joystick stuff
 */
public class OI {
    private XboxController driver;

    public OI() {
        this.driver = new XboxController(0);

        driver.getAButtonPressed(new MoveMotors(Robot.motorOneAndThree, () -> 0.6, driver::getAButtonReleased));
    }

    public XboxController getXboxController() {
        return this.driver;
    }

}
