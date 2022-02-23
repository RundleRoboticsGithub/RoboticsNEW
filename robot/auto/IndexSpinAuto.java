// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.







public class IntakeSpinAuto extends CommandBase {


  private Indexer indexC;
  private boolean isFinished;
  
  /** Creates a new Intake. */
  public IntakeCommand(Indexer index) {
    // Use addRequirements() here to declare subsystem dependencies.dddr
    IndexC = index;
    addRequirements(index);
    isFinished = False;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Indexer.enableIndexer(0.8);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Indexer.enableIndexer(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isFinished;
  }
  
}
