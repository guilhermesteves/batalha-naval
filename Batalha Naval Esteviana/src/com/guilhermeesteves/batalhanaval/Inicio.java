package com.guilhermeesteves.batalhanaval;

import org.apache.log4j.Logger;

import com.guilhermeesteves.batalhanaval.util.CONSTANTES;
import com.guilhermeesteves.batalhanaval.util.Mensagem;



/**
 * Classe principal que apenas inicia o jogo,
 * as telas entre outras coisas.
 * 
 * @author Guilherme Esteves
 *
 */
public class Inicio {
	
	private static Logger logger = Logger.getLogger(Inicio.class);
	
	public static void main(String[] args) {
		logger.info(CONSTANTES.LOG.INICIANDO+"Batalha Naval Esteviana");
		
		int dificuldade = Mensagem.qualADificuldade();
		
		BatalhaNaval batalhaNaval = new BatalhaNaval();
		batalhaNaval.setDificuldade(dificuldade);
		
		logger.info("Dificuldade: "+batalhaNaval.getDificuldade().toString());
		logger.info("Preparando jogo... "+batalhaNaval.getDificuldade().toString());
		
		batalhaNaval.preparaJogo();
		
		batalhaNaval = null;
		
		end();
	}
	
	public static void end() {
		
		logger.info("Fim de jogo.");
		System.exit(0);
	}
}
