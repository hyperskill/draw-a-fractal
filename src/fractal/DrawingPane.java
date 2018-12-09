package fractal;
import javax.swing.*;
import java.awt.*;


public class DrawingPane extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        int numberOfSides = 5;
        int xc =getWidth()/2, yc = getHeight()/2, r = 100;
        int x[] = new int[numberOfSides];
        int y[] = new int[numberOfSides];
        for (int c = 0; c < numberOfSides; c++) {
           double angle = 2 * Math.PI * c /numberOfSides;
           x[c] = (int)(xc+r*Math.cos(angle));
           y[c] = (int)(yc+r*Math.sin(angle));
        }
        g.drawPolygon(x,y,numberOfSides);

    }
}