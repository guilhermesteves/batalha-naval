package com.guilhermeesteves.batalhanaval.telas;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.guilhermeesteves.batalhanaval.util.CONSTANTES;

public class TelaInicial extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4131788898572805431L;
	private static Logger logger = Logger.getLogger(TelaInicial.class);	

	/**
	 * Create the panel.
	 */
	public TelaInicial() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {  
		this.setBounds(0, 0, 800, 680);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		/* TODO MOVER BOTÕES PARA FRAME
		 * 
		 * LOGO 
		 * W 600 | H 200 - X 100 | Y 50
		 * 
		 * */
		ImageIcon imagemLogo = new ImageIcon(CONSTANTES.IMAGENS.LOGO_MENU_INICIAL); 
		JLabel logo = new JLabel();
		logo.setIcon(imagemLogo);
		logo.setBounds(100, 50, 600, 150);
		logo.setOpaque(false);
		this.add(logo);
		
		
		/*
		JButton novoJogo = new JButton(new ImageIcon(CONSTANTES.IMAGENS.BOTOES.NOVO_JOGO));
		
		novoJogo.setRolloverIcon(new ImageIcon(CONSTANTES.IMAGENS.BOTOES.NOVO_JOGO_MOUSEOVER));
		novoJogo.setBounds(250, 250, 300, 80);
		novoJogo.setOpaque(false);
		novoJogo.setContentAreaFilled(false);
		novoJogo.setBorderPainted(false);*/
		JButton novoJogo = novoBotao(CONSTANTES.IMAGENS.BOTOES.NOVO_JOGO,
				CONSTANTES.IMAGENS.BOTOES.NOVO_JOGO_MOUSEOVER,
				250);
		this.add(novoJogo);
		
		JButton recordes = new JButton(new ImageIcon(CONSTANTES.IMAGENS.BOTOES.RECORDES));
		recordes.setRolloverIcon(new ImageIcon(CONSTANTES.IMAGENS.BOTOES.RECORDES_MOUSEOVER));
		recordes.setBounds(250, 350, 300, 80);
		recordes.setOpaque(false);
		recordes.setContentAreaFilled(false);
		recordes.setBorderPainted(false);
		this.add(recordes);
		
		JButton creditos = new JButton(new ImageIcon(CONSTANTES.IMAGENS.BOTOES.CREDITOS));
		creditos.setRolloverIcon(new ImageIcon(CONSTANTES.IMAGENS.BOTOES.CREDITOS_MOUSEOVER));
		creditos.setBounds(250, 450, 300, 80);
		creditos.setOpaque(false);
		creditos.setContentAreaFilled(false);
		creditos.setBorderPainted(false);
		this.add(creditos);
		
		JButton sair = new JButton(new ImageIcon(CONSTANTES.IMAGENS.BOTOES.SAIR));
		sair.setRolloverIcon(new ImageIcon(CONSTANTES.IMAGENS.BOTOES.SAIR_MOUSEOVER));
		sair.setBounds(250, 550, 300, 80);
		sair.setOpaque(false);
		sair.setContentAreaFilled(false);
		sair.setBorderPainted(false);
		
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logger.info("Fim de jogo. (Via menu)");
				System.exit(0);
			}
		});
		this.add(sair);
	}
	
	public void paintComponent(Graphics g) {
		//Image imagem = Toolkit.getDefaultToolkit().getImage(
		//		JPanel.class.getResource(CONSTANTES.IMAGENS.FUNDO_MENU_INICIAL));
		Image imagem = Toolkit.getDefaultToolkit().getImage(CONSTANTES.IMAGENS.FUNDO_MENU_INICIAL);
		g.drawImage(imagem, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	public JButton novoBotao(String imagem, String imageMouseOver, int y) {
		JButton novo = new JButton(new ImageIcon(imagem));
		novo.setRolloverIcon(new ImageIcon(imageMouseOver));
		novo.setBounds(
				CONSTANTES.TELA.BOTAO_X, 
				y, 
				CONSTANTES.TELA.BOTAO_LARGURA,
				CONSTANTES.TELA.BOTAO_ALTURA);
		
		novo.setOpaque(false);
		novo.setContentAreaFilled(false);
		novo.setBorderPainted(false);
		
		return novo;
	}
}
