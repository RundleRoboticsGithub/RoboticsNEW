// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class LimelightShooter extends CommandBase {
  
  static double shooterArea;
  static double shooterSpeed;
  
  /** Creates a new LimelightShooter. */
  public LimelightShooter(Shooter shooter) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Limelight.enableLimelight();
    // get area for calculations
    shooterArea = Limelight.getTargetArea();

    // calculate shooter speed from shooter area
    shooterSpeed = ((-0.00027*shooterArea) + 1.17456) * Shooter.getFactor();

    // set shooter speeds
    Shooter.setShooterSpeeds(shooterSpeed);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Shooter.setShooterSpeeds(0);
    Limelight.disableLimelight();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
