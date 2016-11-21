package org.usfirst.ftc.exampleteam.yourcodehere;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.swerverobotics.library.SynchronousOpMode;


@Autonomous(name="OurAutonomous")
public class OurAutonomous extends SynchronousOpMode {
    /* Declare here any fields you might find useful. */
    DcMotor motorLeft = null;
    DcMotor motorRight = null;

    //double power;

    @Override
    public void main() throws InterruptedException {
        /* Initialize our hardware variables. Note that the strings used here as parameters
         * to 'get' must correspond to the names you assigned during the robot configuration
         * step you did in the FTC Robot Controller app on the phone.
         */
        this.motorLeft = this.hardwareMap.dcMotor.get("motorLeft");
        this.motorRight = this.hardwareMap.dcMotor.get("motorRight");

        // Initalize Motors
        motorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        motorLeft.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();

        DriveForward(1);
        Thread.sleep(4000);
        TurnRight(1);
        StopDriving();

}
    // Go go gadget robot!
    public void DriveForward(double power) {
        motorLeft.setPower(-power);
        motorRight.setPower(power);
    }
    public void StopDriving(){
        DriveForward(0);
    }
    public void TurnLeft(double power){
        motorLeft.setPower(-power);
        motorRight.setPower(power);
    }
    public void TurnRight(double power){
        TurnLeft(-power);
    }
}
