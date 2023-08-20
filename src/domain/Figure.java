package domain;

import java.awt.Point;

public abstract class Figure implements FigureActions {
    private Point point;
    private boolean isVisible;
    private String color;
    public void makeVisible() {}
    public void makeInvisible() {}
    public void moveRight() {}
    public void moveLeft() {}
    public void moveUp() {}
    public void moveDown() {}
    public void moveHorizontal(int distance) {}
    public void moveVertical(int distance) {}
    public void changeColor(String newColor) {}
}
