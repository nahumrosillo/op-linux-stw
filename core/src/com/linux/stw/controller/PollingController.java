package com.linux.stw.controller;

import com.badlogic.gdx.controllers.Controller;

/**
 * Created by nahum on 10/02/17.
 */
public abstract class PollingController
{
    protected Controller controller;
    protected ProfileControl profile;

    public void setProfileControl(ProfileControl profile)
    {
        this.profile = profile;
    }
    public void setController(Controller controller) { this.controller = controller; }

    abstract void processButtons();
    abstract void processAxis();
    abstract void processAccelerometer();
    abstract void processPov();
    abstract void processSliderX();
    abstract void processSliderY();

    void setAccelerometerSensitive(float value)
    {
        controller.setAccelerometerSensitivity(value);
    }

    public void update()
    {
        processButtons();
        processAxis();
        processAccelerometer();
        processPov();
        processSliderX();
        processSliderY();
    }
}
