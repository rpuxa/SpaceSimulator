package ru.elonmusk.simulator.constructor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class Constructor implements Screen {

    private SpriteBatch batch;
    public SpacecraftInfo spacecraft = new SpacecraftInfo();
    Button button;

    public Constructor(SpriteBatch batch) {
        this.batch = batch;
        button = new Button(new Image(new Texture("badlogic.jpg")).getDrawable(), new Image(new Texture("badlogic.jpg")).getDrawable());
        button.setSize(100, 100);

        button.addListener(event -> {
            System.out.println("asdasdasd");
            return false;
        });
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        batch.begin();
        spacecraft.render(batch, delta);
        button.draw(batch, 1);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {
        Gdx.input.setInputProcessor(getProcessor());
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    private InputProcessor getProcessor() {
        return new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {

                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {

                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {

                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {

                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(int amount) {

                return false;
            }
        };

    }
}
