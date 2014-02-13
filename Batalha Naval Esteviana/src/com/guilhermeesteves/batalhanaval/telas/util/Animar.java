package com.guilhermeesteves.batalhanaval.telas.util;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.guilhermeesteves.batalhanaval.util.CONSTANTES;

public class Animar {
	
	int tempoDeExecucao;

	private JPanel painel;
    private Rectangle de;
    private Rectangle para;

    private long tempoInicial;

    public Animar(JPanel painel, Rectangle de, Rectangle para) {
        
    	this.painel = painel;
        this.de = de;
        this.para = para;
    }
    
    /*public void iniciar() {
    	iniciar(CONSTANTES.TELA.TEMPO_DE_EXECUCAO);
    }*/
    
    public void iniciar() {
    	Timer tempo = new Timer(40, new ActionListener() {
            
    		int tempo = (tempoDeExecucao == 0) ? CONSTANTES.TELA.TEMPO_DE_EXECUCAO : tempoDeExecucao;
    		
    		@Override
            public void actionPerformed(ActionEvent evento) {
                long duracao = System.currentTimeMillis() - tempoInicial;
                double progresso = (double)duracao / (double)tempo;
                
                if (progresso > 1f) {
                    progresso = 1f;
                    ((Timer)evento.getSource()).stop();
                }
                
                Rectangle target = calcularProgresso(de, para, progresso);
                painel.setBounds(target);
            }
        });
        tempo.setRepeats(true);
        tempo.setCoalesce(true);
        tempo.setInitialDelay(0);
        tempoInicial = System.currentTimeMillis();
        tempo.start();
    }
    
    public static Rectangle calcularProgresso(Rectangle inicioDosLimites, Rectangle fimDosLimites, double progresso) {

        Rectangle limites = new Rectangle();

        if (inicioDosLimites != null && fimDosLimites != null) {

            limites.setLocation(calcularProgresso(inicioDosLimites.getLocation(), fimDosLimites.getLocation(), progresso));
            limites.setSize(calcularProgresso(inicioDosLimites.getSize(), fimDosLimites.getSize(), progresso));

        }

        return limites;

    }
    
    public static Point calcularProgresso(Point pontoInicial, Point pontoFinal, double progresso) {

        Point point = new Point();

        if (pontoInicial != null && pontoFinal != null) {

            point.x = calcularProgresso(pontoInicial.x, pontoFinal.x, progresso);
            point.y = calcularProgresso(pontoInicial.y, pontoFinal.y, progresso);

        }

        return point;

    }
    
    public static int calcularProgresso(int valorInicial, int valorFinal, double fracao) {

        int value = 0;
        int distance = valorFinal - valorInicial;
        value = (int)Math.round((double)distance * fracao);
        value += valorInicial;

        return value;

    }

    public static Dimension calcularProgresso(Dimension tamanhoInicial, Dimension tamanhoFinal, double progresso) {

        Dimension size = new Dimension();

        if (tamanhoInicial != null && tamanhoFinal != null) {

            size.width = calcularProgresso(tamanhoInicial.width, tamanhoFinal.width, progresso);
            size.height = calcularProgresso(tamanhoInicial.height, tamanhoFinal.height, progresso);

        }

        return size;

    }
    
    public int getTempoDeExecucao() {
		return tempoDeExecucao;
	}

	public void setTempoDeExecucao(int tempoDeExecucao) {
		this.tempoDeExecucao = tempoDeExecucao;
	}
}
