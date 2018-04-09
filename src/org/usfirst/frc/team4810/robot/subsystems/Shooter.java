package org.usfirst.frc.team4810.robot.subsystems;

import org.usfirst.frc.team4810.robot.RobotMap;
import org.usfirst.frc.team4810.robot.commands.IntakeCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem
{
	TalonSRX leftShootFront, rightShootFront,leftShootBack, rightShootBack;

	public Shooter()
	{
		leftShootFront = new TalonSRX(RobotMap.leftShootFront);
		leftShootBack = new TalonSRX(RobotMap.leftShootBack);
		rightShootFront = new TalonSRX(RobotMap.rightShootFront);
		rightShootBack = new TalonSRX(RobotMap.rightShootBack);
		
		enableCurrentLimit();
	}

	public void setInverted()
	{
		leftShootFront.setInverted(true);
		leftShootBack.setInverted(true);
		rightShootFront.setInverted(false);
		rightShootBack.setInverted(false);
	}

	public void setShootPower(double power)
	{
		leftShootFront.set(ControlMode.PercentOutput, power);
		leftShootBack.set(ControlMode.PercentOutput, power);
		rightShootFront.set(ControlMode.PercentOutput, power);
		rightShootBack.set(ControlMode.PercentOutput, power);

	}

	private void enableCurrentLimit()
	{
		leftShootFront.configPeakCurrentLimit(35, 10);
		leftShootBack.configPeakCurrentLimit(35, 10);
		rightShootFront.configPeakCurrentLimit(35, 10);
		rightShootBack.configPeakCurrentLimit(35, 10);

		leftShootFront.configPeakCurrentDuration(200, 10);
		leftShootBack.configPeakCurrentDuration(200, 10);
		rightShootFront.configPeakCurrentDuration(200, 10);
		rightShootBack.configPeakCurrentDuration(200, 10);


		leftShootFront.configContinuousCurrentLimit(35, 10);
		leftShootBack.configContinuousCurrentLimit(35, 10);
		rightShootFront.configContinuousCurrentLimit(35, 10);
		rightShootBack.configContinuousCurrentLimit(35, 10);


		leftShootFront.enableCurrentLimit(true);
		leftShootBack.enableCurrentLimit(true);
		rightShootFront.enableCurrentLimit(true);
		rightShootBack.enableCurrentLimit(true);

	}

	public void initDefaultCommand()
	{

	}
}
