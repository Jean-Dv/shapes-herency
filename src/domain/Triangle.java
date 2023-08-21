package domain;

import java.awt.*;

public class Triangle extends Figure {
    private int width;
    private int height;

    public Triangle() {
        width = 300;
        height = 300;
        point = new Point(250, 15);
        color = "green";
        isVisible = false;
    }

    @Override
    public void changeSize(int newHeight, int newWidth) {
        erase();
        width = newWidth;
        height = newHeight;
        draw();
    }

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
