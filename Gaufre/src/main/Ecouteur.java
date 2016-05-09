package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ecouteur implements ActionListener {
	
	String label;
	Moteur moteur;
	AireDeDessin aire;
	
	public Ecouteur(String label, Moteur moteur,AireDeDessin aire){
		this.label=label;
		this.aire = aire;
		this.moteur = moteur;
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
    		moteur.nouvelle_partie();
    		aire.repaint();
    	}
    }

	
}
