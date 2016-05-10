package main;
import java.awt.*;
import javax.swing.*;

class AireDeDessin extends JComponent {

	Moteur moteur;
	
	public AireDeDessin(Moteur moteur){
		this.moteur=moteur;
	}
	
	public Point Case(int x, int y){
		int ratioX =getSize().width/moteur.T.l;
		int ratioY = getSize().height/moteur.T.h;
		return new Point(x/ratioX,y/ratioY);
	}
	
    public void paintComponent(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;
        
        int width = getSize().width;
        int height = getSize().height;
        
        drawable.setPaint(Color.white);
        drawable.fillRect(0, 0, width, height);
        drawable.setPaint(Color.black);
        
        

        for(int i=0;i<moteur.T.l;i++)
        	 for(int j=0;j<moteur.T.h;j++){
        		 if(moteur.T.t[i][j]){
        			 drawable.setPaint(Color.yellow);
        			 drawable.fillRect(i*width/moteur.T.l, j*height/moteur.T.h, width/moteur.T.l, height/moteur.T.h);
        			 drawable.setPaint(Color.black);
        			 drawable.drawRect(i*width/moteur.T.l, j*height/moteur.T.h, width/moteur.T.l, height/moteur.T.h);
        			 
        		 }
        	 }
        
        drawable.setPaint(Color.red);
        int size = Math.min((width/moteur.T.l), (height/moteur.T.h));
        Point center= new Point(((width/moteur.T.l) - size)/2,((height/moteur.T.h) - size)/2);
        drawable.fillOval(center.x,center.y, size,size);
        drawable.setPaint(Color.black);
        
    }
	
}
