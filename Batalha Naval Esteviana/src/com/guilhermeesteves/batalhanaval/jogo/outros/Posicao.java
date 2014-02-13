package com.guilhermeesteves.batalhanaval.jogo.outros;

/**
 * Serve apenas para facilitar as buscas
 * dentro das posições do tabuleiro.
 * 
 * @author Guilherme Esteves
 *
 */
public class Posicao {

    private final int x;
    private final int y;

    public Posicao(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Posicao)) return false;
        Posicao posicao = (Posicao) o;
        return x == posicao.x && y == posicao.y;
    }

    @Override
    public int hashCode() {
        int resultado = x;
        resultado = 31 * resultado + y;
        return resultado;
    }
}
