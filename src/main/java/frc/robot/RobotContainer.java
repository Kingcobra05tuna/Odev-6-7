package frc.robot;

import frc.robot.commands.asansorCmd;
import frc.robot.commands.kiskacCmd;
import frc.robot.subsystems.asansor;
import frc.robot.subsystems.kiskac;
import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  PS5Controller kumanda = new PS5Controller(0);
  kiskac kiskac = new kiskac();
  asansor asansor = new asansor();

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
   new JoystickButton(kumanda , 1).whileTrue(new kiskacCmd(kiskac, 0.5));
   new JoystickButton(kumanda, 2).whileTrue(new kiskacCmd(kiskac, -0.35));
   new JoystickButton(kumanda, 3).onTrue(new asansorCmd(asansor, 0));
   new JoystickButton(kumanda, 4).onTrue(new asansorCmd(asansor, 50));
   //new JoystickButton(kumanda, 5).onTrue(new asansorCmd(asansor, 100));
   //new JoystickButton(kumanda, 6).onTrue(new asansorCmd(asansor, 150));
  }

    public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}