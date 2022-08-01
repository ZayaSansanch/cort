import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class otskok extends JPanel {
    private Object object;

    public static void main(String args[]) {
        JFrame frame = new JFrame();
        // frame.add(frame, new otskok());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setBounds(500, 115, 500, 750);

        frame.object = new Object();

        Timer timer = new Timer(30, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                object.move();
                repaint();
            }
        });

        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // System.out.println("Start!");
                timer.start();
            }
        });

        JPanel panel = new JPanel();
        panel.add(start);
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.PAGE_START);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.drawShape(g);
        }
    }

    class Object {
        int D_HEIGHT = 500;
        int D_WIDTH = 400;

        Random random = new Random();
        int randXLoc = random.nextInt(D_WIDTH);
        int y = D_HEIGHT;

        public void move() {

        }

        public void drawShape(Graphics g) {
            g.setColor(Color.GREEN);
            g.fillOval(randXLoc, y, 50, 50);
        }
    }
}