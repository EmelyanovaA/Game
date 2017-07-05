package info.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

import info.drop.levels.Level1;

class MenuScreen implements Screen {

    final Drop game;
    OrthographicCamera camera;
    Texture start;

    public MenuScreen(final Drop gam) {
        game = gam;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        start = new Texture("Start.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(start, 100, 360);
//        game.font.draw(game.batch, "Start", 100, 400);
        game.batch.end();
        if(Gdx.input.justTouched() && Gdx.input.getX() >= 100 && Gdx.input.getX() <= 150 &&
                Gdx.input.getY() >= 90 && Gdx.input.getY() <= 120){
            game.setScreen(new Level1(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
