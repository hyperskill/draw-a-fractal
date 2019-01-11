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
        int len = (int)this.y;

        double startPos = Math.abs(Math.random() * 360);
        double grad = 360.00 / deegr;

        for (int i = 0; i < deegr; i++) {
            double x0 = (this.x + len * Math.cos(Math.toRadians(startPos)));
            double y0 = (this.y + len * Math.sin(Math.toRadians(startPos)));
            startPos = (startPos + grad % 360);
            double x1 = (this.x + len * Math.cos(Math.toRadians(startPos)));
            double y1 = (this.y + len * Math.sin(Math.toRadians(startPos)));
            double[] lines = ExtraLines(x0, y0, x1, y1);

            Color cl = new Color((int) Math.abs(Math.random() * 155), (int) Math.abs(Math.random() * 155), (int) Math.abs(Math.random() * 155));
            g.setColor(cl);
            addLines(lines, g, 6);
            g.setColor(Color.BLACK);
            //g.drawLine((int) x0, (int) y0, (int) x1, (int) y1);
        }

    }
    DrawingPane(int x, int y, int deegr){
        this.x = (double) x / 2.2;
        this.y = (double) y / 2.2;
        this.deegr = deegr;
    }

    private void addLines(double[] lines, Graphics g, int nb){
        if (nb == 1) {
            for (int k = 0; k < lines.length - 3; k += 2) {
                g.drawLine((int) lines[k], (int) lines[k + 1], (int) lines[k + 2], (int) lines[k + 3]);
            }
        }
        else{
            for (int k = 0; k < lines.length - 3; k += 2) {
                Color cl = g.getColor();
                int rnd = (int) Math.round(Math.random() * 3);
                Color cc = new Color((cl.getRed() + ((rnd == 1)? 2 : 0)) % 255, (cl.getGreen() + ((rnd == 2)? 2 : 0)) % 255, (cl.getBlue() + ((rnd == 3)? 2 : 0)) % 255);
                g.setColor(cc);
                addLines(ExtraLines( lines[k], lines[k + 1], lines[k + 2], lines[k + 3]), g, nb - 1);
            }
        }
    }

    private int rndx(int x){
        return (int) Math.abs(Math.random() * x);
    }
    public double[] ExtraLines(double x0, double y0, double x1, double y1){
        double[] lines = new double[14];
        double r = 0.3489924614054997 * Math.hypot(x1 - x0, y1 - y0);
        double pos = Math.atan((y0 - y1) / (x0 - x1));
        lines[0] = x0;
        lines[1] = y0;
        pos = pos - Math.toRadians(168);
        lines[2] = (x0 + r * Math.cos((pos))* (x1 > x0? -1: 1));
        lines[3] = (y0 + r * Math.sin((pos))* (x1 > x0? -1: 1));
        pos = Math.toRadians(Math.toDegrees(pos) + 72);
        lines[4] = (lines[2] + r * Math.cos((pos))* (x1 > x0? -1: 1));
        lines[5] = (lines[3] + r * Math.sin((pos))* (x1 > x0? -1: 1));
        pos = Math.toRadians(Math.toDegrees(pos) - 72);
        lines[6] = (lines[4] + r * Math.cos((pos))* (x1 > x0? -1: 1));
        lines[7] = (lines[5] + r * Math.sin((pos))* (x1 > x0? -1: 1));
        pos = Math.toRadians(Math.toDegrees(pos) - 144);
        lines[8] = (lines[6] + r * Math.cos((pos))* (x1 > x0? -1: 1));
        lines[9] = (lines[7] + r * Math.sin((pos))* (x1 > x0? -1: 1));
        pos = Math.toRadians(Math.toDegrees(pos) + 72);
        lines[10] = (lines[8] + r * Math.cos((pos))* (x1 > x0? -1: 1));
        lines[11] = (lines[9] + r * Math.sin((pos))* (x1 > x0? -1: 1));
        lines[12] = x1;
        lines[13] = y1;

        return lines;
    }
}