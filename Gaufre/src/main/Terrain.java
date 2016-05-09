package main;


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
	
	public Terrain clone(){
		Terrain res = new Terrain(l,h);
		for(int i=0;i<l;i++){
			for(int j=0;j<h;j++){
				res.t[i][j]=t[i][j];
			}
		}
		return res;
	}
	
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
}
