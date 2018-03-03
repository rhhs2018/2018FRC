package org.usfirst.frc.team6593.robot.commands;

import org.usfirst.frc.team6593.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PickUpLift extends Command {

    public PickUpLift() {
    	requires(Robot.pickuplift);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.pickuplift.startRolling(.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
