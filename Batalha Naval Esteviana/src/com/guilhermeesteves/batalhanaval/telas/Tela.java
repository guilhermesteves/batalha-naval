package com.guilhermeesteves.batalhanaval.telas;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.guilhermeesteves.batalhanaval.telas.util.Animar;
import com.guilhermeesteves.batalhanaval.util.CONSTANTES;


public class Tela extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 836357981845097742L;

	private JPanel painel;
	
	private Rectangle posicaoInicial;
	private Rectangle posicaoFinal;

	public Tela() {
		setLayout(null);
		painel = new JPanel() {
			protected void paintComponent(Graphics g) {
				Image imagem = Toolkit.getDefaultToolkit().getImage(
						JPanel.class.getResource(CONSTANTES.IMAGENS.FUNDO_MENU_INICIAL));
				g.drawImage(imagem, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
	}
	
	public void TelaInicial() {
		paintComponent(this.painel.getGraphics());	
	}
	
	
	
	
	/******************************************************
	 * Fade In & Fade Out
	******************************************************/	
	
	private BufferedImage buffer;
	private boolean isFading = false;
	private long start;
	private float alpha = 1.0f;
	private float noAlpha = 0.0f;

	@Override
	public void paint(Graphics g) {
		if (isFading) {// During fading, we prevent child components from being painted
			g.clearRect(0, 0, getWidth(), getHeight());
			((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
			g.drawImage(buffer, 0, 0, this);// We only draw an image of them with an alpha
		} else {
			super.paint(g);
		}
	}

	public void fadeIn(double segundos) {
		start = System.currentTimeMillis();
		buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		this.print(buffer.getGraphics());// Draw the current components on the buffer
		isFading = true;
		final int timeInMillis = (int)segundos * 1000;
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
	
	/******************************************************
	 * Animações
	******************************************************/	
	
	public void animar() {
		
		if (painel != null && posicaoInicial != null && posicaoFinal != null) {
			Animar animacao = new Animar(painel, posicaoInicial, posicaoFinal);
			animacao.iniciar();
		}
	}
	
	public Dimension getTamanhoPadrao() {
        return new Dimension(CONSTANTES.TELA.LARGURA, CONSTANTES.TELA.ALTURA);
    }

	public Rectangle getPosicaoInicial() {
		return posicaoInicial;
	}

	public void setPosicaoInicial(Rectangle posicaoInicial) {
		this.posicaoInicial = posicaoInicial;
	}
	
	public void setPosicaoInicialTelaCheia(int x, int y) {
		this.posicaoInicial = new Rectangle(x, y, 
				CONSTANTES.TELA.LARGURA, 
				CONSTANTES.TELA.ALTURA);
	}

	public Rectangle getPosicaoFinal() {
		return posicaoFinal;
	}

	public void setPosicaoFinal(Rectangle posicaoFinal) {
		this.posicaoFinal = posicaoFinal;
	}
	
	public void setPosicaoFinalTelaCheia(int x, int y) {
		this.posicaoFinal = new Rectangle(x, y, 
				CONSTANTES.TELA.LARGURA, 
				CONSTANTES.TELA.ALTURA);
	}
}
