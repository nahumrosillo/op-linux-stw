package com.linux.stw.controller;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;
import com.linux.stw.util.XBox360;

/**
 * Created by nahum on 08/02/17.
 */
public class XBox360PadListener extends ListenerController
{
    public boolean isConnected;
    public XBox360PadListener(ProfileControl profile)
    {
        isConnected = false;
        this.profile = profile;
    }

    @Override
    public void connected(Controller controller)
    {
        isConnected = true;
    }

    @Override
    public void disconnected(Controller controller)
    {
        isConnected = false;
    }

    @Override
    public boolean buttonDown(Controller controller, int buttonCode)
    {
        if (buttonCode == XBox360.BUTTON_A)
            profile.buttonA();
        if (buttonCode == XBox360.BUTTON_B)
            profile.buttonB();
        if (buttonCode == XBox360.BUTTON_X)
            profile.buttonX();
        if (buttonCode == XBox360.BUTTON_Y)
            profile.buttonY();

        if (buttonCode == XBox360.BUTTON_RB)
            profile.buttonRB();
        if (buttonCode == XBox360.BUTTON_LB)
            profile.buttonLB();

        if (buttonCode == XBox360.BUTTON_START)
            profile.start();
        if (buttonCode == XBox360.BUTTON_BACK)
            profile.select();

        return false;
    }

    @Override
    public boolean buttonUp(Controller controller, int buttonCode)
    {
        return false;
    }

    @Override
    public boolean axisMoved(Controller controller, int axisCode, float value)
    {
        // This is your analog stick
        // Value will be from -1 to 1 depending how far left/right, up/down the stick is
        // For the Y translation, I use a negative because I like inverted analog stick

        return false;
    }

    @Override
    public boolean povMoved(Controller controller, int povCode, PovDirection value)
    {
        if(value == XBox360.BUTTON_DPAD_LEFT)
            profile.padLeft();
        if(value == XBox360.BUTTON_DPAD_RIGHT)
            profile.padRight();
        if(value == XBox360.BUTTON_DPAD_UP)
            profile.padUp();
        if(value == XBox360.BUTTON_DPAD_DOWN)
            profile.padDown();

        return false;
    }

    @Override
    public boolean xSliderMoved(Controller controller, int sliderCode, boolean value)
    {
        return false;
    }

    @Override
    public boolean ySliderMoved(Controller controller, int sliderCode, boolean value)
    {
        return false;
    }

    @Override
    public boolean accelerometerMoved(Controller controller, int accelerometerCode, Vector3 value)
    {
        return false;
    }
}