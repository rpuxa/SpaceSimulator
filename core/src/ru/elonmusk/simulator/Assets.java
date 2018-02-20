package ru.elonmusk.simulator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;
import java.util.Map;

public class Assets {
    public final static Map<String, TextureRegion> textures = new HashMap<>();

    public static void load() {
        String[][] names = {
                {"bad", "badlogic.jpg"}
        };
        for (int i = 0; i < names.length; i++) {
            textures.put(names[i][0], new TextureRegion(new Texture(names[i][1])));
        }
    }

    public static TextureRegion getTexture(String name) {
        return textures.get(name);
    }
}
