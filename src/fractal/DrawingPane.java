package fractal;

import javax.swing.*;
import java.awt.*;

public class DrawingPane extends JComponent
{
    @Override
    protected void paintComponent(Graphics g) {
        /* paint here with Graphics object */
        int colorR,colorG,colorB;
        int x,x1,y,y1;
        for (int i = 0; i < 3; i++)
        {
            colorR = (int)(Math.random()*255);
            colorG = (int)(Math.random()*255);
            colorB = (int)(Math.random()*255);
            Color color = new Color(colorR,colorG,colorB);
            g.setColor(color);
            g.drawLine(getNumber(),getNumber(),getNumber(),getNumber());
        }
    }
    private int getNumber()
    {
        return (int)(Math.random()*300);
    }
}
