import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {

    public ControlPanel() {
        setLayout(new GridLayout(0, 2));

        add(new JLabel("Points"));
        JSlider points = new JSlider(1, 50, 1);
        points.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                Panel.get().updatePoints(points.getValue());
                Panel.get().revalidate();
                Panel.get().repaint();

            }

        });
        add(points);

        ButtonGroup bg = new ButtonGroup();
        JRadioButton euclidian = new JRadioButton("Euclidian");
        JRadioButton manhattan = new JRadioButton("Manhattan");

        euclidian.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Panel.get().manhattan = false;
                Panel.get().revalidate();
                Panel.get().repaint();
            }

        });

        manhattan.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Panel.get().manhattan = true;
                Panel.get().revalidate();
                Panel.get().repaint();
            }

        });

        euclidian.setSelected(true);
        bg.add(euclidian);
        bg.add(manhattan);

        add(euclidian);
        add(manhattan);
    }

}
