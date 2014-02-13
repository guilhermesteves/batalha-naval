package com.guilhermeesteves.batalhanaval.jogo.navios;

import com.guilhermeesteves.batalhanaval.util.CONSTANTES;

/**
 * 
 * Essa classe lista os tipos de embarca��es do jogo. 
 * A diferen�a est� na forma e no tamanho das embarca��es.
 * 
 * Tamanhos: 
 * 
 * Submarino - 1
 * Corveta - 2
 * Fragata - 3
 * Encoura�ado - 4
 * Porta Avi�o - 5
 * 
 * @author Guilherme Esteves
 *
 */
public enum TipoDeEmbarcacao {
	
	SUBMARINO {
	    @Override
		public String toString() {
	        return CONSTANTES.EMBARCACOES.TIPOS.SUBMARINO;
	    }
	},
	CORVETA {
	    @Override
		public String toString() {
	        return CONSTANTES.EMBARCACOES.TIPOS.CORVETA;
	    }
	},
	FRAGATA {
	    @Override
		public String toString() {
	        return CONSTANTES.EMBARCACOES.TIPOS.FRAGATA;
	    }
	},
	ENCOURACADO {
	    @Override
		public String toString() {
	        return CONSTANTES.EMBARCACOES.TIPOS.ENCOURACADO;
	    }
	},
	PORTA_AVIAO {
	    @Override
		public String toString() {
	        return CONSTANTES.EMBARCACOES.TIPOS.PORTA_AVIAO;
	    }
	};
}
