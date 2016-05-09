package main;

import java.awt.Point;
import java.util.ArrayList;

public class Moteur {
	Terrain T;
	
	
	public Moteur(Terrain T){
		this.T=T;
	}
	
	ArrayList<Point> coups_possibles(){
		ArrayList<Point> res=new ArrayList<Point>();
		for(int i=0;i<T.l;i++){
			for(int j=0;j<T.h;j++){
				if(T.t[i][j]) res.add(new Point(i,j));
			}
		}
		return res;
	}
}
