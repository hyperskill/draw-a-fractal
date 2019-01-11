package fractal;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Future;

class FractalDrawer extends JFrame {
    FractalDrawer(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1800, 1000);
        DrawingPane pane = new DrawingPane(this.getWidth(), this.getHeight(), 5);
        add(pane);
        //repaint();

        setVisible(true);

    }

}
