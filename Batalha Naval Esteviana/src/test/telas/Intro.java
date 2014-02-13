package test.telas;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import org.apache.log4j.Logger;
import org.pushingpixels.trident.Timeline;

import com.guilhermeesteves.batalhanaval.util.CONSTANTES;

public class Intro extends JPanel {
	private static Logger logger = Logger.getLogger(Intro.class);
	
	float opacity;
	Timeline timeline;
	
	
	public Intro() {
		timeline = new Timeline(this);
		timeline.addPropertyToInterpolate("opacity", 1.0f, 0.0f);
		timeline.setDuration(5000);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		Image imagem = Toolkit.getDefaultToolkit().getImage(CONSTANTES.IMAGENS.FUNDO_MENU_INICIAL);
		Image imagem2 = Toolkit.getDefaultToolkit().getImage(CONSTANTES.IMAGENS.LOGO_MENU_INICIAL);
		
		g2d.setComposite(AlphaComposite.SrcOver.derive((int)1.0 - this.opacity));
		g2d.drawImage(imagem2, 0, 0, this.getWidth(), this.getHeight(), this);	
		
		g2d.setComposite(AlphaComposite.SrcOver.derive(this.opacity));
		g2d.drawImage(imagem, 0, 0, this.getWidth(), this.getHeight(), this);

		g2d.dispose();
	}
	
	public void animate() {
		
		timeline.play();
	}

	public float getOpacity() {
		return opacity;
	}

	public void setOpacity(float opacity) {
		this.opacity = opacity;
	}
}
