// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;

public class Intake extends SubsystemBase {
    private CANSparkMax motor;
    private static Intake instance;

  /** Creates a new ExampleSubsystem. */
  public Intake() {
    motor = new CANSparkMax(11, CANSparkMax.MotorType.kBrushless);
    motor.setInverted(true); 
    motor.setSmartCurrentLimit(30);
  }

  public static Intake getInstance() {
    if (instance == null) {
      instance = new Intake();
    }
    return instance;
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command IntakeCommand(int percent) {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          this.set(percent); 
          /* one-time action goes here */
        });
  }

  public Command OuttakeCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  public void set(double percent) {
    motor.set(percent);
  }

  public Command runIntakeCommand(double percent) {
    return new StartEndCommand(() -> this.set(percent), () -> this.set(0.0), this);
  }

  public Command autoIntakeCommand() {
    return new SequentialCommandGroup(new InstantCommand(() -> this.set(Constants.MotorSpeeds.kIntakeSpeed)), new WaitCommand(2), new InstantCommand(() -> this.set(0.0)));
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
