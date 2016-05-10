package main;

import java.awt.Point;
import java.util.ArrayList;

public class Terrain {
	boolean [][] t;
	int l,h;
	
	public Terrain(int l, int h){
		
		if(l<2) this.l=2;
		else this.l=l;
		if(h<2) this.h=2;
		else this.h=h;
		
		t=new boolean[l][h];
		for(int i=0;i<l;i++){
			for(int j=0;j<h;j++){
				t[i][j]=true;
			}
		}
	}
	
	// Renvoie un clone du Terrain avec une référence différente
	public Terrain clone(){
		Terrain res = new Terrain(l,h);
		res.t=new boolean[l][h];
		for(int i=0;i<l;i++){
			for(int j=0;j<h;j++){
				res.t[i][j]=t[i][j];
			}
		}
		return res;
	}
	
	// Affiche le Terrain dans la console
	public void afficher(){
		for(int i=0;i<h;i++){
			for(int j=0;j<l;j++){
				if(t[j][i]) System.out.print("1");
				else System.out.print("0");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// Renvoie vrai <=> le coup donné est autorise
	public boolean est_autorise(Point coup){
		if(coup.x<0 || coup.x>=l || coup.y<0 || coup.y>=h) return false;
		else return t[coup.x][coup.y];
	}
	
	// Renvoie une ArrayList des coups autorises (0,0) compris
	public ArrayList<Point> coups_possibles(){
		ArrayList<Point> res=new ArrayList<Point>();
		for(int i=0;i<l;i++){
			for(int j=0;j<h;j++){
				if(t[i][j]) res.add(new Point(i,j));
			}
		}
		return res;
	}
	
	// Renvoie le terrain après le coup donné. Ne modifie pas l'état actuel.
	public Terrain consulter_coup(Point coup){
		Terrain tmp = this.clone();
		int x = coup.x;
		int y = coup.y;
		if(est_autorise(coup)){
			for(int i=x;i<tmp.l;i++){
				for(int j=y;j<tmp.h;j++){
					tmp.t[i][j]=false;
				}
			}
		}
		return tmp;
	}
}
