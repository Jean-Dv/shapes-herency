package domain;

import javax.swing.JPanel;
import java.awt.Graphics;

/**
 * CanvasPane is essentially a JPanel with added capability to
 * refresh the image drawn on it.
 *
 * @author: Bruce Quig
 * @author: Michael Kölling (mik)
 *
 * @version: 1.6 (shapes)
 */
public class CanvasPane extends JPanel {
    public void paint(Graphics graphics) {
        graphics.drawImage(Canvas.getCanvas().getCanvasImage(), 0,0,null);
    }
}
