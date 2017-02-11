package com.linux.stw.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.linux.stw.OPLinuxSTWMain;

public class DesktopLauncher
{
	public static void main (String[] arg)
    {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = 400;
		config.height = 800;

		new LwjglApplication(new OPLinuxSTWMain(), config);
	}
}
