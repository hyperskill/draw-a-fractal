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

        dp.addnewLine(new Line(rnd.nextInt(300),rnd.nextInt(300),rnd.nextInt(300),rnd.nextInt(300),rnd.nextInt(255)));
        dp.addnewLine(new Line(rnd.nextInt(300),rnd.nextInt(300),rnd.nextInt(300),rnd.nextInt(300),rnd.nextInt(255)));
        dp.addnewLine(new Line(rnd.nextInt(300),rnd.nextInt(300),rnd.nextInt(300),rnd.nextInt(300),rnd.nextInt(255)));

        add(dp);
        setVisible(true);
    }
}

