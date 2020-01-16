package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.MoveMotors;

/**
 * This class is the place where we do the joystick stuff
 */
public class OI {
    private JoystickButton buttonA;
    private XboxController driver;

    public OI() {
       // driver = new XboxController(0);
       // buttonA = new JoystickButton(driver, Button.kA.value);
        // buttonA.whileHeld(new MoveMotors(Robot.motorOneAndThree, () -> SmartDashboard.getNumber("motor power: ", 0),
        //        () -> false));
    }

    public XboxController getXboxController() {
        return this.driver;
    }

}
