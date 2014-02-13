package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import test.telas.TestesDePainel;

import com.guilhermeesteves.batalhanaval.util.Utils;

public class Teste {

	public static void main(String[] args) {
		TestarAnimacaoPainel();
	}
	
	public static void numerosAleatorios() {
		
		for (int i = 1; i <= 200; i++) {
			int aleatorio = Utils.gerarPosicaoEntreUmE(20);
			if (aleatorio < 1 || aleatorio > 20) {
				System.err.print(i+"-("+aleatorio+")    \t");
			} else {
				System.out.print(i+"-("+aleatorio+")    \t");
			}
			
			if (i % 10 == 0) {
				System.out.print("\n");
			}
		}
		
	}
	
	 public static void TestarAnimacaoPainel() {
	        EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                try {
	                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	                } catch (ClassNotFoundException 
	                		| InstantiationException 
	                		| IllegalAccessException 
	                		| UnsupportedLookAndFeelException ex) {
	                }

	                JFrame frame = new JFrame("Teste");
	                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                frame.setLayout(new BorderLayout());
	                frame.pack();
	                frame.setLocationRelativeTo(null);
	                frame.setVisible(true);
	            }
	        });
	    }
}
