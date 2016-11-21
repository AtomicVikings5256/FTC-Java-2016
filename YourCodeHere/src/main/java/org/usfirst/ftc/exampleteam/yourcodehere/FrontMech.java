package org.usfirst.ftc.exampleteam.yourcodehere;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.swerverobotics.library.SynchronousOpMode;

/**
 *
 */
@TeleOp(name="FrontMech")
public class FrontMech extends SynchronousOpMode
    {
    /* Declare here any fields you might find useful. */
    DcMotor mFrontMech = null;


    @Override public void main() throws InterruptedException
        {
        /* Initialize our hardware variables. Note that the strings used here as parameters
         * to 'get' must correspond to the names you assigned during the robot configuration
         * step you did in the FTC Robot Controller app on the phone.
         */
        this.mFrontMech =  this.hardwareMap.dcMotor.get("motorFrontMech");

        // Initalize Motors
        mFrontMech.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Wait for the game to start
        waitForStart();

        // Reverse Motor

        // Go go gadget robot!
        while (opModeIsActive())
            {
            if (updateGamepads())
                {
                mFrontMech.setPower(gamepad2.right_stick_x);//come back depending on driver
                }
                }

            telemetry.update();
            idle();
            }
        }

