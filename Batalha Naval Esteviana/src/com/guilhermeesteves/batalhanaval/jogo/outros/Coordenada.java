package com.guilhermeesteves.batalhanaval.jogo.outros;

/**
 * Classe que guarda a posição do tabuleiro
 * e suas respectivas informações.
 * 
 * @author Guilherme Esteves
 *
 */
public class Coordenada {
	
	private int x;
	private int y;
	
	private boolean atingida;
	private boolean preenchida;
	
	public Coordenada(int x, int y) {
		this.y = y;
		this.x = x;
		this.atingida = false;
		this.preenchida = false;
	}
	public Coordenada() {
		this.atingida = false;
		this.preenchida = false;
	}	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isAtingida() {
		return atingida;
	}
	public void setAtingida(boolean atingida) {
		this.atingida = atingida;
	}
	public boolean isPreenchida() {
		return preenchida;
	}
	public void setPreenchida(boolean preenchida) {
		this.preenchida = preenchida;
	}
	
	 @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordenada)) return false;
        Coordenada coordenada = (Coordenada) o;
        return x == coordenada.x && y == coordenada.y;
    }

    @Override
    public int hashCode() {
        int resultado = x;
        resultado = 31 * resultado + y;
        return resultado;
    }
}
