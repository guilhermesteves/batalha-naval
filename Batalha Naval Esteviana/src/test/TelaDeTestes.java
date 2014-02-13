package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

import test.telas.Intro;

import com.guilhermeesteves.batalhanaval.telas.TelaInicial;

public class TelaDeTestes {
	
	private JFrame frame;
	final Intro intro = new Intro();
	final TelaInicial inicial = new TelaInicial();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeTestes window = new TelaDeTestes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaDeTestes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();  
		frame.setBounds(100, 100, 800, 680);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.BLACK);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-800/2, dim.height/2-680/2);
		
		frame.getContentPane().add(inicial);
		//inicial.animate();
	}
}
