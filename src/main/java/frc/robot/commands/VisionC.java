
  
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.List;

import frc.robot.subsystems.Vision;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class VisionC extends Command {
  // Creates a new VisionC.

  
  private Drivetrain m_drivetrain;
  private Vision m_vision ; 
 
 

  // How far from the target we want to be
  private final double GOAL_RANGE_METERS = Units.feetToMeters(0);



  public VisionC(Drivetrain drivetrain,Vision vision) {

    m_drivetrain=drivetrain;
    m_vision = vision;
    // Use addRequirements() here to declare subsystem dependencies.
     addRequirements(vision);
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  // @Override
 public void execute() {
  double dif = Math.abs(m_vision.getTrueCenter(0) - m_vision.getYaw(0));
  double length =  m_vision.getTargetsMeters(0);
   

    
    

    
    if ( dif < 1 && length > GOAL_RANGE_METERS ){

      
        m_drivetrain.setRightPower(-.25);
        m_drivetrain.setLeftPower(-.25);
        System.out.println("foward");
      
    } 
    else if ( m_vision.getTrueCenter(0) - m_vision.getYaw(0) > 1  ){
      m_drivetrain.setRightPower(-.05*dif);
        m_drivetrain.setLeftPower(.05*dif);
        System.out.println("turning");

    }
    else if ( m_vision.getTrueCenter(0) - m_vision.getYaw(0) < -.9){
      m_drivetrain.setRightPower(.05*dif);
        m_drivetrain.setLeftPower(-.05*dif);
        System.out.println("turning");

    }
    else {
      m_drivetrain.setRightPower(0);
      m_drivetrain.setLeftPower(0);
      System.out.println("I don't see it");
    }
  

  

  
 
    
 

      

  //     double true_center = (Math.cos(Units.inchesToMeters(3.5/length)));//
  //     double test =Math.abs(target.getYaw() - true_center);

  //     if ( test >= .01 && test<= .01 ){

  //     if (length > GOAL_RANGE_METERS){
  //       m_drivetrain.setRightPower(.5);
  //       m_drivetrain.setLeftPower(.5);
  //     }
  //    }
          
  //         // List<PhotonTrackedTarget> targets = returned.getTargets();
    
  //         // PhotonTrackedTarget target = targets.get(0);
  //         // m_drivetrain.setLeftPower(-test);
  //         // m_drivetrain.setRightPower(-test);
     
  //     // else {
  //     //   m_drivetrain.setLeftPower(0);
  //     //   m_drivetrain.setRightPower(0);
  //     // }

  //    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

