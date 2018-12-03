package fractal;

import javax.swing.*;
import java.awt.*;

public class DrawingPane extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawLine(0, 0, 300, 300);
        g.setColor(Color.ORANGE);
        g.drawLine(10, 250, 213, 250);
        g.setColor(Color.GREEN);
        g.drawLine(128, 7, 128, 118);
    }

}
