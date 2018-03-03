package org.usfirst.frc.team6593.robot.subsystems;

import org.usfirst.frc.team6593.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PickUp extends Subsystem {
	private final SpeedController PickUpMech = RobotMap.PickUpMech;
	
	 public void startRolling(double i){
	    	//if(stop == false){
	    		PickUpMech.set(i);
	    	//}else{
	    		//rollingSC.set(0.8);
	    	//}
	    }
	    
	    public void stopRolling(){
	    	PickUpMech.set(0);
	    }
	    public void invertRolling(double i){
	    	PickUpMech.set(i);
	    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

