package org.usfirst.frc.team4810.robot.commands;

import org.usfirst.frc.team4810.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ShootCommand extends InstantCommand
{
	double power;

	public ShootCommand(double power)
	{
		requires(Robot.shooter);
		this.power = power;
	}

	protected void initialize()
	{
		Robot.shooter.setShootPower(power);
	}
}
