package fractal;

import javax.swing.*;
import java.awt.*;

public class FractalDrawer extends JFrame{

    DrawingPane dp = new DrawingPane();

    public FractalDrawer() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
        setTitle("Fractal Drawer");
        add(dp, BorderLayout.CENTER);
    }
}
