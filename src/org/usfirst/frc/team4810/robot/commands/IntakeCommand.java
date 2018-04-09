package org.usfirst.frc.team4810.robot.commands;

import org.usfirst.frc.team4810.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeCommand extends Command
{

	public IntakeCommand()
	{
		requires(Robot.intake);
	}

	protected void initialize()
	{
		
	}

	protected void execute()
	{
		Robot.intake.setIntakePower(Robot.oi.driver.getLeftTrigger()-Robot.oi.driver.getRightTrigger());
	}

	protected boolean isFinished()
	{
		return false;
	}

	protected void end()
	{
	}

	protected void interrupted()
	{
		System.out.println("Intake was interupted(Don't be worried unless this happens durring the middle of the match).");

	}
}
