package fractal;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.concurrent.Future;

class FractalDrawer extends JFrame implements ChangeListener {
    int deep = 1;
    DrawingPane pane = new DrawingPane(900,900 + 50, 5);
    JSlider slider = new JSlider(SwingConstants.VERTICAL,1, 8, 1);

    FractalDrawer(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1800, 900);

        setLayout(new GridLayout(1, 20));

        this.slider.addChangeListener(this::stateChanged);
        GridBagConstraints gbc = new GridBagConstraints();
        slider.setPreferredSize(new Dimension(30, 130));
      //  slider.addChangeListener(ChangeListener);
        pane.setDeep(slider.getValue());
        System.out.println(slider.getValue());
        gbc.gridy = 19;
        add(pane);

        gbc.gridy = 20;
        add(slider, gbc);

        setVisible(true);

    }

    private void createLayout() {


    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.deep = this.slider.getValue();
        this.pane.setDeep(this.deep);
        System.out.println(this.deep);
        repaint();
    }
}
