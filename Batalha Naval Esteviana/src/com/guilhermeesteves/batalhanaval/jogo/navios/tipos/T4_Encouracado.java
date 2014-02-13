package com.guilhermeesteves.batalhanaval.jogo.navios.tipos;

import com.guilhermeesteves.batalhanaval.jogo.navios.Embarcacao;
import com.guilhermeesteves.batalhanaval.jogo.navios.TipoDeEmbarcacao;
import com.guilhermeesteves.batalhanaval.util.CONSTANTES;

/**
 * Classe modelo do Encouraçado.
 * Embarcação com 4 partes.
 * Há apenas 1 dela no jogo.
 * 
 * @author Guilherme Esteves
 *
 */
public class T4_Encouracado extends Embarcacao {
	
	public T4_Encouracado() {
		super();
	}
	
	@Override
	public TipoDeEmbarcacao getTipoDeEmbarcacao() {
		return TipoDeEmbarcacao.ENCOURACADO;
	}

	@Override
	public int getTamanho() {
		return CONSTANTES.EMBARCACOES.TAMANHO.ENCOURACADO;
	}
}
