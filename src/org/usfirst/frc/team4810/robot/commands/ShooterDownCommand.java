package org.usfirst.frc.team4810.robot.commands;

import org.usfirst.frc.team4810.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ShooterDownCommand extends InstantCommand {

    public ShooterDownCommand() {

    }

    protected void initialize() 
    {
    	Robot.solinoids.shooter.reverse();
    }

}
