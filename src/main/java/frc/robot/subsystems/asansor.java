package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class asansor extends SubsystemBase {
  MotionMagicVoltage mmVoltage = new MotionMagicVoltage(0).withSlot(0);
  TalonFX talon1 = new TalonFX(1);
  TalonFX talon2 = new TalonFX(2);
  TalonFXConfiguration config = new TalonFXConfiguration();

  public asansor() {
    config.Slot0.kS = 0.25;
    config.Slot0.kV = 0.12;
    config.Slot0.kA = 0.01;
    config.Slot0.kP = 4.8;
    config.Slot0.kI = 0;
    config.Slot0.kD = 0.1;

    config.MotionMagic.MotionMagicCruiseVelocity = 80;
    config.MotionMagic.MotionMagicAcceleration = 160;
    config.MotionMagic.MotionMagicJerk = 1600;
    talon2.setControl(new Follower(talon1.getDeviceID(), false));
    talon1.getConfigurator().apply(config);
  }

  public void setAsansor(double position) {
    talon1.setControl(mmVoltage.withPosition(position));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
