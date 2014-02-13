package com.guilhermeesteves.batalhanaval.jogo.navios.tipos;

import com.guilhermeesteves.batalhanaval.jogo.navios.Embarcacao;
import com.guilhermeesteves.batalhanaval.jogo.navios.TipoDeEmbarcacao;
import com.guilhermeesteves.batalhanaval.util.CONSTANTES;

/**
 * Classe modelo do Fragata.
 * Embarcação com 3 partes.
 * Há apenas 1 dela no jogo.
 * 
 * @author Guilherme Esteves
 *
 */
public class T3_Fragata extends Embarcacao {
	
	public T3_Fragata() {
		super();
	}
	
	@Override
	public TipoDeEmbarcacao getTipoDeEmbarcacao() {
		return TipoDeEmbarcacao.FRAGATA;
	}

	@Override
	public int getTamanho() {
		return CONSTANTES.EMBARCACOES.TAMANHO.FRAGATA;
	}	
}
