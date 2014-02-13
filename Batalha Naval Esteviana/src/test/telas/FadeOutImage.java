package test.telas;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.guilhermeesteves.batalhanaval.util.CONSTANTES;

public class FadeOutImage extends JPanel implements ActionListener {
	Image minhaImagem;
	int x;
	int y;

	Timer timer; 

	private float alpha = 0f;

	public FadeOutImage(String imagem, int x, int y) {
		this(imagem, x, y, 5);
	}
	
	public FadeOutImage(String imagem, int x, int y, int timerDelay) {
		minhaImagem = new ImageIcon(imagem).getImage();
		this.x = x;
		this.y = y;
		timer = new Timer(timerDelay, this);
		
		timer.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g2d.drawImage(minhaImagem, this.x, this.y, null);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getID() == 1) {
			fadeIn();
		} else if (e.getID() == 0) {
			fadeOut();
		}
	}
	
	public void fadeIn() {
		
		alpha += +0.01f;
		if (alpha >= 1) {
			alpha = 1;
			timer.stop();
		}
		repaint();
	}
	
	public void fadeOut() {
		
		alpha += -0.01f;
		if (alpha <= 0) {
			alpha = 0;
			timer.stop();
		}
		repaint();
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fade out");
		FadeOutImage foi = new FadeOutImage(CONSTANTES.IMAGENS.LOGO_INTRO_TESTE, 0, 0, 2);
		foi.setOpaque(false);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.add(foi);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 70);
		frame.setUndecorated(true);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-450/2, dim.height/2-70/2);
		frame.setVisible(true);
		foi.actionPerformed(new ActionEvent(foi, 0, "fadeout"));
		//foi.actionPerformed(new ActionEvent(foi, 1, "fadein"));
	}

}
