package com.linux.stw.controller;

import com.badlogic.gdx.controllers.PovDirection;
import com.linux.stw.util.XBox360;

/**
 * Created by nahum on 10/02/17.
 */
public class XBox360PadPolling extends PollingController
{
    @Override
    void processButtons()
    {
        if (controller.getButton(XBox360.BUTTON_A))
            profile.buttonA();

        if (controller.getButton(XBox360.BUTTON_B))
            profile.buttonB();

        if (controller.getButton(XBox360.BUTTON_X))
            profile.buttonX();

        if (controller.getButton(XBox360.BUTTON_Y))
            profile.buttonY();

        if (controller.getButton(XBox360.BUTTON_START))
            profile.start();

        if (controller.getButton(XBox360.BUTTON_BACK))
            profile.select();

        if (controller.getButton(XBox360.BUTTON_RB))
            profile.buttonRB();

        if (controller.getButton(XBox360.BUTTON_LB))
            profile.buttonLB();
    }

    @Override
    void processAxis()
    {
        float value;

        value = controller.getAxis(XBox360.AXIS_LEFT_Y);
        profile.axisLeftY(value);

        value = controller.getAxis(XBox360.AXIS_LEFT_X);
        profile.axisLeftX(value);

        value = controller.getAxis(XBox360.AXIS_RIGHT_Y);
        profile.axisRightY(value);

        value = controller.getAxis(XBox360.AXIS_RIGHT_X);
        profile.axisRightX(value);
    }

    @Override
    void processAccelerometer()
    {

    }

    @Override
    void processPov()
    {
        PovDirection controllerPOV = controller.getPov(0);

        /** 4-directions
        if (controllerPOV == XBox360.BUTTON_DPAD_UP)
            profile.padUp();
        if (controllerPOV == XBox360.BUTTON_DPAD_DOWN)
            profile.padDown();
        if (controllerPOV == XBox360.BUTTON_DPAD_LEFT)
            profile.padLeft();
        if (controllerPOV == XBox360.BUTTON_DPAD_RIGHT)
            profile.padRight();
         */

        //  8 directions
        if (controllerPOV == XBox360.BUTTON_DPAD_UP || controllerPOV == PovDirection.northEast
                || controllerPOV == PovDirection.northWest)
            profile.padUp();
        if (controllerPOV == XBox360.BUTTON_DPAD_DOWN || controllerPOV == PovDirection.southEast
                || controllerPOV == PovDirection.southWest)
            profile.padDown();
        if (controllerPOV == XBox360.BUTTON_DPAD_LEFT || controllerPOV == PovDirection.northWest
                || controllerPOV == PovDirection.southWest)
            profile.padLeft();
        if (controllerPOV == XBox360.BUTTON_DPAD_RIGHT || controllerPOV == PovDirection.northEast
                || controllerPOV == PovDirection.southEast)
            profile.padRight();
    }

    @Override
    void processSliderX()
    {

    }

    @Override
    void processSliderY()
    {

    }
}
