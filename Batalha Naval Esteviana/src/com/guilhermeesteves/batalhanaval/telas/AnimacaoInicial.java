package com.guilhermeesteves.batalhanaval.telas;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.guilhermeesteves.batalhanaval.util.CONSTANTES;

public class AnimacaoInicial extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6055771802008655116L;

	private static Logger logger = Logger.getLogger(AnimacaoInicial.class);
	
	private BufferedImage buffer;
	private boolean isFading = false;
	private long start;
	private float alpha = 1.0f;
	private float noAlpha = 0.0f;
	
	/**
	 * Create the panel.
	 */
	public AnimacaoInicial() {
		logger.info(CONSTANTES.LOG.INICIANDO+"Animação Inicial");
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {  
		this.setBounds(100, 100, 800, 680);
		this.setBackground(Color.BLACK);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		buffer = new BufferedImage(450, 70, BufferedImage.TYPE_INT_ARGB);
		try {
			buffer = ImageIO.read(new File(CONSTANTES.IMAGENS.LOGO_INTRO_TESTE));
		} catch (IOException eIO) {
			eIO.printStackTrace();
		}
		
		this.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		if (isFading) {// During fading, we prevent child components from being painted
			//g.clearRect(0, 0, getWidth(), getHeight());
			((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
			g.drawImage(buffer, this.getWidth()/2-450/2, this.getHeight()/2-70/2, this);// We only draw an image of them with an alpha
		} else {
			super.paint(g);
			g.drawImage(buffer, this.getWidth()/2-450/2, this.getHeight()/2-70/2, this);
		}
	}
	
	public void fadeIn(int time) {
		start = System.currentTimeMillis();
		this.print(buffer.getGraphics());// Draw the current components on the buffer
		isFading = true;
		final int timeInMillis = time * 1000;
		final Timer t = new Timer(50, null);
		t.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				long elapsed = System.currentTimeMillis() - start;
				if (elapsed > timeInMillis) {
					start = 0;
					isFading = false;
					buffer = null;
					repaint();
					t.stop();
				} else {
					alpha = 1.0f - (float) elapsed / timeInMillis;
					repaint();
				}
			}
		});
		t.start();
	}
	/*
	public void paintComponent(Graphics g) {
		//Image imagem = Toolkit.getDefaultToolkit().getImage(
		//		JPanel.class.getResource(CONSTANTES.IMAGENS.FUNDO_MENU_INICIAL));
		Image imagem = Toolkit.getDefaultToolkit().getImage(CONSTANTES.IMAGENS.LOGO_INTRO);
		g.drawImage(imagem, 
				this.getWidth()/2-450/2, 
				this.getHeight()/2-70/2, 
				450, 
				70, 
				this);
	}*/
}
