package domain;

import java.awt.*;

public class Square extends Figure {
    private int size;

    public Square() {
        size = 300;
        point = new Point(60, 50);
        color = "red";
        isVisible = false;
    }

    @Override
    public void changeSize(int newSize) {
        erase();
        size = newSize;
        draw();
    }

    @Override
    public void changeSize(int newWidth, int newHeight) {}

    @Override
    public void draw() {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, new Rectangle(point.x, point.y, size, size));
            canvas.wait(10);
        }
    }

    @Override
    public void erase() {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
