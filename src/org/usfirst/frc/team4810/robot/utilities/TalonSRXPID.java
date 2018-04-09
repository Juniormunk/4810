package org.usfirst.frc.team4810.robot.utilities;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class TalonSRXPID
{
	private TalonSRX talon;

	private int maxLoopNumber = 0;
	private int onTargetCounter = 0;
	private int allowedErrorRange = 0;

	public TalonSRXPID(TalonSRX talon, PID pid)
	{
		this.talon = talon;
		this.talon.config_kP(0, pid.p, 0);
		this.talon.config_kI(0, pid.i, 0);
		this.talon.config_kD(0, pid.d, 0);
		this.talon.config_kF(0, pid.f, 0);
	}

	public void setPIDF(PID pid)
	{

		this.talon.config_kP(0, pid.p, 0);
		this.talon.config_kI(0, pid.i, 0);
		this.talon.config_kD(0, pid.d, 0);
		this.talon.config_kF(0, pid.f, 0);

	}

	public double FtToEnc(double ft, double diam)
	{
		return 0.0;
	}

	public boolean onTarget()
	{

		if (Math.abs(talon.getClosedLoopError(0)) <= allowedErrorRange)
		{
			onTargetCounter++;
		}
		else
		{
			onTargetCounter = 0;
		}
		if (maxLoopNumber <= onTargetCounter)
		{
			return true;
		}
		return false;

	}

	public void setupOnTarget(int ticks, int maxLoopNumber)
	{
		onTargetCounter = 0;
		talon.configAllowableClosedloopError(0, ticks, 10);
		allowedErrorRange = ticks;
		this.maxLoopNumber = maxLoopNumber;
	}

	public void setPosSetpoint(int ticks)
	{
		talon.set(ControlMode.Position, ticks);
	}

	public void setVelSetpoint(int ticks)
	{
		talon.set(ControlMode.Position, ticks);
	}

	public void stopPID()
	{
		talon.set(ControlMode.PercentOutput, 0);
	}

}
