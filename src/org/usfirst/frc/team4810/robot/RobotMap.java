/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4810.robot;

import org.usfirst.frc.team4810.robot.utilities.PID;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into to a variable name. This provides flexibility changing wiring, makes checking the wiring easier and significantly reduces the number of magic numbers floating
 * around.
 */
public class RobotMap
{
	public static final int DRIVER = 1;
	public static final int OPERATOR = 0;

	public static int pcm = 10;

	public static int encoderTicksPerRev = 4096;

	// Talon Ids
	public static int rf = 0; // Front Right Talon ID
	public static int lf = 0; // Front Left Talon ID
	public static int rm = 0; // Middle Right Talon ID
	public static int lm = 0; // Middle Left Talon ID
	public static int rb = 0; // Back Right Talon ID
	public static int lb = 0; // Back Left Talon ID
	public static int leftIntake = 0; // Left Intake Talon ID
	public static int rightIntake = 0;// Right Intake Talon ID
	public static int intakesolOn = 0;
	public static int intakesolOff = 0;
	public static int shiftersolOn = 0;
	public static int shiftersolOff = 0;
	public static int leftShootFront = 0;
	public static int rightShootFront = 0;
	public static int leftShootBack = 0;
	public static int rightShootBack = 0;
	// Shoot Speeds
	public static double lowShoot = .4;
	public static double revShoot = -.12;
	public static double medShoot = .7;
	public static double highShoot = .96;

	// Other
	public static final int WheelDia = 6; // Wheel diameter in inches

	public static PID drivePID = new PID(.1, 0, 0, 0);

}
