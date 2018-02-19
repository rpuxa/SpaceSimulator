package ru.elonmusk.simulator.utils;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public final class GestureListener extends InputListener {
    GestureDetector detector;
    GestureExtendedAdapter adapter;

    public GestureListener(GestureExtendedAdapter adapter) {
        this.adapter = adapter;
        detector = new GestureDetector(adapter);
    }

    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        adapter.event = event;
        return detector.touchDown(x, y, pointer, button);
    }

    @Override
    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
        adapter.event = event;
        detector.touchUp(x, y, pointer, button);
    }

    @Override
    public void touchDragged (InputEvent event, float x, float y, int pointer) {
        adapter.event = event;
        detector.touchDragged(x, y, pointer);
    }

    @Override
    public boolean mouseMoved (InputEvent event, float x, float y) {
        return false;
    }

    @Override
    public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
    }

    @Override
    public void exit (InputEvent event, float x, float y, int pointer, Actor toActor) {
    }

    @Override
    public boolean scrolled (InputEvent event, float x, float y, int amount) {
        return false;
    }

    @Override
    public boolean keyDown (InputEvent event, int keycode) {
        adapter.event = event;
        return detector.keyDown(keycode);
    }

    @Override
    public boolean keyUp (InputEvent event, int keycode) {
        adapter.event = event;
        return detector.keyUp(keycode);
    }

   @Override
    public boolean keyTyped (InputEvent event, char character) {
       adapter.event = event;
       return detector.keyTyped(character);
    }

    public static class GestureExtendedAdapter extends GestureDetector.GestureAdapter {
        InputEvent event;

        @Override
        public boolean touchDown(float x, float y, int pointer, int button) {
            return true;
        }

        public InputEvent getInputEvent() {
            return event;
        }
    }
}
