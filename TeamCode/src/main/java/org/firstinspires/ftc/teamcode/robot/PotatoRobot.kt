package org.firstinspires.ftc.teamcode.robot

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap
import org.firstinspires.ftc.robotcore.external.Telemetry

class PotatoRobot(hardwareMap: HardwareMap, telemetry: Telemetry) : Robot {

    // Declare OpMode members.
    private val frontLeft: DcMotor
    private val frontRight: DcMotor
    private val backLeft: DcMotor
    private val backRight: DcMotor


    override val name: String
        get() = "Potato"

    init {
        frontLeft = hardwareMap.get(DcMotor::class.java, "front_left")
        frontRight = hardwareMap.get(DcMotor::class.java, "front_right")
        backLeft = hardwareMap.get(DcMotor::class.java, "back_left")
        backRight = hardwareMap.get(DcMotor::class.java, "back_right")

        frontLeft.direction = DcMotorSimple.Direction.FORWARD
        frontRight.direction = DcMotorSimple.Direction.REVERSE
        backLeft.direction = DcMotorSimple.Direction.FORWARD
        backRight.direction = DcMotorSimple.Direction.REVERSE

        frontLeft.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        frontRight.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        backLeft.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        backRight.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE

        this.introduceSelf(telemetry)
    }

    override fun introduceSelf(telemetry: Telemetry) {
        telemetry.addData("Hello!", this.name + " reporting for duty!")
        telemetry.update()
    }

    fun leftMotors(power: Double) {
        frontLeft.power = power
        backLeft.power = power
    }

    fun rightMotors(power: Double) {
        frontRight.power = power
        backRight.power = power
    }

    fun straightDrive(leftPower: Double, rightPower: Double) {
        leftMotors(leftPower)
        rightMotors(rightPower)
    }

    fun strafeLeft(power: Double) {
        frontLeft.power = -power
        frontRight.power = power
        backLeft.power = power
        backRight.power = -power
    }

    fun strafeRight(power: Double) {
        frontLeft.power = power
        frontRight.power = -power
        backLeft.power = -power
        backRight.power = power
    }

}