package me.phra.nascence;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Nascence implements ApplicationListener {
    private SpriteBatch batch;
    private Texture texture;
    private BitmapFont debug;

    @Override
    public void create() {
        batch = new SpriteBatch();
        texture = new Texture("badlogic.jpg");
        debug = new BitmapFont();
        debug.setColor(Color.BLACK);
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
        debug.drawMultiLine(batch, getDebug(), 0, Gdx.graphics.getHeight());
        batch.end();
    }

    private String getDebug() {
        StringBuilder sb = new StringBuilder();
        sb.append("height=").append(Gdx.graphics.getHeight()).append("\n");
        sb.append("width=").append(Gdx.graphics.getWidth()).append("\n");
        sb.append("fullscreen=").append(Gdx.graphics.isFullscreen()).append("\n");
        sb.append("rendercalls=").append(batch.renderCalls).append("\n");
        sb.append("totalrendercalls=").append(batch.totalRenderCalls).append("\n");
        sb.append("deltatime=").append(Gdx.graphics.getDeltaTime()).append("\n");
        sb.append("fps=").append(Gdx.graphics.getFramesPerSecond()).append("\n");
        return sb.toString();
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
