package org.usfirst.frc.team4810.robot.subsystems;

import org.usfirst.frc.team4810.robot.RobotMap;
import org.usfirst.frc.team4810.robot.commands.DriveCommand;
import org.usfirst.frc.team4810.robot.utilities.Drive;
import org.usfirst.frc.team4810.robot.utilities.TalonSRXPID;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem
{

	TalonSRX rf, rm, rb, lf, lm, lb;

	Drive drive;
	TalonSRXPID rfPID, lfPID;
	
	AHRS navX = new AHRS(I2C.Port.kOnboard);

	public DriveTrain()
	{
		// Front Talon Construction
		rf = new TalonSRX(RobotMap.rf);// Parameter one is the talon id.
		lf = new TalonSRX(RobotMap.lf);// <
		// Middle Talon Construction
		rf = new TalonSRX(RobotMap.rm);// <
		lf = new TalonSRX(RobotMap.lm);// <
		// Back Talon Construction
		rf = new TalonSRX(RobotMap.rb);// <
		lf = new TalonSRX(RobotMap.lb);// <

		navX.reset(); // Resets all of the navX axis

		// Now were going to configure all of the talon settings like current limiting, and normal voltage

		// Front Motors Nominal Percent
		rf.configNominalOutputForward(0, 0); // parameter one is the normal speed of the motor and the second 0 is the timeout.
		rf.configNominalOutputReverse(0, 0); // <
		lf.configNominalOutputForward(0, 0); // <
		lf.configNominalOutputReverse(0, 0); // <

		// Middle Motors Nominal Percent
		rm.configNominalOutputForward(0, 0); // parameter one is the normal speed of the motor and the second 0 is the timeout.
		rm.configNominalOutputReverse(0, 0); // <
		lm.configNominalOutputForward(0, 0); // <
		lm.configNominalOutputReverse(0, 0); // <

		// Back Motors Nominal Percent
		rb.configNominalOutputForward(0, 0); // parameter one is the normal speed of the motor and the second 0 is the timeout.
		rb.configNominalOutputReverse(0, 0); // <
		lb.configNominalOutputForward(0, 0); // <
		lb.configNominalOutputReverse(0, 0); // <

		//////////////////////////////////////////

		// Front Motors Max-Min Percent
		rf.configPeakOutputForward(1, 0); // parameter one is the max speed of the motor and the second 0 is the timeout.
		rf.configPeakOutputReverse(-1, 0); // <
		lf.configPeakOutputForward(1, 0); // <
		lf.configPeakOutputReverse(-1, 0); // <

		// Middle Motors Max-Min Percent
		rm.configPeakOutputForward(1, 0); // parameter one is the normal speed of the motor and the second 0 is the timeout.
		rm.configPeakOutputReverse(-1, 0); // <
		lm.configPeakOutputForward(1, 0); // <
		lm.configPeakOutputReverse(-1, 0); // <

		// Back Motors Max-Min Percent
		rb.configPeakOutputForward(1, 0); // parameter one is the normal speed of the motor and the second 0 is the timeout.
		rb.configPeakOutputReverse(-1, 0); // <
		lb.configPeakOutputForward(1, 0); // <
		lb.configPeakOutputReverse(-1, 0); // <

		//////////////////////////////////////////

		// Front Motors Sensor Config

		lf.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		rf.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);

		lf.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 10, 10);
		rf.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 10, 10);

		//////////////////////////////////////////

		// Front Motors Clear Sticky Faults
		rf.clearStickyFaults(0);// parameter one is the time out
		lf.clearStickyFaults(0);// <

		// Middle Motors Clear Sticky Faults
		rm.clearStickyFaults(0);// parameter one is the time out
		lm.clearStickyFaults(0);// <

		// Back Motors Clear Sticky Faults
		rb.clearStickyFaults(0);// parameter one is the time out
		lb.clearStickyFaults(0);// <

		//////////////////////////////////////////

		// Front Moters Set Brake Mode
		rf.setNeutralMode(NeutralMode.Brake); // parameter one is setting the talon to brake mode.
		lf.setNeutralMode(NeutralMode.Brake); // <

		// Middle Moters Set Brake Mode
		rm.setNeutralMode(NeutralMode.Brake); // parameter one is setting the talon to brake mode.
		lm.setNeutralMode(NeutralMode.Brake); // <

		// Back Moters Set Brake Mode
		rb.setNeutralMode(NeutralMode.Brake); // parameter one is setting the talon to brake mode.
		lb.setNeutralMode(NeutralMode.Brake); // <

		setInverted();

		drive = new Drive(rf, lf);
		
		
		rfPID=new TalonSRXPID(rf, RobotMap.drivePID);
		lfPID=new TalonSRXPID(lf, RobotMap.drivePID);
		
	}

	private void setInverted()
	{
		lf.setInverted(true);
		rf.setInverted(false);

		lm.setInverted(true);
		rm.setInverted(false);

		lb.setInverted(true);
		rb.setInverted(false);
	}

	public double getAngle()
	{
		return navX.getAngle();
	}

	public void driveArcade(double moveValue, double rotateValue)
	{
		drive.driveArcade(moveValue, rotateValue);
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new DriveCommand());
	}
}
