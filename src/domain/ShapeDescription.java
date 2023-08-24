package domain;

import java.awt.*;

 /**
  * ShapeDescription is essentially a JPanel with added capability to
  * refresh the image drawn on it.
  *
  * @author: Bruce Quig
  * @author: Michael Kölling (mik)
  *
  * @version: 1.6 (shapes)
  */
public class ShapeDescription {
    private Shape shape;
    private String colorString;

     /**
      * Describe the shape of the figure with the given parameters.
      *
      * @param shape
      * @param colorString
      */
    public ShapeDescription(Shape shape, String colorString) {
        this.shape = shape;
        this.colorString = colorString;
    }

     /**
      * Represents the shape of the figure
      *
      * @param graphic
      */
    public void draw(Graphics2D graphic) {
        Canvas.getCanvas().setForegroundColor(colorString);
        graphic.fill(shape);
    }
}
