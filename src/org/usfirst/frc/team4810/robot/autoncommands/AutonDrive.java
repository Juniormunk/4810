package org.usfirst.frc.team4810.robot.autoncommands;

import org.usfirst.frc.team4810.robot.Robot;
import org.usfirst.frc.team4810.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonDrive extends Command
{
	double setpoint = 0;

	public AutonDrive(double inches, double seconds)
	{
		requires(Robot.driveTrain);
		setpoint=Robot.driveTrain.rfPID.InToEnc(inches, RobotMap.WheelDia);
		this.setTimeout(seconds);
	}

	protected void initialize()
	{
		Robot.driveTrain.rfPID.setupOnTarget(500, 10);
		Robot.driveTrain.lfPID.setupOnTarget(500, 10);

		Robot.driveTrain.rfPID.setPIDF(RobotMap.drivePID);
		Robot.driveTrain.lfPID.setPIDF(RobotMap.drivePID);

		Robot.driveTrain.rfPID.setPosSetpoint(setpoint);
		Robot.driveTrain.lfPID.setPosSetpoint(setpoint);
	}

	protected void execute()
	{

	}

	protected boolean isFinished()
	{
		return Robot.driveTrain.rfPID.onTarget()&&Robot.driveTrain.lfPID.onTarget()||this.isTimedOut();
	}

	protected void end()
	{
		Robot.driveTrain.rfPID.stopPID();
		Robot.driveTrain.lfPID.stopPID();
	}

	protected void interrupted()
	{
		end();
	}
}
