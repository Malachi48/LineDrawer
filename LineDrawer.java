import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;

/**
 * Let user draw line in graphics pane with mouse.
 *
 * @author Malachi
 * @version 3/05/21
 */
public class LineDrawer {
    // Fields to remember "pressed" position
    private double startX;
    private double startY;
    private Color currentColor = Color.black;   // Set color with default
    
    /**
     * Respond to mouse event of pressing and releasing by drawing a line
     */
    public void doMouse(String action, double x, double y) {
        if (action.equals("pressed")) {
            this.startX = x;
            this.startY = y;
        } else if (action.equals("released")) {
            UI.drawLine(this.startX, this.startY, x, y);
        }
    }
    
    /**
     * Changes current color
     */
    public void doChooseColor() {
        this.currentColor = JColorChooser.showDialog(null, "Choose Color", this.currentColor);
        UI.setColor(this.currentColor);
    }
    
    public static void main(String[] args) {
        UI.setLineWidth(10);                    // Set line width
        LineDrawer drawer = new LineDrawer();   // Creating new LineDrawer Object
        UI.setMouseListener(drawer::doMouse);   // Set up MouseListener
        UI.addButton("Color", drawer::doChooseColor);   // Change color
        
    }
}
