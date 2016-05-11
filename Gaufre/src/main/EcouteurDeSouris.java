package main;

import javax.swing.*;

import java.awt.Point;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

class EcouteurDeSouris implements MouseListener, MouseMotionListener, Observer {
	
	AireDeDessin aire;
	Moteur moteur;
	JLabel J1;
	JLabel J2;
	JLabel turn;
	JFrame frame;
	boolean isPlaying;
	IA ia1;
	IA ia2;
	
	public EcouteurDeSouris(AireDeDessin aire,Moteur moteur,JLabel J1,JLabel J2,JLabel turn,JFrame frame){
		this.aire = aire;
		this.moteur = moteur;
		this.turn = turn;
		this.frame = frame;
		this.isPlaying = true;
		this.J1 = J1;
		this.J2 = J2;
		this.ia1 = new IA(moteur,moteur.j[1].getIaLevel());
		this.ia2 = new IA(moteur,moteur.j[2].getIaLevel());
		turn.setText(moteur.message);
	}
	
	public void Replay(){
		JPanel panel = new JPanel();
		JButton rejouer = new JButton("Replay");
		panel.add(rejouer);
		frame.add(panel);
		isPlaying = false;
	}
	
	public void iaTurn(int id){
		if (id==1)
			moteur.jouer_coup(ia1.jouer_coup());
		else if(id==2)
			moteur.jouer_coup(ia2.jouer_coup());
	}
	
	public boolean isOver(){
    	if(moteur.joueur == 1 && moteur.partie_terminee()){
	    	J1.setText(Integer.toString(moteur.j[1].getScore()));
	    	//Replay();
	    	moteur.nouvelle_partie();
	    	return true;
    	}else if(moteur.joueur == 2 && moteur.partie_terminee()){
    		J2.setText(Integer.toString(moteur.j[2].getScore()));
    		//Replay();
    		moteur.nouvelle_partie();
    		return true;
    	}
    	return false;
	}
	
	public void callAnim(){
		Animation anim;
        anim = new Animation(aire);
        anim.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		aire.repaint();
	}
	
    public void mousePressed(MouseEvent e) {
    	Point p = new Point(aire.Case(e.getX(), e.getY()));
    	int retour;
    	//Check if ia
    	if(!p.equals(new Point(-1,-1)) || (moteur.j[1].isIa() && moteur.j[2].isIa())){
	    	//if((moteur.joueur == 1 && !moteur.j[1].isIa())){
    		if(!moteur.j[moteur.getJ()].isIa()){
	    		retour = moteur.jouer_coup(p);
	    		callAnim();
	    		if(retour > 0){
	    			J1.setText(Integer.toString(moteur.j[1].getScore()));
	        		J2.setText(Integer.toString(moteur.j[2].getScore()));
	    	    	//Replay();
	    	    	moteur.nouvelle_partie();
	    			return;
	    		}
	    		if(moteur.j[moteur.getJ()].isIa()){
		    		iaTurn(moteur.getJ());
		    		callAnim();
		    		if(isOver())
		    			return;
	    		}
	    	}
	    	else if(moteur.joueur == 1 && moteur.j[1].isIa()){
	    		iaTurn(1);
	    		callAnim();
	    		if(isOver())
	    			return;
	    	}
	    	else if((moteur.joueur == 2 && !moteur.j[2].isIa())){
	    		moteur.jouer_coup(p);
	    		callAnim();
	    		if(isOver())
	    			return;
	    		if(moteur.j[1].isIa()){
		    		iaTurn(1);
		    		callAnim();
		    		if(isOver())
		    			return;
	    		}
	    	}
	    	else if(moteur.joueur == 2 && moteur.j[2].isIa()){
	    		iaTurn(2);
	    		callAnim();
	    		if(isOver())
	    			return;
	    	}
	    	
	    	turn.setText(moteur.message);
    	}
    	
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
