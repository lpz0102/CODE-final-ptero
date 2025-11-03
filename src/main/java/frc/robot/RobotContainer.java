package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.Subsystem.Traction;
import frc.robot.Subsystem.IntakeFloor;
import frc.robot.Commands.AtivarTurbo;
import frc.robot.Commands.Controller;
import frc.robot.Commands.Intakefloor.IntakeDescendo;
import frc.robot.Commands.Intakefloor.IntakeGirando;

public class RobotContainer {

  // Subsystems
  public final Traction traction = new Traction();
  public final IntakeFloor intakeFloor = new IntakeFloor();

  // Controls
  private final XboxController xbox = new XboxController(0);

  // Buttons (baseados no controle Xbox)
  private final JoystickButton btnIntakeIn = new JoystickButton(xbox, XboxController.Button.kRightBumper.value);
  private final JoystickButton btnIntakeOut = new JoystickButton(xbox, XboxController.Button.kLeftBumper.value);
  private final JoystickButton btnTurbo = new JoystickButton(xbox, 6);

  public RobotContainer() {
    configureBindings();

    // Define que o drive padrão do robô será o comando DriveWithJoystick
    traction.setDefaultCommand(new Controller(traction, xbox));
  }

  private void configureBindings() {

    // Intake controla coral IN (RB pressionado)
    btnIntakeIn.whileTrue(new IntakeDescendo(intakeFloor));

    // Intake controla coral OUT (LB pressionado)
    btnIntakeOut.whileTrue(new IntakeGirando(intakeFloor));

    // Botão A ativa/desativa modo turbo
    btnTurbo.onTrue(new AtivarTurbo(traction));
  }

  public Command getAutonomousCommand() {
    getAutonomousCommand();
    return Commands.print("No autonomous command configured");
  }
}