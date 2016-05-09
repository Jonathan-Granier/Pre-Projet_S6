package main;


public class Terrain {
	boolean [][] t;
	int l,h;
	
	public Terrain(int l, int h){
		this.l=l;
		this.h=h;
		t=new boolean[l][h];
		for(int i=0;i<l;i++){
			for(int j=0;j<h;j++){
				t[i][j]=true;
			}
		}
	}
}
