package domain;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Figure {
    private int diameter;

    public Circle() {
        diameter = 300;
        point = new Point(20, 60);
        color = "blue";
        isVisible = false;
    }

    @Override
    public void changeSize(int newDiameter) {
        erase();
        diameter = newDiameter;
        draw();
    }

    @Override
    public void changeSize(int newWidth, int newHeight) {}

    @Override
    public void draw() {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, new Ellipse2D.Double(point.x,
                    point.y,diameter, diameter));
            canvas.wait(10);
        }
    }

    @Override
    public void erase() {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
