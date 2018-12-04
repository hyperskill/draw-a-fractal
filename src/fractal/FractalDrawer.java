package fractal;

import javax.swing.*;

public class FractalDrawer extends JFrame {
    public FractalDrawer() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
        setTitle("FractalDrawer");
        add(new FractalPattern());
    }
}