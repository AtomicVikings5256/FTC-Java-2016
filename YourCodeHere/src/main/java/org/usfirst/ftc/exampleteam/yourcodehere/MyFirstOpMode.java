package org.usfirst.ftc.exampleteam.yourcodehere;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.*;
import org.swerverobotics.library.*;
import org.swerverobotics.library.interfaces.*;

/**
 *
 */
@TeleOp(name="My First OpMode")
public class MyFirstOpMode extends SynchronousOpMode
    {
    /* Declare here any fields you might find useful. */
    DcMotor motorLeft = null;
    DcMotor motorRight = null;
    DcMotor mFrontMech = null;


    @Override public void main() throws InterruptedException
        {
        /* Initialize our hardware variables. Note that the strings used here as parameters
         * to 'get' must correspond to the names you assigned during the robot configuration
         * step you did in the FTC Robot Controller app on the phone.
         */
            this.motorLeft = this.hardwareMap.dcMotor.get("motorLeft");
            this.motorRight = this.hardwareMap.dcMotor.get("motorRight");
            this.mFrontMech = this.hardwareMap.dcMotor.get("intakeMech");


        // Initalize Motors
        motorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mFrontMech.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Wait for the game to start
        waitForStart();

        // Reverse Motor
        motorLeft.setDirection(DcMotor.Direction.REVERSE);

        // Go go gadget robot!
        while (opModeIsActive())
            {
            if (updateGamepads())
                {
                motorLeft.setPower(gamepad1.left_stick_y);
                motorRight.setPower(gamepad1.right_stick_y);
                mFrontMech.setPower(gamepad2.right_stick_x);//come back depending on driver
                }
                }

            telemetry.update();
            idle();
            }
        }

