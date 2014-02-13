package com.guilhermeesteves.batalhanaval.util;

/**
 * Classe para armazenar e centralizar
 * todas as contantes presentes no jogo.
 * 
 * @author Guilherme Esteves
 *
 */
public class CONSTANTES {
	
	public static final String NOME = "Batalha Naval Esteviana";
	public static final String VERSAO = "1";
	public static final String AUTOR = " | Guilherme Esteves (@guilhermesteves)";
	
	public static class TELA {
		public static final int LARGURA = 800;
		public static final int ALTURA = 680;
		public static final int TEMPO_DE_EXECUCAO = 2000;
		
		public static final int BOTAO_LARGURA = 300;
		public static final int BOTAO_ALTURA = 80;
		public static final int BOTAO_X = 250;
	}
	
	public static class DIFICULDADE {
		public static final String FACIL = "Fácil";
		public static final String NORMAL = "Normal";
		public static final String DIFICIL = "Difícil";
		
		public static Object[] getTodasAsOpcoes() {
			Object[] opcoes = {FACIL, NORMAL, DIFICIL };
		
			return opcoes;
		}
	}
	
	public static class EMBARCACOES {
		
		public static class TAMANHO {
			public static final int SUBMARINO = 1;
			public static final int CORVETA = 2;
			public static final int FRAGATA = 3;
			public static final int ENCOURACADO = 4;
			public static final int PORTA_AVIAO = 5;
		}
		
		public static class TIPOS {
			public static final String SUBMARINO = "submarino";
			public static final String CORVETA = "corveta";
			public static final String FRAGATA = "fragata";
			public static final String ENCOURACADO = "encouraçado";
			public static final String PORTA_AVIAO = "porta avião";
			
			public static String getPlural(String palavra) {
				return palavra.concat("s");
			}
		}
	}
	
	public static class MENSAGENS {
		public static class PERGUNTAS {
			public static final String DIFICULDADE = "Em qual dificuldade deseja jogar?";
		}
		
		public static class FIM_DE_JOGO {
			
		}
	}
	//
	
	public static class IMAGENS {
		
		private static final String PASTA_PADRAO_TESTE = "imagens/teste/";
		private static final String PASTA_PADRAO= "imagens/";
		private static final String JPG = ".jpg";
		
		public static final String FUNDO_MENU_INICIAL = PASTA_PADRAO+"fundo_menu_inicial"+JPG;
		public static final String LOGO_MENU_INICIAL = PASTA_PADRAO_TESTE+"logo_menu"+JPG;
		
		public static final String LOGO_INTRO_TESTE = PASTA_PADRAO_TESTE+"logo_intro"+JPG;
		
		public static class BOTOES {
			public static final String NOVO_JOGO = PASTA_PADRAO_TESTE+"n"+JPG;
			public static final String NOVO_JOGO_MOUSEOVER = PASTA_PADRAO_TESTE+"n_hm"+JPG;
			public static final String RECORDES = PASTA_PADRAO_TESTE+"r"+JPG;
			public static final String RECORDES_MOUSEOVER = PASTA_PADRAO_TESTE+"r_hm"+JPG;
			public static final String CREDITOS = PASTA_PADRAO_TESTE+"c"+JPG;
			public static final String CREDITOS_MOUSEOVER = PASTA_PADRAO_TESTE+"c_hm"+JPG;
			public static final String SAIR = PASTA_PADRAO_TESTE+"s"+JPG;
			public static final String SAIR_MOUSEOVER = PASTA_PADRAO_TESTE+"s_hm"+JPG;
		}
	}
	
	public static class LOG {
		public static final String INICIANDO = "Iniciando ";
	}
}
