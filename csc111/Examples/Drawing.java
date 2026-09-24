
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing {
    private JFrame frame;
    private JPanel panel;

    public Drawing() {
        // change the drawing size here
        final int w = 960, h = 800;

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel =
                new JPanel() {
                    @Override
                    public void paintComponent(Graphics g) {
                        super.paintComponent(g);

                        // you can change the drawing color here
                        g.setColor(Color.BLACK);

                        // call your fractal function here
                        fractal(g, 12, 0, h, w / 2, 0, w, h);
                    }
                };
        // you can change the bg color here
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(w, h));

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        frame.setFocusable(true);
        frame.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                        }
                    }
                });
    }

    public static void main(String[] args) {
        new Drawing();
    }

    // feel free to change the parameters, but don't delete the Graphics or you
    // won't be able to draw anything!
    public static void fractal(Graphics g, int level, int x1, int y1, int x2, int y2, int x3, int y3) {
        // rewrite this function to recursively draw your fractal
        if(level == 0) {
            g.drawLine(x1, y1, x2, y2);
            g.drawLine(x2, y2, x3, y3);
            g.drawLine(x1, y1, x3, y3);
        } else {
            int x12 = (x1 + x2) / 2;
            int y12 = (y1 + y2) / 2;
            int x23 = (x2 + x3) / 2;
            int y23 = (y2 + y3) / 2;
            int x13 = (x1 + x3) / 2;
            int y13 = (y1 + y3) / 2;

            fractal(g, level - 1, x1, y1, x12, y12, x13, y13);
            fractal(g, level - 1, x12, y12, x2, y2, x23, y23);
            fractal(g, level - 1, x13, y13, x23, y23, x3, y3);
        }
    }
}