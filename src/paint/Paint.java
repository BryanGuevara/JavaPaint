package paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Paint extends JFrame {

    BufferedImage image;
    Graphics2D g2d;

    public Paint() {
        initComponents();
        setTitle("Java Paint Bag´s Version");
        setResizable(false);
        setSize(800, 700);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLACK);
        image = new BufferedImage(800, 700, BufferedImage.TYPE_INT_RGB);
        g2d = image.createGraphics();
        g2d.setColor(Color.green);
        g2d.setStroke(new BasicStroke(2));

        DrawPanel drawPanel = new DrawPanel();
        this.setContentPane(drawPanel);

        MouseAdapter mouse = new MouseAdapter() {
            private Point point = new Point();

            @Override
            public void mousePressed(MouseEvent e) {
                point.setLocation(e.getPoint());
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                g2d.drawLine(point.x, point.y, e.getX(), e.getY());
                point.setLocation(e.getPoint());
                drawPanel.repaint();
            }
        };
        drawPanel.addMouseListener(mouse);
        drawPanel.addMouseMotionListener(mouse);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Paint().setVisible(true);
            }
        });
    }

    class DrawPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
