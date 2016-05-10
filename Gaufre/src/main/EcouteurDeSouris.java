package main;

import javax.swing.*;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.*;

class EcouteurDeSouris implements MouseListener, MouseMotionListener {
	
	AireDeDessin aire;
	Moteur moteur;
	Joueur joueur1;
	Joueur joueur2;
	JLabel J1;
	JLabel J2;
	JLabel turn;
	JFrame frame;
	boolean isPlaying;
	
	public EcouteurDeSouris(AireDeDessin aire,Moteur moteur, Joueur joueur1,Joueur joueur2,JLabel J1,JLabel J2,JLabel turn,JFrame frame){
		this.aire = aire;
		this.moteur = moteur;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.J1 = J1;
		this.J2 = J2;
		this.turn = turn;
		this.frame = frame;
		this.isPlaying = true;
		turn.setText(moteur.message);
	}
	
	public void Replay(){
		JPanel panel = new JPanel();
		JButton rejouer = new JButton("Replay");
		panel.add(rejouer);
		frame.add(panel);
		isPlaying = false;
	}
	
    public void mousePressed(MouseEvent e) {
    	Point p = new Point(aire.Case(e.getX(), e.getY()));
    	moteur.jouer_coup(p);
    	turn.setText(moteur.message);
    	if(isPlaying){
	    	if(moteur.joueur == 1 && moteur.partie_terminee()){
		    	joueur1.setScore(joueur1.getScore()+1);
		    	J1.setText(Integer.toString(joueur1.getScore()));
		    	Replay();
		    	return;
		    		//moteur.nouvelle_partie();
	    	}else if(moteur.joueur == 2 && moteur.partie_terminee()){
	    		joueur2.setScore(joueur2.getScore()+1);
	    		J2.setText(Integer.toString(joueur2.getScore()));
	    		Replay();
	    		return;
		    		//moteur.nouvelle_partie();
	    	}
    	}
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
