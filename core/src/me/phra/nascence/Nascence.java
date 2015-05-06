package me.phra.nascence;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Nascence implements ApplicationListener {
    private SpriteBatch batch;
    private Texture texture;
    private Sprite sprite;
    private BitmapFont debug;
    private int width;
    private int height;

    @Override
    public void create() {
        batch = new SpriteBatch();
        texture = new Texture("male.png");
        sprite = new Sprite(texture);
        debug = new BitmapFont();
        debug.setColor(Color.BLACK);
    }

    @Override
    public void resize(int width, int height) {
        Gdx.gl.glViewport(0, 0, width, height);
        this.width = width;
        this.height = height;
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        sprite.setPosition(0, 0);
        sprite.draw(batch);
        debug.draw(batch, getDebug(), 0, this.height);
        batch.end();
    }

    private String getDebug() {
        return "nascence" + "\n" +
                "height=" + this.height + "\n" +
                "width=" + this.width + "\n" +
                "fullscreen=" + Gdx.graphics.isFullscreen() + "\n" +
                "rendercalls=" + batch.renderCalls + "\n" +
                "totalrendercalls=" + batch.totalRenderCalls + "\n" +
                "deltatime=" + Gdx.graphics.getDeltaTime() + "\n" +
                "fps=" + Gdx.graphics.getFramesPerSecond() + "\n";
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        debug.dispose();
        texture.dispose();
        batch.dispose();
    }
}
