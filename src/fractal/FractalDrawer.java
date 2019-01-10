package fractal;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Future;

public class FractalDrawer extends JFrame {
    public FractalDrawer() throws InterruptedException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        DrawingPane pane = new DrawingPane(this.getWidth(), this.getHeight(), 5);
        add(pane);
        repaint();

        super.setVisible(true);

    }

}
