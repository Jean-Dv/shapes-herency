package domain;

import java.awt.*;

public class Pentagon extends Figure {
    private int width;
    private int height;

    public Pentagon() {
        width = 300;
        height = 400;
        point = new Point(300, 80);
        color = "magenta";
        isVisible = false;
    }

    @Override
    public void changeSize(int newWidth, int newHeight) {
        erase();
        width = newWidth;
        height = newHeight;
        draw();
    }

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

    @Override
    public void erase() {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }

    @Override
    public void changeSize(int size) {

    }
}
