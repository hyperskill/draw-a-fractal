package fractal;

import java.awt.*;

public class ApplicationRunner {
    public static void main(String[] args) {
       FractalDrawer fractalDrawer= new FractalDrawer();
       DrawingPane drawingPane = new DrawingPane();
       fractalDrawer.add(drawingPane);
       Graphics graphics = fractalDrawer.getGraphics();
       drawingPane.paintComponent(graphics);
    }
}