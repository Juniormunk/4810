package org.usfirst.frc.team4810.robot.commands;

import org.usfirst.frc.team4810.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command allows driver control of the wheels.
 */
public class DriveCommand extends Command
{

	public DriveCommand()
	{
		requires(Robot.driveTrain);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.driveTrain.driveArcade(Robot.oi.driver.getLeftStickY(), Robot.oi.driver.getRightStickX());// you can add a negative infront of this to invert the selected axis( EX: -Robot.oi.driver.getRightStickX())
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
		System.out.println("DriveCommand was interupted(Don't be worried unless this happens durring the middle of the match).");
	}
}
