package main;
import java.awt.*;
import javax.swing.*;

class AireDeDessin extends JComponent {

	Terrain t;
	
	public AireDeDessin(Terrain t){
		this.t=t;
	}
	
	public Point Case(int x, int y){
		int ratioX =getSize().width/t.l;
		int ratioY = getSize().height/t.h;
		return new Point(x/ratioX,y/ratioY);
	}
	
    public void paintComponent(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;
        
        int width = getSize().width;
        int height = getSize().height;
        
        drawable.setPaint(Color.white);
        drawable.fillRect(0, 0, width, height);
        drawable.setPaint(Color.black);
        
        for(int i=0;i<t.l;i++)
        	 for(int j=0;j<t.h;j++){
        		 Point center= new Point((width/t.l)/2,(height/t.h)/2);
        		 drawable.drawRect(i*width/t.l, j*height/t.h, width/t.l, height/t.h);
        		 
        	 }
        
    }
	
}
