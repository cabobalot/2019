package frc.robot;

import easypath.EasyPath;
import easypath.EasyPathConfig;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotInit {
	//SendableChooser for Drive controller
	public static final String kFlightStickDrive = "Flight Stick Drive";
	public static final String kGamePadArcadeDrive = "Game Pad Arcade Drive";
	public static final String kGamePadTankDrive = "Game Pad Tank Drive";
	public static final String kGamePadStickDrive = "Game Pad Stick Drive";
	private static final SendableChooser<String> driveChooser = new SendableChooser<>();

	//SendableChooser for Operate controller
	public static final String kFlightStickOperate = "Flight Stick Operate";
	public static final String kGamePadOperate = "Game Pad Operate";
	private static final SendableChooser<String> operateChooser = new SendableChooser<>();

	//SendableChooser for Side preference
	public static final String kLeftPreference = "Left";
	public static final String kRightPreference = "Right";
	private static final SendableChooser<String> sideChooser = new SendableChooser<>();

	//SendableChooser for Auto
	//TODO: populate with auto options
	public static final String kDefaultAuto = "Default";
	public static final String kRightToRightFarBay = "Right - Right Far Bay";
	private static final SendableChooser<String> autoChooser = new SendableChooser<>();

	public static void init(DrivetrainInterface drivetrain) {
		driveChooser.setDefaultOption(kFlightStickDrive, kFlightStickDrive);
		driveChooser.addOption(kGamePadArcadeDrive, kGamePadArcadeDrive);
		driveChooser.addOption(kGamePadTankDrive, kGamePadTankDrive);
		driveChooser.addOption(kGamePadStickDrive, kGamePadStickDrive);
		SmartDashboard.putData("Drive Choice", driveChooser);

		operateChooser.setDefaultOption(kFlightStickOperate, kFlightStickOperate);
		operateChooser.addOption(kGamePadOperate, kGamePadOperate);
		SmartDashboard.putData("Operate Choice", operateChooser);

		sideChooser.addOption(kLeftPreference, kLeftPreference);
		sideChooser.setDefaultOption(kRightPreference, kRightPreference);
		SmartDashboard.putData("Side Choice", sideChooser);

		autoChooser.setDefaultOption("Default Auto", kDefaultAuto);
		autoChooser.addOption("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto Choice", autoChooser);

		EasyPathConfig pathConfig = new EasyPathConfig(
				drivetrain::setLeftRightDriveSpeed,
				drivetrain::getInchesTraveled,
				drivetrain::getCurrentAngle,
				drivetrain::resetEncodersAndGyro,
				0.05
		);
		EasyPath.configure(pathConfig);
	}

	public static SendableChooser<String> getDriveChooser() {
		return driveChooser;
	}

	public static SendableChooser<String> getOperateChooser() {
		return operateChooser;
	}

	public static SendableChooser<String> getSideChooser() {
		return sideChooser;
	}

	public static SendableChooser<String> getAutoChooser() {
		return autoChooser;
	}
}

