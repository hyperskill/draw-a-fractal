package fractal;

import javax.swing.*;
import java.awt.*;

public class Pentagon extends JComponent {

    private static final int NUM_OF_VERTEX = 5;

    @Override
    protected void paintComponent(Graphics g) {
        int radius = 100;
        int x0 = 150;
        int y0 = 150;
        int phi = 0;
        g.setColor(Color.RED);
        g.drawPolygon(calcXCoordinates(radius, x0, phi), calcYCoordinates(radius, y0, phi), NUM_OF_VERTEX);
    }

    static int[] calcXCoordinates(int radius, int x0, int phi) {
        int[] xCoordinates = new int[NUM_OF_VERTEX];
        for (int i = 0; i < NUM_OF_VERTEX ; i++) {
            xCoordinates[i] = (int) Math.round(x0 + radius * Math.cos(phi + 2 * Math.PI * i / NUM_OF_VERTEX));
        }
        return xCoordinates;
    }

    static int[] calcYCoordinates(int radius, int y0, int phi) {
        int[] yCoordinates = new int[NUM_OF_VERTEX];
        for (int i = 0; i < NUM_OF_VERTEX ; i++) {
            yCoordinates[i] = (int) Math.round(y0 + radius * Math.sin(phi + 2 * Math.PI * i / NUM_OF_VERTEX));
        }
        return yCoordinates;
    }

}