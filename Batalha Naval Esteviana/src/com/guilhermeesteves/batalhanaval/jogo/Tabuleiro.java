package com.guilhermeesteves.batalhanaval.jogo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guilhermeesteves.batalhanaval.jogo.navios.Embarcacao;
import com.guilhermeesteves.batalhanaval.jogo.navios.tipos.T1_Submarino;
import com.guilhermeesteves.batalhanaval.jogo.navios.tipos.T2_Corveta;
import com.guilhermeesteves.batalhanaval.jogo.navios.tipos.T3_Fragata;
import com.guilhermeesteves.batalhanaval.jogo.navios.tipos.T4_Encouracado;
import com.guilhermeesteves.batalhanaval.jogo.navios.tipos.T5_PortaAviao;
import com.guilhermeesteves.batalhanaval.jogo.outros.Coordenada;
import com.guilhermeesteves.batalhanaval.jogo.outros.Dificuldade;
import com.guilhermeesteves.batalhanaval.jogo.outros.Direcao;
import com.guilhermeesteves.batalhanaval.jogo.outros.Posicao;
import com.guilhermeesteves.batalhanaval.util.Utils;

/**
 * Classe responsável pela gerência do
 * tabuleiro e suas embarcações.
 * 
 * @author Guilherme Esteves
 *
 */
public class Tabuleiro {
	
	private Map<Posicao, Coordenada> matrizDePosicoes;
	private List<Embarcacao> embarcacoes;
	private int tamanho;
	
	public Tabuleiro(Dificuldade dificuldade) {
		this.setMatrizDePosicoes(gerarTabuleiro(dificuldade));
		gerarEmbarcacoes();
	}
	
	private Map<Posicao, Coordenada> gerarTabuleiro(Dificuldade dificuldade) {
		Map<Posicao, Coordenada> matriz = new HashMap<Posicao,Coordenada>();
		int tamanho;
		
		if (dificuldade == Dificuldade.DIFICIL) {
			tamanho = 20;
		} else if (dificuldade == Dificuldade.NORMAL) {
			tamanho = 15;
		} else {
			tamanho = 10;
		}
		
		this.setTamanho(tamanho);
		
		for (int x = 1; x <= tamanho; x++) {
			for (int y = 1; y <= tamanho; y++) {
				Posicao p = new Posicao(x, y);
				Coordenada c = new Coordenada(x, y);
				
				matriz.put(p, c);
			}
		}
		
		return matriz;
	}
	
	private void gerarEmbarcacoes() {

		gerarEmbarcacao(new T5_PortaAviao());
		gerarEmbarcacao(new T4_Encouracado());
		gerarEmbarcacao(new T3_Fragata());
		gerarEmbarcacao(new T2_Corveta());
		gerarEmbarcacao(new T1_Submarino());
		gerarEmbarcacao(new T1_Submarino());		
		System.out.println("TODAS AS EMBARCAÇÕES GERADAS!");
	}
	
	private void gerarEmbarcacao(Embarcacao embarcacao) {
		
		embarcacao.setCoordenadas(
			gerarCoordenadasAleatorias(embarcacao.getTamanho(), embarcacao.getDirecao())
		);
		
		verificarEmbarcacao(embarcacao);
		
		System.out.print("\nNOVA EMBARCAÇÃO "
				+ " | Tipo: "+embarcacao.getTipoDeEmbarcacao()
				+ "\t | partes: ");
		String partes = "";
		int i = 1;
		for (Coordenada c : embarcacao.getCoordenadas()) {
			partes += +i+"-X("+c.getX()+")-Y("+c.getY()+")  ";
			i++;
		}		
		System.out.print(partes);
		
		for (Coordenada c : embarcacao.getCoordenadas()) {
			matrizDePosicoes.get(new Posicao(c.getX(), c.getY())).setPreenchida(true);
		}
	}
	
	private List<Coordenada> gerarCoordenadasAleatorias(int tamanho, Direcao direcao) {
		List<Coordenada> coordenadas = new ArrayList<Coordenada>();
		
		int x = Utils.gerarPosicaoEntreUmE(this.tamanho);
		int y = Utils.gerarPosicaoEntreUmE(this.tamanho);
		
		Coordenada c = new Coordenada(x, y);
		coordenadas.add(c);
		
		if (tamanho > 1) {
			
			switch (direcao) {
		        
	            case CIMA:
	            	for (int i = 1; i < tamanho; i++) {
	            		Coordenada aux = new Coordenada(
	            				c.getX(), 
	            				c.getY()+i);
	            		coordenadas.add(aux);
	        		}
	                break;
	                
	            case DIREITA:
	            	for (int i = 1; i < tamanho; i++) {
	            		Coordenada aux = new Coordenada(
	            				c.getX()+i, 
	            				c.getY());
	            		coordenadas.add(aux);
	        		}
	                break;
	                
	            case BAIXO:
	            	for (int i = 1; i < tamanho; i++) {
	            		Coordenada aux = new Coordenada(
	            				c.getX(), 
	            				c.getY()-i);
	            		coordenadas.add(aux);
	        		}
	                break;
	                
	            case ESQUERDA:
	            	for (int i = 1; i < tamanho; i++) {
	            		Coordenada aux = new Coordenada(
	            				c.getX()-i, 
	            				c.getY());
	            		coordenadas.add(aux);
	        		};
	        }
		}
		
		return coordenadas;
	}
	
	private void verificarEmbarcacao(Embarcacao embarcacao) {
		int casasIrregulares = 0;
		boolean embarcacaoEstaIrregular = true;
		
		do { 
			for (Coordenada coordenada : embarcacao.getCoordenadas()) {
				if (estaPreenchidaNoTabuleiro(coordenada)) {
					casasIrregulares++;
				}
			}
			
			if (casasIrregulares == 0) {
				embarcacaoEstaIrregular = false;
			} else {
				
				mover(embarcacao, casasIrregulares);
				embarcacaoEstaIrregular = embarcacaoEstaIrregularNoTabuleiro(embarcacao);
			}
			
		} while (embarcacaoEstaIrregular);
	}
	
	private Embarcacao mover(Embarcacao embarcacao, int numCasas) {
		Direcao direcaoASerMovida = Direcao.ESQUERDA;
		
		switch (embarcacao.getDirecao()) {
			case CIMA:
				direcaoASerMovida = Direcao.BAIXO;
	            break;
	            
	        case DIREITA:
	        	direcaoASerMovida = Direcao.ESQUERDA;
	            break;
	            
	        case BAIXO:
	        	direcaoASerMovida = Direcao.CIMA;
	            break;
	            
	        case ESQUERDA:
	        	direcaoASerMovida = Direcao.DIREITA;
		}
		
		embarcacao.setCoordenadas(mover(embarcacao.getCoordenadas(), direcaoASerMovida, numCasas));
		
		return embarcacao;
		
	}
	
	private List<Coordenada> mover(List<Coordenada> coordenadas, Direcao direcao, int numCasas) {

	        switch (direcao) {
	        
	            case CIMA:
	            	for (Coordenada c : coordenadas) {
	        			c.setY(c.getY()+numCasas);
	        		}
	                break;
	                
	            case DIREITA:
	            	for (Coordenada c : coordenadas) {
	        			c.setX(c.getX()+numCasas);
	        		}
	                break;
	                
	            case BAIXO:
	            	for (Coordenada c : coordenadas) {
	        			c.setY(c.getY()-numCasas);
	        		}
	                break;
	                
	            case ESQUERDA:
	            	for (Coordenada c : coordenadas) {
	        			c.setX(c.getX()-numCasas);
	        		};
	        }
	        
	        return coordenadas;
	}
	
	private boolean estaPreenchidaNoTabuleiro(Coordenada coordenadaDaEmbarcacao) {

		if (coordenadaDaEmbarcacao.getX() > this.tamanho || coordenadaDaEmbarcacao.getY() > this.tamanho ||
				coordenadaDaEmbarcacao.getX() < 1 || coordenadaDaEmbarcacao.getY() < 1) {
			System.err.println("ERRO FORA DO TABULEIRO ("+coordenadaDaEmbarcacao.getX()+","+coordenadaDaEmbarcacao.getY()+")");
			return true;
		} else {
			Coordenada coordenadaDoTabuleiro = matrizDePosicoes.get(new Posicao(coordenadaDaEmbarcacao.getX(), coordenadaDaEmbarcacao.getY()));
			return coordenadaDoTabuleiro.isPreenchida();
		}		
	}
	
	private boolean embarcacaoEstaIrregularNoTabuleiro(Embarcacao embarcacao) {
		
		for (Coordenada c : embarcacao.getCoordenadas()) {
			if(estaPreenchidaNoTabuleiro(c)) {
				return true;
			}
		}
		
		return false;
	}
	
	// Getters e Setters
	public Map<Posicao, Coordenada> getMatrizDePosicoes() {
		return matrizDePosicoes;
	}

	public void setMatrizDePosicoes(Map<Posicao, Coordenada> matrizDePosicoes) {
		this.matrizDePosicoes = matrizDePosicoes;
	}
	public List<Embarcacao> getEmbarcacoes() {
		return embarcacoes;
	}

	public void setEmbarcacoes(List<Embarcacao> embarcacoes) {
		this.embarcacoes = embarcacoes;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
}
