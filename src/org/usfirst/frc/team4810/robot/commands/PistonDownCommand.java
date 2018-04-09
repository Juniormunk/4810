package org.usfirst.frc.team4810.robot.commands;

import org.usfirst.frc.team4810.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class PistonDownCommand extends InstantCommand
{

	public PistonDownCommand()
	{
		
	}

	protected void initialize()
	{
		Robot.solinoids.piston.reverse();
	}

}
