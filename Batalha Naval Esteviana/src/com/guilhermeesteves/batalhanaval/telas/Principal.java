package com.guilhermeesteves.batalhanaval.telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Principal {
	
	private JFrame frame;
	private JPanel painel;
	
	//private JPanel preAnimacao = getPreAnimacaoInicial();
	//private JPanel telaInicial = getTelaInicial();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();  
		frame.setBounds(100, 100, 800, 680);
		frame.setUndecorated(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-800/2, dim.height/2-680/2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		painel = new JPanel();
		painel.setBackground(Color.BLACK);		
		
		frame.add(painel);
	}
}
