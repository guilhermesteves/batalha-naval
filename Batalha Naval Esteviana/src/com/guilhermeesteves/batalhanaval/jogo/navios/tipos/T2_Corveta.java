package com.guilhermeesteves.batalhanaval.jogo.navios.tipos;

import com.guilhermeesteves.batalhanaval.jogo.navios.Embarcacao;
import com.guilhermeesteves.batalhanaval.jogo.navios.TipoDeEmbarcacao;
import com.guilhermeesteves.batalhanaval.util.CONSTANTES;

/**
 * Classe modelo do Corveta.
 * Embarcação com 2 partes.
 * Há apenas 1 dela no jogo.
 * 
 * @author Guilherme Esteves
 *
 */
public class T2_Corveta extends Embarcacao {

	public T2_Corveta() {
		super();
	}
	
	public TipoDeEmbarcacao getTipoDeEmbarcacao() {
		return TipoDeEmbarcacao.CORVETA;
	}
	
	public int getTamanho() {
		return CONSTANTES.EMBARCACOES.TAMANHO.CORVETA;
	}
}
