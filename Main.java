import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT event classes and listener interfaces
import javax.swing.*;    // Using Swing's components and containers

/** Custom Drawing Code Template */
// A Swing application extends javax.swing.JFrame
public class Main2 extends JFrame implements KeyListener, MouseListener {
    // Define constants
    public static final int CANVAS_WIDTH  = 640;
    public static final int CANVAS_HEIGHT = 480;

    // Declare an instance of the drawing canvas,
    // which is an inner class called DrawCanvas extending javax.swing.JPanel.
    private DrawCanvas canvas;

    private int x = 150;
    private int y = 100;

    // Constructor to set up the GUI components and event handlers
    public Main2() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        addMouseListener(this);

        canvas = new DrawCanvas();    // Construct the drawing canvas
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

        // Set the Drawing JPanel as the JFrame's content-pane
        Container cp = getContentPane();
        cp.add(canvas);
        // or "setContentPane(canvas);"

        setDefaultCloseOperation(EXIT_ON_CLOSE);   // Handle the CLOSE button
        pack();              // Either pack() the components; or setSize()
        setTitle("......");  // "super" JFrame sets the title
        setVisible(true);    // "super" JFrame show
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();    
        if (key == KeyEvent.VK_D){
            this.x += 5;
            repaint();
        }
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public void mousePressed(MouseEvent e) {
        this.x = e.getX() - 5;
        this.y = e.getY() - this.getInsets().top - 5;
        repaint();
    }

    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {} 
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}

    /**
    * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
    */
    private class DrawCanvas extends JPanel {
        // Override paintComponent to perform your own painting
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);     // paint parent's background
            setBackground(Color.BLACK);  // set background color for this JPanel

            // Your custom painting codes. For example,
            // Drawing primitive shapes
            g.setColor(Color.YELLOW);    // set the drawing color
            g.fillOval(x, y, 10, 10);
        }
    }

    // The entry main method
    public static void main(String[] args) {
        // Run the GUI codes on the Event-Dispatching thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main2 main = new Main2(); // Let the constructor do the job
            }
        });
    }
}