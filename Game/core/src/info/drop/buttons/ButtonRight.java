package info.drop.buttons;


import com.badlogic.gdx.math.Rectangle;

public class ButtonRight{

    Rectangle rectangle;

    public ButtonRight(){
        rectangle = new Rectangle();
        rectangle.x = 100;
        rectangle.y = 20;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}