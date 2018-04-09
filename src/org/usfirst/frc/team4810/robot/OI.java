/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4810.robot;

import org.usfirst.frc.team4810.robot.commands.PistonDownCommand;
import org.usfirst.frc.team4810.robot.commands.PistonUpCommand;
import org.usfirst.frc.team4810.robot.commands.ShootCommand;
import org.usfirst.frc.team4810.robot.commands.ShooterDownCommand;
import org.usfirst.frc.team4810.robot.commands.ShooterUpCommand;
import org.usfirst.frc.team4810.robot.utilities.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
	public XboxController driver = new XboxController(RobotMap.DRIVER);
	public XboxController oper = new XboxController(RobotMap.OPERATOR);
	
	public OI()
	{
		
		oper.buttonBR.whenPressed(new ShooterUpCommand());
		oper.buttonBR.whenReleased(new ShooterDownCommand());
		
		oper.buttonBL.whenPressed(new PistonUpCommand());
		oper.buttonBL.whenReleased(new PistonDownCommand());
		
		oper.buttonA.whenPressed(new ShootCommand(RobotMap.lowShoot));
		oper.buttonB.whenPressed(new ShootCommand(RobotMap.revShoot));
		oper.buttonX.whenPressed(new ShootCommand(RobotMap.medShoot));
		oper.buttonY.whenPressed(new ShootCommand(RobotMap.highShoot));
		
	}
	
	/*
	 * one big comment...
	 * controls
	 * 
	 * 
	 * 
	 * A:	Low
	 * B:	Reverse
	 * X:	Medium
	 * Y:	High
	 * DPAD UP:		High Switch use pistion high speed	
	 * DPAD DOWN:	Low Switch	use pistion low speed RIGHT BUMPER: Raise Shooter LEFTBUMPER: Pistion
	 */
}
