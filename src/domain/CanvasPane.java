package domain;

import javax.swing.JPanel;
import java.awt.Graphics;

public class CanvasPane extends JPanel {
    public void paint(Graphics graphics) {
        graphics.drawImage(Canvas.getCanvas().getCanvasImage(), 0,0,null);
    }
}
