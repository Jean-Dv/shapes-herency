package domain;

import javax.swing.JFrame;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Canvas {
    private static Canvas _instance;

    public Canvas getCanvas() {}
    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColor;
    private Image canvasImage;
    private List<Object> objects;
    private HashMap<Object, ShapeDescription> shapes;

    private Canvas(String title, int width, int height, Color bgColour) {}

    public void setVisible(boolean visible) {}
    public void draw(Object referenceObject, String color, Shape shape) {

    }
    public void erase(Object referenceObject) {}
    public void setForegroundColor(String colorString) {}
    public void wait (int ms) {}
    private void redraw() {}
    private void erase() {}
}
