// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  TalonSRX r_shoot;


  public Shooter() {
    this.r_shoot = new TalonSRX(Constants.RIGHT_SHOOTER);
    this.r_shoot.setNeutralMode(NeutralMode.Brake);
  }

  public void setPower(double power) {
    r_shoot.set(ControlMode.PercentOutput, power);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
