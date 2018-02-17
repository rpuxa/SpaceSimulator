package ru.elonmusk.simulator.utils;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public final class DrawUtils {

    private DrawUtils() {
    }

    public static void drawLine(SpriteBatch batch, int width, int x1, int y1, int x2, int y2) {
        Vector2 from = new Vector2(x1, y1),
                to = new Vector2(x2, y2);
        Pixmap pixmap = new Pixmap(Math.abs(x1 - x2) + width, Math.abs(y1 - y2) + width, Pixmap.Format.RGBA8888);
        width /= 2;
        double angle = Math.atan2(to.y - from.y, to.x - from.x);
        float[] point0 = new float[]{(float) (from.x + width * Math.sin(angle)), (float) (from.y - width * Math.cos(angle))};
        float[] point1 = new float[]{(float) (from.x - width * Math.sin(angle)), (float) (from.y + width * Math.cos(angle))};
        float[] point2 = new float[]{(float) (to.x - width * Math.sin(angle)), (float) (to.y + width * Math.cos(angle))};
        float[] point3 = new float[]{(float) (to.x + width * Math.sin(angle)), (float) (to.y - width * Math.cos(angle))};

        pixmap.fillTriangle(Math.round(point0[0]), Math.round(point0[1]), Math.round(point1[0]), Math.round(point1[1]), Math.round(point2[0]), Math.round(point2[1]));
        pixmap.fillTriangle(Math.round(point2[0]), Math.round(point2[1]), Math.round(point3[0]), Math.round(point3[1]), Math.round(point0[0]), Math.round(point0[1]));

        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        batch.draw(texture, Math.min(x1, x2), Math.min(y1, y2));
    }
}
