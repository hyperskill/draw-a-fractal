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
        g.drawLine(20, 20, 100, 180);
        g.drawLine(30, 150, 100, 200);
        g.drawLine(90, 50, 200, 210);
    }
}
