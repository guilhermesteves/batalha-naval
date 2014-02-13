package com.guilhermeesteves.batalhanaval.jogo.navios.tipos;

import com.guilhermeesteves.batalhanaval.jogo.navios.Embarcacao;
import com.guilhermeesteves.batalhanaval.jogo.navios.TipoDeEmbarcacao;
import com.guilhermeesteves.batalhanaval.util.CONSTANTES;

/**
 * Classe modelo do Submarino.
 * Embarcação com apenas 1 parte.
 * Há 2 delas no jogo.
 * 
 * @author Guilherme Esteves
 *
 */
public class T1_Submarino extends Embarcacao {
	
	public T1_Submarino() {
		super();
	}
	
	@Override
	public TipoDeEmbarcacao getTipoDeEmbarcacao() {
		return TipoDeEmbarcacao.SUBMARINO;
	}

	@Override
	public int getTamanho() {
		return CONSTANTES.EMBARCACOES.TAMANHO.SUBMARINO;
	}
}