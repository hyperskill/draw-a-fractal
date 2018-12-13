package fractal;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FractalDrawer extends JFrame {
    public FractalDrawer() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

        DrawingPane dp = new DrawingPane();
        Random rnd = new Random();
        double angle = 90;
        Line l1 = new Line(20, 50, 100, angle);

        for (int i = 0; i < 5; i++) {
            angle -= 72;
            dp.addnewLine(l1);
            l1 = new Line(l1.x2, l1.y2, 100, angle);
        }



        dp.addnewLine(l1);

        add(dp);
        setVisible(true);
    }
}

