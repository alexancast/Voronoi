import java.awt.BorderLayout;

import javax.swing.JFrame;
import java.awt.*;

public class Program extends JFrame {

    Program() {

        setSize(850, 600);

        add(Panel.get(), BorderLayout.CENTER);

        ControlPanel controlPanel = new ControlPanel();
        controlPanel.setPreferredSize(new Dimension(250, getHeight()));
        add(controlPanel, BorderLayout.EAST);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Program();
    }
}