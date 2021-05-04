import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/** 
 * Draw a circle of random colours when clicked
 *
 * @author Malachi
 * @version 3/05/21
 */
public class DrawShape {
    /**
     * Constructor for objects of class DrawShape 
     */
    public DrawShape() {
        UI.initialise();
        UI.addButton("Quit", UI::quit);    // Comment out to checkstyle
    }
    
    /**
     * Draw an Oval when clicked
     */
    public void doMouse(String action, double x, double y) {
        UI.fillOval(x, y, 50, 50);
    }
    
    /**
     * Set a random color everytime it is called
     */
    public void changeColor() {
        Color col = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
        UI.setColor(col);
    }

    /**
     * Main routine
     *
     */
    public static void main(String[] args){
        DrawShape obj = new DrawShape();
        UI.addButton("Change Color", obj::changeColor);
        UI.setMouseListener(obj::doMouse);
    }
}

