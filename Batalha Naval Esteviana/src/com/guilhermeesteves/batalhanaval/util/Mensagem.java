package com.guilhermeesteves.batalhanaval.util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Mensagem {
	
	final static JFrame window = new JFrame();
		
	public static int qualADificuldade() {
		return multiplaEscolha(CONSTANTES.MENSAGENS.PERGUNTAS.DIFICULDADE, 
				CONSTANTES.DIFICULDADE.getTodasAsOpcoes());
	}
	
	private static int multiplaEscolha(Object mensagem, Object[] options) {	
		
		int escolha = JOptionPane.showOptionDialog( window,
													mensagem,
													CONSTANTES.NOME,
													JOptionPane.YES_NO_CANCEL_OPTION,
													JOptionPane.QUESTION_MESSAGE,
													null,
													options,
													options[options.length-1]);
		return escolha;
	}
}
