package fractal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static fractal.Pentagon.calcXCoordinates;
import static fractal.Pentagon.calcYCoordinates;

public class FractalPattern extends JComponent {

    private static final int NUM_OF_ITERATION = 6;
    private static final int NUM_OF_VERTEX = 5;
    private static final int radius = 300;
    private static final int x0 = 350;
    private static final int y0 = 350;
    private static final int phi = 0;
    private static final double r = 0.3489924614054997;
    private static final double alpha = 15.0145979198257 * Math.PI/180;
    private static final double omega = 72 * Math.PI/180;
    private static List<Double> xCoordinates = new ArrayList<>();
    private static List<Double> yCoordinates = new ArrayList<>();
    private static List<Double> xOfPreviousIteration = new ArrayList<>();
    private static List<Double> yOfPreviousIteration = new ArrayList<>();

    @Override
    protected void paintComponent(Graphics g) {
        calcPentagonCoordinates();
        for (int i = 0; i < NUM_OF_ITERATION; i++) {
            nextIteration();
        }
        drawResult(g);
    }

    private void drawResult(Graphics g) {
        int[] arrayOfX = getArrayOfCoordinates(xCoordinates);
        int[] arrayOfY = getArrayOfCoordinates(yCoordinates);

        int colorIndex = 0;
        int start = 0;
        int colorStep = 700;
        while(start < xCoordinates.size()) {
            int end = Math.min(start + colorStep, arrayOfX.length);
            g.setColor(selectColor(colorIndex));
            g.drawPolyline(Arrays.copyOfRange(arrayOfX, start, end),
                           Arrays.copyOfRange(arrayOfY, start, end), end - start);
            colorIndex = (colorIndex + 1) % 10;
            start+= colorStep;
        }
    }


    private Color selectColor(int num){
        switch(num) {
            case 0:
                return Color.BLACK;
            case 1:
                return Color.ORANGE;
            case 2:
                return Color.GREEN;
            case 3:
                return Color.RED;
            case 4:
                return Color.CYAN;
            case 5:
                return Color.YELLOW;
            case 6:
                return Color.pink;
            case 7:
                return Color.DARK_GRAY;
            case 8:
                return Color.MAGENTA;
            default:
                return Color.LIGHT_GRAY;
        }
    }

    private void nextIteration(){
        xCoordinates = new ArrayList<>();
        yCoordinates = new ArrayList<>();
        int numOfPoints = xOfPreviousIteration.size();
        for (int i = 0; i < numOfPoints; i++) {
            calcOnePart(xOfPreviousIteration.get(i), yOfPreviousIteration.get(i),
                    xOfPreviousIteration.get((i + 1) % numOfPoints),
                    yOfPreviousIteration.get((i + 1) % numOfPoints));
        }
        xOfPreviousIteration = new ArrayList<>(xCoordinates);
        yOfPreviousIteration = new ArrayList<>(yCoordinates);
    }

    private void calcPentagonCoordinates() {
        int[] x = calcXCoordinates(radius, x0, phi);
        int[] y = calcYCoordinates(radius, y0, phi);
        for (int i = 0; i < NUM_OF_VERTEX; i++) {
            xOfPreviousIteration.add((double) x[i]);
            yOfPreviousIteration.add((double) y[i]);
        }
    }

    private void calcOnePart(double x0, double y0, double x1, double y1){
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