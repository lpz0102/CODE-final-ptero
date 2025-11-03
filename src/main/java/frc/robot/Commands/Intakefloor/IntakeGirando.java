package frc.robot.Commands.Intakefloor;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystem.IntakeFloor;

public class IntakeGirando extends Command {
    private final IntakeFloor intake;
    private final double velocidadeGirando = 1.0;

    public IntakeGirando(IntakeFloor intake) {
        this.intake = intake;
        addRequirements(intake);
    }
 
    @Override
    public void execute() {
        intake.intakeCleitaoMotor.set(velocidadeGirando);
    }

    @Override
    public void end(boolean interrupted) {
        intake.intakeCleitaoMotor.set(0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}