package fractal;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawingPane extends JComponent {
    Random rnd = new Random();
    @Override
    protected void paintComponent(Graphics g) {
        for (int i = 0; i <3 ; i++) {
            g.setColor(new Color(rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255)));
            g.drawLine(rnd.nextInt(500),rnd.nextInt(500),rnd.nextInt(500),rnd.nextInt(500));
        }


    }
}