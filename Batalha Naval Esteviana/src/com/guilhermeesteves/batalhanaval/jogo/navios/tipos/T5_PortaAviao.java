package com.guilhermeesteves.batalhanaval.jogo.navios.tipos;

import com.guilhermeesteves.batalhanaval.jogo.navios.Embarcacao;
import com.guilhermeesteves.batalhanaval.jogo.navios.TipoDeEmbarcacao;
import com.guilhermeesteves.batalhanaval.util.CONSTANTES;

/**
 * Classe modelo do Porta Avi�o.
 * Embarca��o com 5 partes.
 * H� apenas 1 dela no jogo.
 * 
 * @author Guilherme Esteves
 *
 */
public class T5_PortaAviao extends Embarcacao {
	
	public T5_PortaAviao() {
		super();
	}
	
	@Override
	public TipoDeEmbarcacao getTipoDeEmbarcacao() {
		return TipoDeEmbarcacao.PORTA_AVIAO;
	}

	@Override
	public int getTamanho() {
		return CONSTANTES.EMBARCACOES.TAMANHO.PORTA_AVIAO;
	}
}
