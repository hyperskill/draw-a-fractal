package fractal;

import java.awt.*;

public class Line
{
    public int x1,x2,y1,y2;
    public Color color;
    public Line(int x1,int y1,int x2, int y2, Color color)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.color = color;
    }
    public Line(int x1,int y1,int x2, int y2)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.color = Color.BLACK;
    }
    public Line(int x1,int y1,int x2, int y2, int color)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.color = new Color(color);
    }

    public Line(int x1,int y1,int length, double angle, int color)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1 + (int)Math.round(length * Math.cos(Math.toRadians(angle)));
        this.y2 = y1 + (int)Math.round(length * Math.cos(Math.toRadians(angle)));
        this.color = new Color(color);
    }

    public Line(int x1,int y1,int length, double angle)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1 + (int)Math.round(length * Math.cos(Math.toRadians(angle)));
        this.y2 = y1 + (int)Math.round(length * Math.sin(Math.toRadians(angle)));
        this.color = Color.BLACK;
    }

}