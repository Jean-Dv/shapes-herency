package domain;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 1.0  (15 July 2000)
 */

public class Circle extends Figure {
    private int diameter;

    /**
     * A new circle is created in the default position, with the default color
     */
    public Circle() {
        diameter = 300;
        point = new Point(20, 60);
        color = "blue";
        isVisible = false;
    }

    /**
     * Overwrite the method with the new size of the circle
     *
     * @param newDiameter new figure size
     */
    @Override
    public void changeSize(int newDiameter) {
        erase();
        diameter = newDiameter;
        draw();
    }

    /**
     * This method not implemented in the figure, because not need.
     *
     * @param newWidth new figure width size
     * @param newHeight new figure height size
     */
    @Override
    public void changeSize(int newWidth, int newHeight) {}

    /**
     * Draw the circle with current specifications on screen.
     */
    @Override
    public void draw() {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, new Ellipse2D.Double(point.x,
                    point.y,diameter, diameter));
            canvas.wait(10);
        }
    }

    /**
     * Erase the circle on screen.
     */
    @Override
    public void erase() {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
