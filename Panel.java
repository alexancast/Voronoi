import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Panel extends JPanel implements MouseListener {

    public boolean manhattan;
    private static Panel instance;
    private ArrayList<Point> points = new ArrayList<>();
    private ArrayList<Color> colors = new ArrayList<>();

    private int pointRadius = 4;
    private Random random = new Random();

    private Panel() {
        addMouseListener(this);
    }

    public static Panel get() {

        if (instance == null) {
            instance = new Panel();
        }

        return instance;
    }

    public void updatePoints(int number) {

        points.clear();
        colors.clear();
        for (int i = 0; i < number; i++) {
            int x = random.nextInt(getWidth());
            int y = random.nextInt(getHeight());

            points.add(new Point(x, y));
            colors.add(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
        }
        revalidate();
        repaint();
    }

    @Override
    public void paintComponent(Graphics graphics) {

        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {

                int minDistIndex = 0;

                for (int i = 1; i < points.size(); i++) {
                    float dist1 = getDistance(x, y, points.get(i).x, points.get(i).y);
                    float dist2 = getDistance(x, y, points.get(minDistIndex).x, points.get(minDistIndex).y);
                    if (dist1 < dist2) {
                        minDistIndex = i;
                    }
                }

                if (points.size() > 0) {
                    g.setColor(colors.get(minDistIndex));
                }
                g.fillRect(x, y, 1, 1);
            }
        }

        for (int i = 0; i < points.size(); i++) {

            g.setColor(Color.BLUE);
            g.fillOval((int) points.get(i).getX() - pointRadius, (int) points.get(i).getY() - pointRadius,
                    2 * pointRadius, 2 * pointRadius);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        points.add(e.getPoint());
        // float f = random.nextFloat();
        colors.add(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
        revalidate();
        repaint();

    }

    public float euclidianDistance(int x1, int y1, int x2, int y2) {

        double x = Math.pow(x2 - x1, 2);
        double y = Math.pow(y2 - y1, 2);

        return (float) Math.sqrt(x + y);

    }

    public float getDistance(int x1, int y1, int x2, int y2) {

        if (manhattan) {
            return manhattanDistance(x1, y1, x2, y2);
        } else {
            return euclidianDistance(x1, y1, x2, y2);
        }

    }

    public float manhattanDistance(int x1, int y1, int x2, int y2) {

        return Math.abs(x2 - x1) + Math.abs(y2 - y1);

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
