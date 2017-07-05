package info.drop.buttons;

import com.badlogic.gdx.math.Rectangle;

public class ButtonUp{
    Rectangle rectangle;

    public ButtonUp(){
        rectangle = new Rectangle();
        rectangle.x = 700;
        rectangle.y = 20;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
