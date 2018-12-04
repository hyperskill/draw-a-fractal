package fractal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static fractal.Pentagon.calcXCoordinates;
import static fractal.Pentagon.calcYCoordinates;

public class FractalPattern extends JComponent {

    private static final int NUM_OF_VERTEX = 5;
    private static final int radius = 100;
    private static final int x0 = 150;
    private static final int y0 = 150;
    private static final int phi = 0;
    private static final double r = 0.3489924614054997;
    private static final double alpha = 15.0145979198257 * Math.PI/180;
    private static final double omega = 72 * Math.PI/180;
    private static List<Double> xCoordinates = new ArrayList<>();
    private static List<Double> yCoordinates = new ArrayList<>();
    private static List<Integer> xOfPentagon = new ArrayList<>();
    private static List<Integer> yOfPentagon = new ArrayList<>();

    @Override
    protected void paintComponent(Graphics g) {
        calcPatternCoordinates();
        g.drawPolygon(getArrayOfCoordinates(xCoordinates), getArrayOfCoordinates(yCoordinates), NUM_OF_VERTEX * 6);
    }

    private void calcPatternCoordinates() {
        calcPentagonCoordinates();
        for (int i = 0; i < NUM_OF_VERTEX; i++) {
            calcOnePart(xOfPentagon.get(i), yOfPentagon.get(i),
                    xOfPentagon.get((i + 1) % NUM_OF_VERTEX), yOfPentagon.get((i + 1) % NUM_OF_VERTEX));
        }
    }

    private void calcPentagonCoordinates() {
        int[] x = calcXCoordinates(radius, x0, phi);
        int[] y = calcYCoordinates(radius, y0, phi);
        for (int i = 0; i < NUM_OF_VERTEX; i++) {
            xOfPentagon.add(x[i]);
            yOfPentagon.add(y[i]);
        }
    }

    private void calcOnePart(int x0, int y0, int x1, int y1){
        double epsilon = Math.random() * 1E-10;
        double h = r * Math.hypot(x1 - x0 + epsilon, y1 - y0 + epsilon);
        double beta = Math.atan((y1 - y0 + epsilon) / (x1 - x0 + epsilon));
        double prevX = x0;
        double prevY = y0;
        xCoordinates.add(prevX);
        yCoordinates.add(prevY);
        for (int i = 0; i < NUM_OF_VERTEX; i++) {
            double nextX = prevX + h * Math.cos(alpha + beta + getAngle(i)) * (x1 < x0 ? -1 : 1);
            double nextY = prevY + h * Math.sin(alpha + beta + getAngle(i)) * (x1 < x0 ? -1 : 1);
            prevX = nextX;
            prevY = nextY;
            xCoordinates.add(prevX);
            yCoordinates.add(prevY);
        }
    }

    private double getAngle(int n) {
        switch(n) {
            case 1:
                return omega;
            case 3:
                return -2 * omega;
            case 4:
                return -omega;
            default:
                return 0;
        }
    }

    private int[] getArrayOfCoordinates(List<Double> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = (int) Math.round(list.get(i));
        }
        return array;
    }

}