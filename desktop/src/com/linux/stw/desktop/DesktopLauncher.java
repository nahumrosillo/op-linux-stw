package com.linux.stw.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.linux.stw.OPLinuxSTWMain;
import com.linux.stw.util.Constants;

public class DesktopLauncher
{
	public static void main (String[] arg)
    {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = (int) Constants.WIDTH_REAL;
		config.height = (int) Constants.HEIGHT_REAL;

		new LwjglApplication(new OPLinuxSTWMain(), config);
	}
}
