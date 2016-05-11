package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.*;

public class Animation extends Observable implements ActionListener {

    int progress, current;
    final int slowness = 10;
    Timer timer;
	AireDeDessin aire;
    
    public Animation(AireDeDessin aire){
        progress = 0;
        current = 0;
        timer = new Timer(100, this);
        timer.start();
        current = 1;
        this.aire = aire;
    }
    
	@Override
	public void actionPerformed(ActionEvent arg0) {
	        timer.stop();
		    setChanged();
		    notifyObservers();
	}

}
