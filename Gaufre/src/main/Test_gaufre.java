package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Test_gaufre {

	final static int WIDTH = 500;
	final static int HEIGHT = 500;
	static JFrame frame;
	static Joueur joueur1;
	static Joueur joueur2;
	static JLabel J1_score;
	static JLabel J2_score;

	
	public static JMenu menuPrincipal(Moteur moteur,AireDeDessin aire) {
		JMenu principal;
        	JMenuItem item;
		principal = new JMenu("Option");
		item = new JMenuItem("Nouveaux");
		item.addActionListener(new Ecouteur("Nouveaux",moteur,aire,J1_score,J2_score));
		principal.add(item);
		item = new JMenuItem("Sauver");
		item.addActionListener(new Ecouteur("Sauver",moteur,aire,J1_score,J2_score));
		principal.add(item);
		item = new JMenuItem("Charger");
		item.addActionListener(new Ecouteur("Charger",moteur,aire,J1_score,J2_score));
		principal.add(item);
		return principal;
	}

	public static JMenuBar menu(Moteur moteur,AireDeDessin aire) {
		JMenuBar barre;
		JMenu principal;

        barre = new JMenuBar();
		principal = menuPrincipal(moteur,aire);
        barre.add(principal);

		return barre;
	}
	
	public static void titleScreen(){
		JPanel panel = new JPanel();
		JLabel joueur1_label = new JLabel ("Joueur1");
		joueur1_label.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel joueur2_label = new JLabel ("Joueur2");
		joueur2_label.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(joueur1_label,BorderLayout.WEST);
		frame.add(joueur2_label,BorderLayout.EAST);
		
		
		
		joueur1 = new Joueur(false,1);
		joueur2 = new Joueur(true,1);
		
		JButton play = new JButton("PLAY");
		frame.add(play, BorderLayout.CENTER);
		play.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {game();}});
	}
	
	public static void game(){
		frame.setVisible(false);
		frame = new JFrame("Gauffre");
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		Terrain terrain = new Terrain(4,6);
		Moteur moteur = new Moteur(terrain,joueur1,joueur2);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6,1,2,0));
		JLabel turn = new JLabel("");
		turn.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel align = new JLabel("");
		align.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel J1 = new JLabel("Joueur 1");
		J1.setHorizontalAlignment(SwingConstants.CENTER);
		J1_score = new JLabel(Integer.toString(joueur1.getScore())); // To be implemented
		J1_score.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel J2 = new JLabel("Joueur 2");
		J2.setHorizontalAlignment(SwingConstants.CENTER);
		J2_score = new JLabel(Integer.toString(joueur2.getScore())); // To be implemented
		J2_score.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		//Aire de dessin
		
		AireDeDessin aire = new AireDeDessin(moteur);
		aire.addMouseListener(new EcouteurDeSouris(aire,moteur,J1_score,J2_score,turn,frame));
		

		
		JButton undo = new JButton("Annuler");
		undo.addActionListener(new Ecouteur("Annuler",moteur,aire,J1_score,J2_score));

		JButton redo = new JButton("Refaire");
		redo.addActionListener(new Ecouteur("Refaire",moteur,aire,J1_score,J2_score));
		
		panel.add(align);
		panel.add(turn);
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
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		frame = new JFrame("Gauffre");
		
		titleScreen();
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		
		
	}

}
