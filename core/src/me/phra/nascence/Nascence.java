package me.phra.nascence;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Nascence implements ApplicationListener {
    private SpriteBatch batch;
    private Texture texture;
    private BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        texture = new Texture("badlogic.jpg");
        font = new BitmapFont();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(texture, 0, 0);
        font.draw(batch, "nascence", 100, 100);
        batch.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        font.dispose();
        texture.dispose();
        batch.dispose();
    }
}
