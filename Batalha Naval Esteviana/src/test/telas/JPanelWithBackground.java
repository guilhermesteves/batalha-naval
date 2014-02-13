package test.telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JPanelWithBackground extends JPanel {
    private static final long serialVersionUID = 1L;
    Image imageOrg = null;

    public JPanelWithBackground(Image image2) {
        imageOrg = image2;
        setOpaque(false);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(imageOrg.getWidth(this), imageOrg.getHeight(this));
    }

    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
        if (imageOrg != null) {
            System.err.println("painting");
            g.drawImage(imageOrg, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    JFrame frame = new JFrame();
                    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                	// Make sure where in the top left corner, please lookup how
                	// to find the screen insets ;)
                    frame.setLocation(0, 0);
                    frame.setSize(dim);
                	// Set undecorated
                    frame.setUndecorated(true);
                    JPanelWithBackground panel = new JPanelWithBackground(new ImageIcon(new URL(
                            "http://www.lemondedemario.fr/images/dossier/bowser/bowser.png")).getImage());
                    JPanel greenPanel = new JPanel(new BorderLayout());
                    greenPanel.setBackground(new Color(255,0,0,0));
                    greenPanel.add(panel);
                    greenPanel.setOpaque(false);
                    frame.add(greenPanel);
                    frame.pack();
                    frame.setVisible(true);
                } catch (MalformedURLException e) {
                    // Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}
