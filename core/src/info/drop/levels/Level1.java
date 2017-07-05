package info.drop.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import info.drop.Drop;
import info.drop.buttons.ButtonLeft;
import info.drop.buttons.ButtonRight;
import info.drop.buttons.ButtonUp;
import info.drop.human.Human;

public class Level1 implements Screen{

    int iUp = 0;

    boolean up = false;
    boolean gravity = true;

    //Кнопка влево
    Texture buttonLeft;
    Rectangle rectangelLeft;
    ButtonLeft buttonleft = new ButtonLeft();

    //Кнопка ваправо
    Texture buttonRight;
    Rectangle rectangelRight;
    ButtonRight buttonright = new ButtonRight();

    //Кнопка вверх
    Texture buttonUp;
    Rectangle rectangelUp;
    ButtonUp buttonup = new ButtonUp();

    //Человечек
    Texture human;
    Rectangle rectangleHuman;
    Human human1 = new Human();

    //Палки
    Texture downpalka;
    Texture leftpalka;
    Texture balka;

    final Drop game;
    OrthographicCamera camera;
    SpriteBatch batch;
    Vector3 touchPos;

    public Level1 (final Drop gam) {
        this.game = gam;
        touchPos = new Vector3();

        camera = new OrthographicCamera();
        camera.setToOrtho(false,800,480);

        batch = new SpriteBatch();
        //Кнопка вниз
        buttonLeft = new Texture("left.png");
        rectangelLeft = buttonleft.getRectangle();
        //Кнопка вправо
        buttonRight = new Texture("right.png");
        rectangelRight = buttonright.getRectangle();
        //Кнопка вверх
        buttonUp = new Texture("up.png");
        rectangelUp = buttonup.getRectangle();
        //Человечек
        human = new Texture("humanRight.png");
        rectangleHuman = human1.getRectangle();
        //Палки
        downpalka = new Texture("palka.png");
        balka = new Texture("балка.png");
        leftpalka = new Texture("leftpalka.png");
    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        //Отрисока
        game.batch.begin();
        game.batch.draw(buttonLeft, rectangelLeft.x, rectangelLeft.y);//Кнопка влево
        game.batch.draw(buttonRight, rectangelRight.x, rectangelRight.y);//Кнопка вправо
        game.batch.draw(buttonUp, rectangelUp.x, rectangelUp.y);//Кнопка вверх

        //балки
        game.batch.draw(balka, 10, 300);
        game.batch.draw(downpalka, 0, 80);
        game.batch.draw(leftpalka, 0, 20);

        game.batch.draw(human,rectangleHuman.x,rectangleHuman.y);//Человечек
        game.batch.end();

        //Нажатие кнопки влево
        if(Gdx.input.isTouched(0)){
            touchPos.set(Gdx.input.getX(0), Gdx.input.getY(0), 0);
            camera.unproject(touchPos);
            if(touchPos.x >= 20 && touchPos.x <= 80 && touchPos.y >= 20 && touchPos.y <= 80){
                rectangleHuman.x -= 5;
                human = new Texture("humanLeft.png");
            }
        }
        if(Gdx.input.isTouched(1)){
            touchPos.set(Gdx.input.getX(1), Gdx.input.getY(1), 0);
            camera.unproject(touchPos);
            if(touchPos.x >= 20 && touchPos.x <= 80 && touchPos.y >= 20 && touchPos.y <= 80){
                rectangleHuman.x -= 5;
                human = new Texture("humanLeft.png");
            }
        }

        //Нажатие кнопки вправо
        if(Gdx.input.isTouched(0)) {
            touchPos.set(Gdx.input.getX(0), Gdx.input.getY(0), 0);
            camera.unproject(touchPos);
            if (touchPos.x >= 100 && touchPos.x <= 160 && touchPos.y >= 20 && touchPos.y <= 80) {
                rectangleHuman.x += 5;
                human = new Texture("humanRight.png");
            }
        }
        if(Gdx.input.isTouched(1)) {
            touchPos.set(Gdx.input.getX(1), Gdx.input.getY(1), 0);
            camera.unproject(touchPos);
            if (touchPos.x >= 100 && touchPos.x <= 160 && touchPos.y >= 20 && touchPos.y <= 80) {
                rectangleHuman.x += 5;
                human = new Texture("humanRight.png");
            }
        }

        //Нажатие кнопки вверх
        if(Gdx.input.isTouched(0)){
            touchPos.set(Gdx.input.getX(0), Gdx.input.getY(0), 0);
            camera.unproject(touchPos);
            if (touchPos.x >= 700 && touchPos.x <= 760 && touchPos.y >= 20 && touchPos.y <=80 && !gravity) {
                up = true;
                gravity = true;
            }
        }
        if (Gdx.input.isTouched(1)){
            touchPos.set(Gdx.input.getX(1), Gdx.input.getY(1), 0);
            camera.unproject(touchPos);
            if (touchPos.x >= 700 && touchPos.x <= 760 && touchPos.y >= 20 && touchPos.y <=80 && !gravity) {
                up = true;
                gravity = true;
            }
        }

        //Выход за границы
        if(rectangleHuman.x < 10){
            rectangleHuman.x = 10;
        }
        if(rectangleHuman.x > 714){
            rectangleHuman.x = 715;
        }
        if(rectangleHuman.y < 91){
            rectangleHuman.y = 90;
            gravity = false;
        }
        if(rectangleHuman.y > 366){
            rectangleHuman.y = 367;
        }
        if(rectangleHuman.y <= 333 && rectangleHuman.x >= 10 && rectangleHuman.x <= 213 && rectangleHuman.y > 330){
            rectangleHuman.y = 333;
            gravity = false;
        }
        if(rectangleHuman.y < 333 && rectangleHuman.y >= 300 && rectangleHuman.x < 213){
            rectangleHuman.x = 213;
        }
        if(rectangleHuman.y == 333 && rectangleHuman.x >= 214){
            gravity = true;
        }

        //Гравитация
        if(gravity) {
            rectangleHuman.y -= 2;
        }

        //Прыжок
        if(up){
            iUp++;
            rectangleHuman.y += 6;
        }
        if(iUp > 15){
            iUp = 0;
            up = false;
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
    public void dispose () {
        buttonLeft.dispose();
    }

    @Override
    public void show() {

    }
}