package main;

import javax.swing.*;

import java.awt.Point;
import java.awt.event.*;

class EcouteurDeSouris implements MouseListener, MouseMotionListener {
	
	AireDeDessin aire;
	Moteur moteur;
	
	public EcouteurDeSouris(AireDeDessin aire,Moteur moteur){
		this.aire = aire;
		this.moteur = moteur;
	}
	
    public void mousePressed(MouseEvent e) {
    	Point p = new Point(aire.Case(e.getX(), e.getY()));
    	moteur.jouer_coup(p);
    	moteur.T.afficher();
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
