// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
//NEW 2018 ROBOT CODE

package org.usfirst.frc.team6593.robot;

import org.usfirst.frc.team6593.robot.commands.AutoDriveBack;
import org.usfirst.frc.team6593.robot.commands.AutoDriveFastForward;
import org.usfirst.frc.team6593.robot.commands.AutoRotate;
import org.usfirst.frc.team6593.robot.commands.Climbing;
import org.usfirst.frc.team6593.robot.commands.InvertClimbing;
import org.usfirst.frc.team6593.robot.commands.InvertLifting;
import org.usfirst.frc.team6593.robot.commands.Lifting;
import org.usfirst.frc.team6593.robot.commands.StopClimbing;
import org.usfirst.frc.team6593.robot.commands.StopLifting;

import Autonomous.LeftStationLeftColor;
import Autonomous.LeftStationRightColor;
import Autonomous.MiddleStationLeftColor;
import Autonomous.MiddleStationRightColor;
import Autonomous.RightStationLeftColor;
import Autonomous.RightStationRightColor;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton SideButton;
    public JoystickButton Bumper;
    public JoystickButton ElevenButton;
    public JoystickButton TwelveButton;
   

    public Joystick xbox_Joystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        xbox_Joystick = new Joystick(0);

        Bumper = new JoystickButton(xbox_Joystick, 1);
        Bumper.whileHeld(new Lifting());
        Bumper.whenReleased(new StopLifting());
        
        SideButton = new JoystickButton(xbox_Joystick, 2);
        SideButton.whileHeld(new InvertLifting());
        SideButton.whenReleased(new StopLifting());
        
        ElevenButton = new JoystickButton(xbox_Joystick, 11);
        ElevenButton.whileHeld(new Climbing());
        ElevenButton.whenReleased(new StopClimbing());
        
        TwelveButton = new JoystickButton(xbox_Joystick, 12);
        TwelveButton.whileHeld(new InvertClimbing());
        TwelveButton.whenReleased(new StopClimbing());
        
        
        
        // Shooting the ball
        /*r_Bumper = new JoystickButton(xbox_Joystick, 1);
		
        
        // climbing the rope
        FiveButton = new JoystickButton(xbox_Joystick, 5); 

       
       // slowly climbing the rope
       ThreeButton = new JoystickButton(xbox_Joystick, 3); 

       
       // Invert climbing the rope
       SixButton = new JoystickButton(xbox_Joystick, 6);

       
       // slowly Invert climbing the rope
       FourButton = new JoystickButton(xbox_Joystick, 4);*/
        //Compressor com = new Compressor();
	//compressor current
       //SmartDashboard.putNumber("current comp", com.getCompressorCurrent());


        // SmartDashboard Buttons
        SmartDashboard.putData("LeftStationLeftColor", new LeftStationLeftColor());
        SmartDashboard.putData("LeftStationRightColor", new LeftStationRightColor());
        SmartDashboard.putData("RightStationRightColor", new RightStationRightColor());
        SmartDashboard.putData("RightStationLeftColor", new RightStationLeftColor());
        SmartDashboard.putData("MiddleStationLeftColor", new MiddleStationLeftColor());
        SmartDashboard.putData("MiddleStationRightColor", new MiddleStationRightColor());
        
        
        SmartDashboard.putData("AutoDriveStraight", new AutoDriveFastForward(5));
        SmartDashboard.putData("AutoDriveBack", new AutoDriveBack(5));
        SmartDashboard.putData("AutoRoate", new AutoRotate(5));
        
       
        //SmartDashboard.getNumber("UlratraSonicRange", DriveTrain.rangeFinder.getAverageVoltage());
        //SmartDashboard.putNumber("Gyro angle", DriveTrain.gyro.getAngle());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
       // SmartDashboard.putNumber("GyroAngle", DriveTrain.gyro.getAngle());
        
        
    }
    public double getDriveLeftSpeed() {
    	return xbox_Joystick.getRawAxis(1);
    }
    
    public double getDriveRightSpeed() {
    	return xbox_Joystick.getRawAxis(5);
    }
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getXbox_Joystick() {
        return xbox_Joystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

