package fractal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawingPane extends JComponent {

    public ArrayList<Line> lines = new ArrayList<Line>();

    public void addnewLine(Line line)
    {
        lines.add(line);
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Line line : lines) {
            g.setColor(line.color);
            g.drawLine(line.x1,line.y1,line.x2,line.y2);
        }


    }
}
