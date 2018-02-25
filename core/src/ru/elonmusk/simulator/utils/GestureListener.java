package ru.elonmusk.simulator.utils;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import ru.elonmusk.simulator.constructor.TouchableGroup;

public final class GestureListener extends InputListener {
    GestureDetector detector;
    GestureExtendedAdapter adapter;

    public GestureListener() {
        this.adapter = new GestureExtendedAdapter();
        detector = new GestureDetector(adapter);
    }

    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        adapter.event = event;
        return detector.touchDown(x, y, pointer, button);
    }

    @Override
    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        adapter.event = event;
        detector.touchUp(x, y, pointer, button);
        adapter.touchUp(x, y, pointer, button);
    }

    @Override
    public void touchDragged(InputEvent event, float x, float y, int pointer) {
        adapter.event = event;
        detector.touchDragged(x, y, pointer);
    }

    @Override
    public boolean mouseMoved(InputEvent event, float x, float y) {
        return false;
    }

    @Override
    public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
    }

    @Override
    public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
    }

    @Override
    public boolean scrolled(InputEvent event, float x, float y, int amount) {
        return false;
    }

    @Override
    public boolean keyDown(InputEvent event, int keycode) {
        adapter.event = event;
        adapter.keyDown(keycode);
        return detector.keyDown(keycode);
    }

    @Override
    public boolean keyUp(InputEvent event, int keycode) {
        adapter.event = event;
        return detector.keyUp(keycode);
    }

    @Override
    public boolean keyTyped(InputEvent event, char character) {
        adapter.event = event;
        return detector.keyTyped(character);
    }

    public static class GestureExtendedAdapter implements GestureDetector.GestureListener {
        InputEvent event;

        @Override
        public boolean touchDown(float x, float y, int pointer, int button) {
            TouchableGroup group = getActor();
            return group != null && group.touchDown(x, y, pointer, button);
        }

        public boolean touchUp(float x, float y, int pointer, int button) {
            TouchableGroup group = getActor();
            return group != null && group.touchUp(x, y, pointer, button);
        }

        @Override
        public boolean tap(float x, float y, int count, int button) {
            TouchableGroup group = getActor();
            return group != null && group.touchDown(x, y, count, button);
        }

        @Override
        public boolean longPress(float x, float y) {
            TouchableGroup group = getActor();
            return group != null && group.longPress(x, y);
        }

        @Override
        public boolean fling(float velocityX, float velocityY, int button) {
            TouchableGroup group = getActor();
            return group != null && group.fling(velocityX, velocityY, button);
        }

        @Override
        public boolean pan(float x, float y, float deltaX, float deltaY) {
            TouchableGroup group = getActor();
            return group != null && group.pan(x, y, deltaX, deltaY);
        }

        @Override
        public boolean panStop(float x, float y, int pointer, int button) {
            TouchableGroup group = getActor();
            return group != null && group.panStop(x, y, pointer, button);
        }

        @Override
        public boolean zoom(float initialDistance, float distance) {
            TouchableGroup group = getActor();
            return group != null && group.zoom(initialDistance, distance);
        }

        @Override
        public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
            TouchableGroup group = getActor();
            return group != null && group.pinch(initialPointer1, initialPointer2, pointer1, pointer2);
        }

        @Override
        public void pinchStop() {
            TouchableGroup group = getActor();
            if (group == null)
                return;
            group.pinchStop();
        }

        public void keyDown(int keycode) {
            TouchableGroup group = getActor();
            if (group == null)
                return;
            group.keyDown(keycode);
        }

        public InputEvent getInputEvent() {
            return event;
        }

        private TouchableGroup getActor() {
            Actor e = getInputEvent().getTarget();
            if (e instanceof TouchableGroup)
                return (TouchableGroup) e;
            return null;
        }
    }
}
