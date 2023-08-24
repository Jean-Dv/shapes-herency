package domain;

import java.awt.*;
/**
 * A triangle that can be manipulated and that draws itself on a canvas.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 1.0  (15 July 2000)
 */
public class Triangle extends Figure {
    private int width;
    private int height;

    /**
     * A new triangle is created in the default position, with the default color
     */
    public Triangle() {
        width = 300;
        height = 300;
        point = new Point(250, 15);
        color = "green";
        isVisible = false;
    }

    /**
     * Overwrite the method with the new size of the triangle
     * @param newHeight new figure width size
     * @param newWidth new figure height size
     */
    @Override
    public void changeSize(int newHeight, int newWidth) {
        erase();
        width = newWidth;
        height = newHeight;
        draw();
    }

    /**
     * Draw the square with current specifications on screen.
     */
    @Override
    public void draw() {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = {point.x, point.x + (width / 2), point.x - (width / 2)};
            int[] ypoints = {point.y, point.y + height, point.y + height};
            canvas.draw(this, color, new Polygon(xpoints, ypoints, 3));
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

    @Override
    public void changeSize(int size) {}
}
