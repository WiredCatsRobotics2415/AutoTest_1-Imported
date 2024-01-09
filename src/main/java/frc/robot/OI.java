package frc.robot;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class OI {
    private CommandXboxController controller;
    private static OI instance;

    private OI() {
        controller = new CommandXboxController(0); 
    }

    public static OI getInstance() {
        if (instance == null) {
            instance = new OI();
        }

        return instance; 
    }

    public Trigger getOuttakeButton() {
        Trigger outtakeTrigger = controller.a(); //check
        System.out.println("Outtake button pressed");
        return outtakeTrigger;
    }

    public Trigger getIntakeButton() {
        Trigger intakeTrigger = controller.b(); // check
        System.out.println("Intake button pressed");
        return intakeTrigger; 
    }
    
}
