package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Test_gaufre {

	public static JMenu menuPrincipal(Moteur moteur,AireDeDessin aire) {
		JMenu principal;
        	JMenuItem item;
		principal = new JMenu("Option");
		item = new JMenuItem("Nouveaux");
		item.addActionListener(new Ecouteur("Nouveaux",moteur,aire));
		principal.add(item);
		item = new JMenuItem("Sauver");
		item.addActionListener(new Ecouteur("Sauver",moteur,aire));
		principal.add(item);
		item = new JMenuItem("Charger");
		item.addActionListener(new Ecouteur("Charger",moteur,aire));
		principal.add(item);
		item = new JMenuItem("Annuler");
		item.addActionListener(new Ecouteur("Annuler",moteur,aire));
		principal.add(item);
		item = new JMenuItem("Refaire");
		item.addActionListener(new Ecouteur("Refaire",moteur,aire));
		principal.add(item);
		return principal;
	}

	public static JMenuBar menu(Moteur moteur,AireDeDessin aire) {
		JMenuBar barre;
		JMenu principal, edition;

        barre = new JMenuBar();
		principal = menuPrincipal(moteur,aire);
        barre.add(principal);

		return barre;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame("Gauffre");
		
		Terrain terrain = new Terrain(4,6);
		Moteur moteur = new Moteur(terrain);
		//Aire de dessin
		AireDeDessin aire = new AireDeDessin(terrain);
		aire.addMouseListener(new EcouteurDeSouris(aire,moteur));
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6,1,2,0));
		JLabel J1 = new JLabel("Joueur 1");
		J1.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel J1_score = new JLabel("0"); // To be implemented
		J1_score.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel J2 = new JLabel("Joueur 2");
		J2.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel J2_score = new JLabel("0"); // To be implemented
		J2_score.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton undo = new JButton("Annuler");
		undo.addActionListener(new Ecouteur("Annuler",moteur,aire));

		JButton redo = new JButton("Refaire");
		redo.addActionListener(new Ecouteur("Refaire",moteur,aire));
		
		panel.add(J1);
		panel.add(J1_score);
		panel.add(J2);
		panel.add(J2_score);
		panel.add(undo);
		panel.add(redo);
		frame.add(aire);
		frame.add(panel,BorderLayout.EAST);
		frame.setJMenuBar(menu(moteur,aire));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
		
		
	}

}
