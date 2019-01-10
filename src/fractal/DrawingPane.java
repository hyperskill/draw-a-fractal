package fractal;

import javax.swing.*;
import java.awt.*;

public class DrawingPane extends JComponent {
    private int x;
    private int y;

    @Override
    protected void paintComponent(Graphics g) {
        /* paint here with Graphics object */

        for (int i = 0; i < 3; i++) {
            Color cl = new Color((int) Math.abs(Math.random() * 255), (int) Math.abs(Math.random() * 255), (int) Math.abs(Math.random() * 255));
            g.setColor(cl);
            g.drawLine(rndx(this.x), rndx(this.x), rndx(this.x), rndx(this.x));
        }

    }
    public DrawingPane(int x, int y){
        this.x = x;
        this.y = y;
    }

    private int rndx(int x){
        return (int) Math.abs(Math.random() * x);
    }
    public void paintLine(){

    }
}