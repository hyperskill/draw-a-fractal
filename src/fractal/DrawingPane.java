package fractal;

import javax.swing.*;
import java.awt.*;

public class DrawingPane extends JComponent {
    private double x;
    private double y;
    private int deegr;

    @Override
    protected void paintComponent(Graphics g) {
        /* paint here with Graphics object */
        int len = 250;

        double startPos = Math.abs(Math.random() * 360);
        double grad = 360.00 / deegr;

        for (int i = 0; i < deegr; i++) {
            double x0 = (this.x + len * Math.cos(Math.toRadians(startPos)));
            double y0 = (this.y + len * Math.sin(Math.toRadians(startPos)));
            startPos = (startPos + grad % 360);
            double x1 = (this.x + len * Math.cos(Math.toRadians(startPos)));
            double y1 = (this.y + len * Math.sin(Math.toRadians(startPos)));
            Color cl = new Color((int) Math.abs(Math.random() * 255), (int) Math.abs(Math.random() * 255), (int) Math.abs(Math.random() * 255));
            g.setColor(cl);
            g.drawLine((int) x0, (int) y0, (int) x1, (int) y1);
        }

    }
    public DrawingPane(int x, int y, int deegr){
        this.x = (double) x / 2;
        this.y = (double) y / 2;
        this.deegr = deegr;
    }

    private int rndx(int x){
        return (int) Math.abs(Math.random() * x);
    }
    public void paintLine(){

    }
}