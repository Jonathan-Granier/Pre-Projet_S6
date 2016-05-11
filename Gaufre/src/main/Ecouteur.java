package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class Ecouteur implements ActionListener {
	
	String label;
	Moteur moteur;
	AireDeDessin aire;
	JLabel J1;
	JLabel J2;
	JLabel turn;
	
	public Ecouteur(String label, Moteur moteur,AireDeDessin aire,JLabel J1,JLabel J2,JLabel turn){
		this.label=label;
		this.aire = aire;
		this.moteur = moteur;
		this.J1 = J1;
		this.J2 = J2;
		this.turn = turn;
	}
	
    public void actionPerformed(ActionEvent e) {
    	if(label.equals("Annuler")){
    		moteur.annuler();
    		turn.setText(moteur.message);
    		aire.repaint();
    	}
    	else if(label.equals("Refaire")){
    		moteur.refaire();
    		turn.setText(moteur.message);
    		aire.repaint();
    	}
    	else if(label.equals("Nouveaux")){
    		moteur.nouvelle_partie();
    		moteur.initScore();
    		J1.setText(Integer.toString(moteur.j[1].getScore()));
    		J2.setText(Integer.toString(moteur.j[2].getScore()));
    		aire.repaint();
    	}
    }

	
}
