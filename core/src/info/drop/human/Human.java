package info.drop.human;

import com.badlogic.gdx.math.Rectangle;

public class Human {

    Rectangle rectangle;

    public Human(){
        rectangle = new Rectangle();
        rectangle.x = 10;
        rectangle.y = 380;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}