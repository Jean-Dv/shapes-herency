package domain;

import java.awt.Point;

public abstract class Figure implements FigureActions {
    protected Point point;
    protected boolean isVisible;
    protected String color;

    public void makeVisible() {
        isVisible = true;
        draw();
    }

    public void makeInvisible() {
        erase();
        isVisible = false;
    }

    public void moveRight() {
        moveHorizontal(50);
    }

    public void moveLeft() {
        moveHorizontal(-50);
    }

    public void moveUp() {
        moveVertical(-50);
    }

    public void moveDown() {
        moveVertical(50);
    }

    public void moveHorizontal(int distance) {
        erase();
        point.x += distance;
        draw();
    }

    public void moveVertical(int distance) {
        erase();
        point.y += distance;
        draw();
    }

    public void changeColor(String newColor) {
        color = newColor;
        draw();
    }
}
