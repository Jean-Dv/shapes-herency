package domain;

import javax.swing.JFrame;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Canvas is a class to allow for simple graphical drawing on a canvas.
 * This is a modification of the general purpose Canvas, specially made for
 * the BlueJ "shapes" example.
 *
 * @author: Bruce Quig
 * @author: Michael Kölling (mik)
 *
 * @version: 1.6 (shapes)
 */
public class Canvas {
    private static Canvas _instance;
    /**
     * Factory method to get the canvas singleton object.
     */
    public static Canvas getCanvas() {
        if(_instance == null) {
            _instance = new Canvas("BlueJ Shapes Demo", 1000, 1000,
                    Color.white);
        }
        _instance.setVisible(true);
        return _instance;
    }
    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColor;
    private Image canvasImage;
    private List<Object> objects;
    private HashMap<Object, ShapeDescription> shapes;

    /**
     * Create a Canvas.
     * @param title  title to appear in Canvas Frame
     * @param width  the desired width for the canvas
     * @param height  the desired height for the canvas
     * @param bgColour  the desired background colour of the canvas
     */
    private Canvas(String title, int width, int height, Color bgColour) {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColor = bgColour;
        frame.pack();
        objects = new ArrayList<Object>();
        shapes = new HashMap<Object, ShapeDescription>();
    }

    /**
     * Set the canvas visibility and brings canvas to the front of screen
     * when made visible. This method can also be used to bring an already
     * visible canvas to the front of other windows.
     *
     * @param visible  boolean value representing the desired visibility of
     * the canvas (true or false)
     */
    public void setVisible(boolean visible) {
        if(graphic == null) {
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D)canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(visible);
    }

    /**
     * Draw a given shape onto the canvas.
     * @param  referenceObject  an object to define identity for this shape
     * @param  color            the color of the shape
     * @param  shape            the shape object to be drawn on the canvas
     */
    public void draw(Object referenceObject, String color, Shape shape) {
        objects.remove(referenceObject);
        objects.add(referenceObject);
        shapes.put(referenceObject, new ShapeDescription(shape, color));
        redraw();
    }

    /**
     * Erase a given shape's from the screen.
     * @param  referenceObject  the shape object to be erased
     */
    public void erase(Object referenceObject) {
        objects.remove(referenceObject);
        shapes.remove(referenceObject);
        redraw();
    }

    /**
     * Set the foreground colour of the Canvas.
     * @param  colorString the color string for the foreground of the Canvas
     */
    public void setForegroundColor(String colorString) {
        switch (colorString) {
            case "red" -> graphic.setColor(Color.red);
            case "blue" -> graphic.setColor(Color.blue);
            case "yellow" -> graphic.setColor(Color.yellow);
            case "green" -> graphic.setColor(Color.green);
            case "magenta" -> graphic.setColor(Color.magenta);
            case "white" -> graphic.setColor(Color.white);
            default -> graphic.setColor(Color.black);
        }
    }

    /**
     * Wait for a specified number of milliseconds before finishing.
     * This provides an easy way to specify a small delay which can be
     * used when producing animations.
     * @param  ms  the number
     */
    public void wait (int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Redraw all shapes currently on the Canvas.
     */
    private void redraw() {
        erase();
        for (Object object : objects) {
            ((ShapeDescription) shapes.get(object)).draw(graphic);
        }
        canvas.repaint();
    }

    /**
     * Erase the whole canvas. (Does not repaint.)
     */
    private void erase() {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
    }

    public Image getCanvasImage() {
        return canvasImage;
    }
}
