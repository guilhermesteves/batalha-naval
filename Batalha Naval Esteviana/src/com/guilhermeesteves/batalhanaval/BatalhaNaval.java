package com.guilhermeesteves.batalhanaval;

import com.guilhermeesteves.batalhanaval.jogo.Jogador;
import com.guilhermeesteves.batalhanaval.jogo.Tabuleiro;
import com.guilhermeesteves.batalhanaval.jogo.outros.Dificuldade;

/**
 * Classe principal do jogo, que contém
 * todas as informações do jogador, 
 * tabuleiro e etc.
 * 
 * @author Guilherme Esteves
 *
 */
public class BatalhaNaval {
	
	private int numerosDeTentativas;
	
	private int tirosNaAgua;
	private int tirosNasEmbarcacoes;
	
	private Dificuldade dificuldade;
	private Tabuleiro tabuleiro;
	private Jogador jogador;
	
	
	public void preparaJogo() {
		this.tabuleiro = new Tabuleiro(this.dificuldade);
	}
	
	// Getters & Setters
	public int getNumerosDeTentativas() {
		return numerosDeTentativas;
	}


	public void setNumerosDeTentativas(int numerosDeTentativas) {
		this.numerosDeTentativas = numerosDeTentativas;
	}


	public int getTirosNaAgua() {
		return tirosNaAgua;
	}


	public void setTirosNaAgua(int tirosNaAgua) {
		this.tirosNaAgua = tirosNaAgua;
	}


	public int getTirosNasEmbarcacoes() {
		return tirosNasEmbarcacoes;
	}


	public void setTirosNasEmbarcacoes(int tirosNasEmbarcacoes) {
		this.tirosNasEmbarcacoes = tirosNasEmbarcacoes;
	}


	public Dificuldade getDificuldade() {
		return dificuldade;
	}


	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}
	
	public void setDificuldade(int dificuldade) {
		if (dificuldade == 2) {
			this.dificuldade = Dificuldade.DIFICIL;
		} else if (dificuldade == 1) {
			this.dificuldade = Dificuldade.NORMAL;
		} else {
			this.dificuldade = Dificuldade.FACIL;
		}
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}


	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}


	public Jogador getJogador() {
		return jogador;
	}


	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
}
