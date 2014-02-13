package test.telas;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.guilhermeesteves.batalhanaval.telas.util.Animar;

public class TestesDePainel extends JFrame {

    private JPanel panel;

    public TestesDePainel() {
    	panel = new JPanel();
    }

    public void TesteDeAnimacao() {
    	setLayout(null);
    	panel.setBackground(Color.RED);
    	add(panel);
    	Dimension size = getPreferredSize();

    	Rectangle from = new Rectangle(size.width, (size.height - 50) / 2, 50, 50);
    	Rectangle to = new Rectangle((size.width - 50) / 2, (size.height - 50) / 2, 50, 50);

    	Animar animar = new Animar(panel, from, to);
    	animar.iniciar();
    }

    public void TesteDeOpacidade() {
    	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	// Make sure where in the top left corner, please lookup how
    	// to find the screen insets ;)
    	setLocation(0, 0);
    	setSize(dim);
    	// Set undecorated
    	setUndecorated(true);
    	// Apply a transparent color to the background
    	// This is ALL important, without this, it won't work!
    	setBackground(new Color(0, 0, 0, 0));

    	// This is where we get sneaky, basically where going to 
    	// supply our own content pane that does some special painting
    	// for us
    	setContentPane(new ContentPane());
    	getContentPane().setBackground(Color.BLACK);
    	setLayout(new BorderLayout());

    	// Add out image pane...    
    	JPanel panel = new JPanel();
    	add(panel);

    	setVisible(true);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
    
    public class ContentPane extends JPanel {

        public ContentPane() {

            setOpaque(false);

        }

        @Override
        protected void paintComponent(Graphics g) {

            // Allow super to paint
            super.paintComponent(g);

            // Apply our own painting effect
            Graphics2D g2d = (Graphics2D) g.create();
            // 50% transparent Alpha
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));

            g2d.setColor(getBackground());
            g2d.fill(getBounds());

            g2d.dispose();

        }

    }

}
