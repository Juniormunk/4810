package org.usfirst.frc.team4810.robot.subsystems;

import org.usfirst.frc.team4810.robot.RobotMap;
import org.usfirst.frc.team4810.robot.utilities.bbDoubleSolenoid;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Solenoids extends Subsystem
{
	public bbDoubleSolenoid piston;
	public bbDoubleSolenoid shooter;

	public Solenoids()
	{
		piston = new bbDoubleSolenoid(RobotMap.intakesolOn, RobotMap.intakesolOff, true); // To change where the pistion starts change the boolean.
		shooter = new bbDoubleSolenoid(RobotMap.shiftersolOn, RobotMap.shiftersolOff, false);// To change where the shooter starts change the boolean.
	}

	public void initDefaultCommand()
	{
	}
}
