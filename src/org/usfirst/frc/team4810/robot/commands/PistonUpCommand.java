package org.usfirst.frc.team4810.robot.commands;

import org.usfirst.frc.team4810.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class PistonUpCommand extends InstantCommand
{

	public PistonUpCommand()
	{

	}

	protected void initialize()
	{
		Robot.solinoids.piston.forward();
	}

}
