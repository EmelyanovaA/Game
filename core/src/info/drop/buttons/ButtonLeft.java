package info.drop.buttons;

import com.badlogic.gdx.math.Rectangle;

public class ButtonLeft {

    Rectangle rectangle;

    public ButtonLeft(){
        rectangle = new Rectangle();
        rectangle.x = 20;
        rectangle.y = 20;
//        rectangle.width = 50;
//        rectangle.height = 50;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

}
