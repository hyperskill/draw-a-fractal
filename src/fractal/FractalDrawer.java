package fractal;

import javax.swing.*;
import java.awt.*;

public class FractalDrawer extends JFrame {
    public FractalDrawer() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setTitle("FractalDrawer");
        add(new FractalPattern());
    }
}