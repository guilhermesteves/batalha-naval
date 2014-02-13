package com.guilhermeesteves.batalhanaval.util;

/**
 * Fun��es gen�ricas para serem usadas por todas
 * as classes do jogo.
 * 
 * @author Guilherme Esteves
 *
 */
public class Utils {
	
	public static int gerarPosicaoEntreUmE(int maximo) {
		return gerarPosicaoEntre(1, maximo);		
	}
	
	public static int gerarPosicaoEntre(int minimo, int maximo) {
		return minimo + (int)(Math.random() * ((maximo - minimo) + 1));
	}
}
