package domain;

import java.awt.*;

public class ShapeDescription {
    private Shape shape;
    private String colorString;

    public ShapeDescription(Shape shape, String colorString) {
        this.shape = shape;
        this.colorString = colorString;
    }

    public void draw(Graphics2D graphic) {
        Canvas.getCanvas().setForegroundColor(colorString);
        graphic.fill(shape);
    }
}
