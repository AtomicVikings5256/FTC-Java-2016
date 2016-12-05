package org.usfirst.ftc.exampleteam.yourcodehere;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.swerverobotics.library.SynchronousOpMode;

/**
 *
 */
@TeleOp(name="AllMech")
public class AllMech extends SynchronousOpMode {
    /* Declare here any fields you might find useful. */
    DcMotor motorLeft = null;
    DcMotor motorRight = null;
    DcMotor mFrontMech = null;
    DcMotor mLeft = null;
    Servo frontLeft;


    @Override
    public void main() throws InterruptedException {
        /* Initialize our hardware variables. Note that the strings used here as parameters
         * to 'get' must correspond to the names you assigned during the robot configuration
         * step you did in the FTC Robot Controller app on the phone.
         */
        this.motorLeft = this.hardwareMap.dcMotor.get("motorLeft");
        this.motorRight = this.hardwareMap.dcMotor.get("motorRight");
        this.mFrontMech = this.hardwareMap.dcMotor.get("intakeMech");
        this.mLeft = this.hardwareMap.dcMotor.get("liftMech");
        this.frontLeft = this.hardwareMap.servo.get("servo");

        // Initalize Motors
        motorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mFrontMech.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeft.setPosition(0);
        // Wait for the game to start
        waitForStart();

        // Reverse Motor
        motorLeft.setDirection(DcMotor.Direction.REVERSE);

        // Go go gadget robot!
        while (opModeIsActive()) {
            if (updateGamepads()) {
                motorLeft.setPower(-gamepad1.left_stick_y);
                motorRight.setPower(-gamepad1.right_stick_y);
                mFrontMech.setPower(gamepad2.right_stick_y);//come back depending on driver
                mLeft.setPower(gamepad2.left_stick_y);
                if (gamepad2.a) {
                    frontLeft.setPosition(0);
                } else {
                    frontLeft.setPosition(.5);
                }
                if (gamepad2.b) {
                    frontLeft.setPosition(.5);
                } else {
                    frontLeft.setPosition(0);
                }
            }

            telemetry.update();
            idle();
        }
    }

}
