package domain;

import java.awt.Point;

/**
 * Parent class that contains the methods that can be used in the figures
 *
 * @author camilaF20 (Camila Figueredo)
 * @author Jean-Dv (Jean Valencia)
 */
public abstract class Figure implements FigureActions {
    protected Point point;
    protected boolean isVisible;
    protected String color;

    /**
     * Make the figure visible, if it is already visible nothing is done
     */
    public void makeVisible() {
        isVisible = true;
        draw();
    }

    /**
     * Make the figure invisible, if it is already invisible nothing is done
     */
    public void makeInvisible() {
        erase();
        isVisible = false;
    }

    /**
     * Move the figure to the right
     */
    public void moveRight() {
        moveHorizontal(50);
    }

    /**
     * Move the figure to the Left
     */
    public void moveLeft() {
        moveHorizontal(-50);
    }

    /**
     * Move the figure up
     */
    public void moveUp() {
        moveVertical(-50);
    }

    /**
     * Move the figure down
     */
    public void moveDown() {
        moveVertical(50);
    }

    /**
     * Move the figure horizontal according to the 'distance'
     *
     * @param distance the distance to move
     */
    public void moveHorizontal(int distance) {
        erase();
        point.x += distance;
        draw();
    }

    /**
     * Move the figure vertical according to the 'distance'
     *
     * @param distance the distance to move
     */
    public void moveVertical(int distance) {
        erase();
        point.y += distance;
        draw();
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor) {
        color = newColor;
        draw();
    }
}
