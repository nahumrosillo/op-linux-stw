package com.linux.stw.controller;

import com.badlogic.gdx.controllers.ControllerListener;

/**
 * Created by nahum on 09/02/17.
 */
public abstract class ListenerController implements ControllerListener
{
    ProfileControl profile;

    public void setProfileControl(ProfileControl profile)
    {
        this.profile = profile;
    }
}
