package domain;

import javax.swing.JFrame;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Canvas {
    private static Canvas _instance;

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

    public void draw(Object referenceObject, String color, Shape shape) {
        objects.remove(referenceObject);
        objects.add(referenceObject);
        shapes.put(referenceObject, new ShapeDescription(shape, color));
        redraw();
    }
    public void erase(Object referenceObject) {
        objects.remove(referenceObject);
        shapes.remove(referenceObject);
        redraw();
    }
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
    public void wait (int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void redraw() {
        erase();
        for (Object object : objects) {
            ((ShapeDescription) shapes.get(object)).draw(graphic);
        }
        canvas.repaint();
    }
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
