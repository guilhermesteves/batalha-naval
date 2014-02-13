package com.guilhermeesteves.batalhanaval.jogo.navios;

import java.util.ArrayList;
import java.util.List;

import com.guilhermeesteves.batalhanaval.jogo.outros.Coordenada;
import com.guilhermeesteves.batalhanaval.jogo.outros.Direcao;
import com.guilhermeesteves.batalhanaval.util.Utils;

/**
 * Classe que representa genericamente todas
 * as embarcações e suas funções comuns.
 * 
 * @author Guilherme Esteves
 *
 */
public abstract class Embarcacao {
	
	private List<Coordenada> coordenadas;
	Direcao direcao; 
	private boolean afundou;
	
	public Embarcacao() {
		setDirecaoAleatoria();
	}
	
	// Getters e Setters
	public List<Coordenada> getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(List<Coordenada> posicao) {
		this.coordenadas = posicao;
	}
	
	public void addPosicao(Coordenada posicao) {
		if (this.coordenadas == null) {
			this.coordenadas = new ArrayList<Coordenada>();
		}
		this.coordenadas.add(posicao);
	}

	public Direcao getDirecao() {
		return direcao;
	}

	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}
	
	public void setDirecaoAleatoria() {
		this.direcao = Direcao.getViaNumber(Utils.gerarPosicaoEntreUmE(4));
	}

	public boolean isAfundou() {
		return afundou;
	}

	public void setAfundou(boolean afundou) {
		this.afundou = afundou;
	}
	
	public abstract TipoDeEmbarcacao getTipoDeEmbarcacao();
	public abstract int getTamanho();
	
}
