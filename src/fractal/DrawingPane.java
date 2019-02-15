package fractal;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawingPane extends JComponent {
    private static Random ran = new Random();
    @Override
    protected void paintComponent(Graphics g) {
        setBounds(10, 10, 280, 280);
        Color c = new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
        g.setColor(c);

        int angle = 0;
        int length = 150;
        int xPrevious = 50;
        int yPrevious = 10;
        int xNow;
        int yNow;

        for (int i = 0; i < 4; i++) {
            xNow = (int)(xPrevious + length * Math.cos(Math.toRadians(angle)));
            yNow = (int)(yPrevious + length * Math.sin(Math.toRadians(angle)));
            g.drawLine(xPrevious, yPrevious, xNow, yNow);

            xPrevious = xNow;
            yPrevious = yNow;
            angle += 72;
        }

        g.drawLine(xPrevious, yPrevious, 50, 10);

    }


}
