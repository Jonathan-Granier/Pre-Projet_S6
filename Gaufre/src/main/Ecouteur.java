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
	
	public Ecouteur(String label, Moteur moteur,AireDeDessin aire,JLabel J1,JLabel J2){
		this.label=label;
		this.aire = aire;
		this.moteur = moteur;
		this.J1 = J1;
		this.J2 = J2;
	}
	
    public void actionPerformed(ActionEvent e) {
    	if(label.equals("Annuler")){
    		moteur.annuler();
    		aire.repaint();
    	}
    	else if(label.equals("Refaire")){
    		moteur.refaire();
    		aire.repaint();
    	}
    	else if(label.equals("Nouveaux")){
    		J1.setText(Integer.toString(moteur.j1.getScore()));
    		J2.setText(Integer.toString(moteur.j2.getScore()));
    		moteur.nouvelle_partie();
    		aire.repaint();
    	}
    }

	
}
