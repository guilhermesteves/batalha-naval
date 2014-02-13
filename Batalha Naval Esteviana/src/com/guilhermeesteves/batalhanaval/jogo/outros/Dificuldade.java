package com.guilhermeesteves.batalhanaval.jogo.outros;

import com.guilhermeesteves.batalhanaval.util.CONSTANTES;

/**
 * Enum das dificuldades do jogo
 * 
 * @author Guilherme Esteves
 *
 */
public enum Dificuldade {
	FACIL {
	    @Override
		public String toString() {
	        return CONSTANTES.DIFICULDADE.FACIL;
	    }
	}, 
	NORMAL {
	    @Override
		public String toString() {
	        return CONSTANTES.DIFICULDADE.NORMAL;
	    }
	},
	DIFICIL {
	    @Override
		public String toString() {
	        return CONSTANTES.DIFICULDADE.DIFICIL;
	    }
	};
}
