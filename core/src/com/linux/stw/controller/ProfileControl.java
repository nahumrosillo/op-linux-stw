package com.linux.stw.controller;

import com.linux.stw.controller.commands.*;
import com.linux.stw.controller.commands.CommandControl;


/**
 * Created by nahum on 09/02/17.
 */
public class ProfileControl
{
    private com.linux.stw.controller.commands.CommandControl select, start, buttonA, buttonB, buttonY, buttonX, padUp, padLeft, padRight, padDown,
            buttonLB, buttonRB;

    private com.linux.stw.controller.commands.AxisControl axisLeftX, axisLeftY, axisRightX, axisRightY;

    private Object obj;

    public ProfileControl(Object obj)
    {
        this.obj = obj;

        com.linux.stw.controller.commands.CommandControl nothing = new Nothing();
        com.linux.stw.controller.commands.AxisControl nothingAxis = new NothingAxis();

        axisLeftX = nothingAxis;
        axisLeftY = nothingAxis;
        axisRightX = nothingAxis;
        axisRightY = nothingAxis;

        select = nothing;
        start = nothing;

        buttonA = nothing;
        buttonB = nothing;
        buttonX = nothing;
        buttonY = nothing;

        padUp = nothing;
        padDown = nothing;
        padLeft = nothing;
        padRight = nothing;

        buttonRB = nothing;
        buttonLB = nothing;
    }

    public void setSelect(com.linux.stw.controller.commands.CommandControl select) {
        this.select = select;
    }

    public void setStart(com.linux.stw.controller.commands.CommandControl start) {
        this.start = start;
    }

    public void setButtonA(com.linux.stw.controller.commands.CommandControl buttonA) {
        this.buttonA = buttonA;
    }

    public void setButtonB(com.linux.stw.controller.commands.CommandControl buttonB) {
        this.buttonB = buttonB;
    }

    public void setButtonY(com.linux.stw.controller.commands.CommandControl buttonY) {
        this.buttonY = buttonY;
    }

    public void setButtonX(com.linux.stw.controller.commands.CommandControl buttonX) {
        this.buttonX = buttonX;
    }

    public void setPadUp(com.linux.stw.controller.commands.CommandControl padUp) {
        this.padUp = padUp;
    }

    public void setPadLeft(com.linux.stw.controller.commands.CommandControl padLeft) {
        this.padLeft = padLeft;
    }

    public void setPadRight(com.linux.stw.controller.commands.CommandControl padRight) {
        this.padRight = padRight;
    }

    public void setPadDown(com.linux.stw.controller.commands.CommandControl padDown) {
        this.padDown = padDown;
    }

    public void setButtonLB(com.linux.stw.controller.commands.CommandControl buttonLB) {
        this.buttonLB = buttonLB;
    }

    public void setButtonRB(CommandControl buttonRB) {
        this.buttonRB = buttonRB;
    }

    public void setAxisLeftX(com.linux.stw.controller.commands.AxisControl axisLeftX) {
        this.axisLeftX = axisLeftX;
    }

    public void setAxisLeftY(com.linux.stw.controller.commands.AxisControl axisLeftY) {
        this.axisLeftY = axisLeftY;
    }

    public void setAxisRightX(com.linux.stw.controller.commands.AxisControl axisRightX) {
        this.axisRightX = axisRightX;
    }

    public void setAxisRightY(com.linux.stw.controller.commands.AxisControl axisRightY) {
        this.axisRightY = axisRightY;
    }

    public void setObject(Object obj) {
        this.obj = obj;
    }

    void select()
    {
        select.execute(obj);
    }
    void start()
    {
        start.execute(obj);
    }

    void buttonA()
    {
        buttonA.execute(obj);
    }

    void buttonB()
    {
        buttonB.execute(obj);
    }

    void buttonX()
    {
        buttonX.execute(obj);
    }

    void buttonY()
    {
        buttonY.execute(obj);
    }

    void padUp()
    {
        padUp.execute(obj);
    }

    void padLeft()
    {
        padLeft.execute(obj);
    }

    void padRight()
    {
        padRight.execute(obj);
    }

    void padDown()
    {
        padDown.execute(obj);
    }

    void buttonLB()
    {
        buttonLB.execute(obj);
    }

    void buttonRB()
    {
        buttonRB.execute(obj);
    }

    void axisLeftX(float value) { axisLeftX.update(obj, value); }

    void axisLeftY(float value) { axisLeftY.update(obj, value); }

    void axisRightX(float value) { axisRightX.update(obj, value); }

    void axisRightY(float value) { axisRightY.update(obj, value); }
}
