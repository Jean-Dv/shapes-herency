package domain;

import java.awt.*;
/**
 * A square that can be manipulated and that draws itself on a canvas.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 1.0  (15 July 2000)
 */
public class Square extends Figure {
    private int size;

    /**
     * A new square is created in the default position, with the default color
     */
    public Square() {
        size = 300;
        point = new Point(60, 50);
        color = "red";
        isVisible = false;
    }

    /**
     * Overwrite the method with the new size of the square
     * @param newSize new figure size
     */
    @Override
    public void changeSize(int newSize) {
        erase();
        size = newSize;
        draw();
    }

    @Override
    public void changeSize(int newWidth, int newHeight) {}

    /**
     * Draw the square with current specifications on screen.
     */
    @Override
    public void draw() {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, new Rectangle(point.x, point.y, size, size));
            canvas.wait(10);
        }
    }

    /**
     * Erase the square on screen.
     */
    @Override
    public void erase() {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
