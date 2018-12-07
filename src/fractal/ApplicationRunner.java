package fractal;

import javax.swing.*;

public class ApplicationRunner {
    public static void main(String[] args) {
        JFrame j = new FractalDrawer();
        j.add(new DrawingPane());
    }
}
