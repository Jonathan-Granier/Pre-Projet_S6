package main;

import javax.swing.*;

import java.awt.Point;
import java.awt.event.*;

class EcouteurDeSouris implements MouseListener, MouseMotionListener {
	
	AireDeDessin aire;
	Moteur moteur;
	Joueur joueur1;
	Joueur joueur2;
	JLabel J1;
	JLabel J2;
	
	public EcouteurDeSouris(AireDeDessin aire,Moteur moteur, Joueur joueur1,Joueur joueur2,JLabel J1,JLabel J2){
		this.aire = aire;
		this.moteur = moteur;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.J1 = J1;
		this.J2 = J2;
	}
	
    public void mousePressed(MouseEvent e) {
    	Point p = new Point(aire.Case(e.getX(), e.getY()));
    	moteur.jouer_coup(p);
    	moteur.T.afficher();
    	if(moteur.joueur == 1 && moteur.partie_terminee()){
    		joueur1.setScore(joueur1.getScore()+1);
    		J1.setText(Integer.toString(joueur1.getScore()));
    		moteur.nouvelle_partie();
    	}else if(moteur.joueur == 2 && moteur.partie_terminee()){
    		joueur2.setScore(joueur2.getScore()+1);
    		J2.setText(Integer.toString(joueur2.getScore()));
    		moteur.nouvelle_partie();
    	}
    	System.out.println(p);
    	aire.repaint();
    }

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
