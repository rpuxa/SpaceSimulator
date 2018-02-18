package ru.elonmusk.simulator.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import ru.elonmusk.simulator.SpaceSimulator;

public class DesktopLauncher {

	public static void main (String[] arg) {
		System.setProperty("user.name", "seconduser");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new SpaceSimulator(), config);
	}
}
