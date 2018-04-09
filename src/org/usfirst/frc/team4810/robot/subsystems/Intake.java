package org.usfirst.frc.team4810.robot.subsystems;

import org.usfirst.frc.team4810.robot.RobotMap;
import org.usfirst.frc.team4810.robot.commands.IntakeCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem
{
	TalonSRX leftIntake, rightIntake;

	public Intake()
	{
		leftIntake = new TalonSRX(RobotMap.leftIntake);
		rightIntake = new TalonSRX(RobotMap.rightIntake);
		
		enableCurrentLimit();
	}

	public void setInverted()
	{
		leftIntake.setInverted(true);
		rightIntake.setInverted(false);
	}

	public void setIntakePower(double power)
	{
		leftIntake.set(ControlMode.PercentOutput, power);
		rightIntake.set(ControlMode.PercentOutput, power);
	}

	private void enableCurrentLimit()
	{
		leftIntake.configPeakCurrentLimit(35, 10);
		rightIntake.configPeakCurrentLimit(35, 10);

		leftIntake.configPeakCurrentDuration(200, 10);
		rightIntake.configPeakCurrentDuration(200, 10);

		leftIntake.configContinuousCurrentLimit(35, 10);
		rightIntake.configContinuousCurrentLimit(35, 10);

		leftIntake.enableCurrentLimit(true);
		rightIntake.enableCurrentLimit(true);
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new IntakeCommand());
	}
}
