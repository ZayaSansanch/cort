import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;

public class painting extends JFrame {
    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.add(new painting());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setBounds(500, 115, 500, 750);
    }

    public painting() {
        Timer timer = new Timer(30, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                painting.move();
                painting.decreaseDelay();
                repaint();
            }
        });
        JButton newfile = new JButton("NewFile");
        newfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("New file");
            }
        });

        JPanel panel = new JPanel();
        panel.add(newfile);
        setLayout(new BorderLayout());
        add(panel, BorderLayout.PAGE_START);
    }
}
