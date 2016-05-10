package main;

import javax.swing.*;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.*;

class EcouteurDeSouris implements MouseListener, MouseMotionListener {
	
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
		this.ia1 = new IA(moteur,moteur.j1.getIaLevel());
		this.ia2 = new IA(moteur,moteur.j2.getIaLevel());
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
	
	public void isOver(){
    	if(moteur.joueur == 1 && moteur.partie_terminee()){
	    	moteur.j1.setScore(moteur.j1.getScore()+1);
	    	J1.setText(Integer.toString(moteur.j1.getScore()));
	    	//Replay();
	    	moteur.nouvelle_partie();
    	}else if(moteur.joueur == 2 && moteur.partie_terminee()){
    		moteur.j2.setScore(moteur.j2.getScore()+1);
    		J2.setText(Integer.toString(moteur.j2.getScore()));
    		//Replay();
    		moteur.nouvelle_partie();
    	}
	}
	
    public void mousePressed(MouseEvent e) {
    	Point p = new Point(aire.Case(e.getX(), e.getY()));
    	//Check if ia
    	if((moteur.joueur == 1 && !moteur.j1.isIa())){
    		moteur.jouer_coup(p);
    		aire.repaint();
    		isOver();
    		if(moteur.j2.isIa()){
	    		iaTurn(2);
	    		try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
	    		aire.repaint();
	    		isOver();
    		}
    	}
    	if((moteur.joueur == 2 && !moteur.j2.isIa())){
    		moteur.jouer_coup(p);
    		aire.repaint();
    		isOver();
    		if(moteur.j1.isIa()){
	    		iaTurn(1);
	    		try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
	    		aire.repaint();
	    		isOver();
    		}
    	}
    	
    	turn.setText(moteur.message);
  
    	
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
