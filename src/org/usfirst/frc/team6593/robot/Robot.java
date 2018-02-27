// RobotBuilder Version: 2.0
//NEW 2018 ROBOT CODE
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team6593.robot;


import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team6593.robot.commands.Climbing;
import org.usfirst.frc.team6593.robot.commands.MiddleStation;
import org.usfirst.frc.team6593.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static DoubleSolenoid dsolenoid = new DoubleSolenoid(4,5); 
	public static DoubleSolenoid dsolenoid2 = new DoubleSolenoid(6,7);
	public Compressor mainCompressor = new Compressor(0);
	
	
	
    Joystick mainJoystick = new Joystick(0);
    Command autonomousCommand;
 
    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain driveTrain;
    public static Lift lifting;
	public static ClimbingLift climbing;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    RobotMap.init();
    
    lifting = new Lift();

    
    
  
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrain = new DriveTrain();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guarant;eed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        autonomousCommand = new MiddleStation();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        
        
        new Thread(() -> {
            UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
            camera.setResolution(640, 480);
            
            UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture();
            camera1.setResolution(640, 480);
            
            CvSink cvSink = CameraServer.getInstance().getVideo();
            CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
            
            Mat source = new Mat();
            Mat output = new Mat();
            
            while(!Thread.interrupted()) {
                cvSink.grabFrame(source);
                Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
                outputStream.putFrame(output);
            }
            
        }).start();
        
    }
    

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
    	
    	System.out.println("Teleop Activated");
    	
    	if(mainJoystick.getRawButton(5)){
        	dsolenoid.set(DoubleSolenoid.Value.kForward);
        } 
        else if(mainJoystick.getRawButton(7)){
        	dsolenoid.set(DoubleSolenoid.Value.kReverse);
        } 
        else {
        	dsolenoid.set(DoubleSolenoid.Value.kOff);
        }
        
        if(mainJoystick.getRawButton(8)){
        	dsolenoid2.set(DoubleSolenoid.Value.kForward);
        } 
        else if(mainJoystick.getRawButton(3)){
        	dsolenoid2.set(DoubleSolenoid.Value.kReverse);
        } 
        else {
        	dsolenoid2.set(DoubleSolenoid.Value.kOff);
        }
    }
    	   
        /*boolean longPiston = false;
        dsolenoid.set(DoubleSolenoid.Value.kOff);
        if(longPiston == false){
            if(mainJoystick.getRawButton(2)){
            	longPiston = true;
                dsolenoid.set(DoubleSolenoid.Value.kForward);    
            }
            else if(longPiston == true){
                if(mainJoystick.getRawButton(2)){
                	longPiston = false;
                dsolenoid.set(DoubleSolenoid.Value.kReverse);    
                }              
            }
        }
        boolean shortPiston = false;
        dsolenoid2.set(DoubleSolenoid.Value.kForward);
        if(shortPiston == false){
            if(mainJoystick.getRawButton(1)){
            	shortPiston = true;
                dsolenoid2.set(DoubleSolenoid.Value.kReverse);    
            }
            else if(shortPiston == true){
                if(mainJoystick.getRawButton(1)){
                	shortPiston = false;
                dsolenoid2.set(DoubleSolenoid.Value.kForward); 
                }
            }
        }
            
        }*/
    	//boolean longPiston = false;
    	/*boolean toggle = true;
    	 
    	if (toggle && mainJoystick.getRawButton(1)) {  // Only execute once per Button push
    	  toggle = false;  // Prevents this section of code from being called again until the Button is released and re-pressed
    	  if (mainJoystick.getRawButton(1)) {  // Decide which way to set the motor this time through (or use this as a motor value instead)
    	    //longPiston= false;
    	    dsolenoid.set(DoubleSolenoid.Value.kForward);
    	  } else {
    	    //longPiston= true;
    	    dsolenoid.set(DoubleSolenoid.Value.kReverse);
    	  }
    	} else if(mainJoystick.getRawButton(1) == false) { 
    	    toggle = true; // Button has been released, so this allows a re-press to activate the code above.
    	}

    }*/
    
    // Run this only once to initialize the variables
/*boolean beltStatus = false;
boolean previousButton = false;
boolean currentButton = false;

//Run the following code continuously
previousButton = currentButton;
currentButton = mainJoystick.getRawButton(1);

if (currentButton && !previousButton) 
{
	beltStatus = beltStatus ? false : true; 
}

dsolenoid.set(DoubleSolenoid.Value.kReverse);
    }*/

    /**
     * This function is called periodically during test mode
     */ 
    public void testPeriodic() {
        LiveWindow.run();
    }
}

