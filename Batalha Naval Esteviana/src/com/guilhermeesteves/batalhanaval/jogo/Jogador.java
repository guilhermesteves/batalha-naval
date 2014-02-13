package com.guilhermeesteves.batalhanaval.jogo;

/**
 * Modelo que armazena todas as informações
 * referentes ao jogador.
 * 
 * @author Guilherme Esteves
 *
 */
public class Jogador {
	
	private String nome;
	private int pontos;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
}
