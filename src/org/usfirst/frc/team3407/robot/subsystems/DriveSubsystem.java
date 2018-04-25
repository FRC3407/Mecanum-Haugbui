/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3407.robot.subsystems;

import org.usfirst.frc.team3407.robot.RobotMap;
import org.usfirst.frc.team3407.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private Victor 	frontLeft = new Victor(RobotMap.FRONT_LEFT_MOTOR);
	private Victor 	frontRight = new Victor(RobotMap.FRONT_RIGHT_MOTOR);
	private Victor 	backLeft = new Victor(RobotMap.BACK_LEFT_MOTOR);
	private Victor 	backRight = new Victor(RobotMap.BACK_RIGHT_MOTOR);
	
	
	
	private MecanumDrive myMecDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		
		//only use if necessary
		//myDrive.setSafetyEnabled(false);
		
		setDefaultCommand(new DriveCommand());
	}
	
	public void mecanum(double y, double x, double z) {
		myMecDrive.driveCartesian(y, x, z);
	}
	
	public void stop() {
		myMecDrive.driveCartesian(0, 0, 0);
	}
}
