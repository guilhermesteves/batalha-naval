package com.guilhermeesteves.batalhanaval.jogo.outros;

/**
 * Enum das dire��es que uma embarca��o
 * pode ter.
 * 
 * @author Guilherme Esteves
 *
 */
public enum Direcao {
	CIMA, 
	DIREITA, 
	BAIXO, 
	ESQUERDA;
	
	public static Direcao getViaNumber(int number) {
		
		switch (number) {
			case 1:
				return CIMA;
	            
	        case 2:
	        	return DIREITA;
	            
	        case 3:
	        	return BAIXO;
	            
	        case 4:
	        	return ESQUERDA;
        	
	        default:
	        	return ESQUERDA;
		}
	}
}
