package domain;

import java.awt.*;

/**
 * A pentagon that can be manipulated and that draws itself on a canvas.
 *
 * @author camilaF20 (Camila Figueredo)
 * @author Jean-Dv (Jean Valencia)
 */
public class Pentagon extends Figure {
    private int width;
    private int height;

    /**
     * A new pentagon is created in the default position, with the default color
     */
    public Pentagon() {
        width = 300;
        height = 400;
        point = new Point(300, 80);
        color = "magenta";
        isVisible = false;
    }

    /**
     * Overwrite the method with the new size of the pentagon
     *
     * @param newWidth new pentagon width size
     * @param newHeight new pentagon height size
     */
    @Override
    public void changeSize(int newWidth, int newHeight) {
        erase();
        width = newWidth;
        height = newHeight;
        draw();
    }
    /**
     * Draw the pentagon with current specifications on screen.
     */
    @Override
    public void draw() {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = {
                    point.x,
                    point.x + (int) (width * 0.95),
                    point.x + (width / 2),
                    point.x - (width / 2),
                    point.x - (int) (width * 0.95),
            };
            int[] ypoints = {
                    point.y,
                    point.y + (int) (height * 0.49),
                    point.y + height,
                    point.y + height,
                    point.y + (int) (height * 0.49),
            };
            canvas.draw(this, color, new Polygon(xpoints, ypoints, 5));
            canvas.wait(10);
        }
    }
    /**
     * Erase the pentagon on screen.
     */
    @Override
    public void erase() {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }

    /**
     * This method not implemented in the figure, because not need.
     *
     * @param size new figure size
     */
    @Override
    public void changeSize(int size) {

    }
}
