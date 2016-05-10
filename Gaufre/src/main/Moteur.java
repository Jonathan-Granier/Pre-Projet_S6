package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Moteur {
	Terrain T;
	int joueur;
	ArrayList<Terrain> histo,redo;
	
	public Moteur(Terrain T){
		this.T=T;
		histo=new ArrayList<Terrain>();
		histo.add(T.clone());
		redo=new ArrayList<Terrain>();
		joueur = 1;
		System.out.println("Tour du joueur " + joueur);
	}
	
	// Réinitialise le terrain
	void nouvelle_partie(){
		for(int i=0;i<T.l;i++){
			for(int j=0;j<T.h;j++){
				T.t[i][j]=true;
			}
		}
		histo.clear();
		histo.add(T.clone());
		redo.clear();
		joueur = 1;
		System.out.println("Tour du joueur " + joueur);
	}
	
	// Change de joueur 1 <-> 2
	void swap_joueur(){
		if(joueur==1) joueur=2;
		else joueur=1;
	}
	
	// A utiliser si partie_terminee a renvoyé vrai
	public boolean s_est_suicide(int j){
		return j==joueur && !T.t[0][0];
	}
	
	// Détermine si la partie est terminée (il ne reste que le poison)
	public boolean partie_terminee(){
		return (!T.t[1][0] && !T.t[0][1]) || !T.t[0][0];
	}
	
	// Renvoie vrai <=> le coup donné est autorise
	public boolean est_autorise(Point coup){
		if(coup.x<0 || coup.x>=T.l || coup.y<0 || coup.y>=T.h) return false;
		else return T.t[coup.x][coup.y];
	}
	
	// Renvoie une ArrayList des coups autorises (0,0) compris
	public ArrayList<Point> coups_possibles(){
		ArrayList<Point> res=new ArrayList<Point>();
		for(int i=0;i<T.l;i++){
			for(int j=0;j<T.h;j++){
				if(T.t[i][j]) res.add(new Point(i,j));
			}
		}
		return res;
	}
	
	// Renvoie une ArrayList des coups autorises (0,0) compris
	public ArrayList<Point> coups_possibles(Terrain T){
		ArrayList<Point> res=new ArrayList<Point>();
		for(int i=0;i<T.l;i++){
			for(int j=0;j<T.h;j++){
				if(T.t[i][j]) res.add(new Point(i,j));
			}
		}
		return res;
	}
	
	// Renvoie le terrain après le coup donné. Ne modifie pas l'état actuel.
	public Terrain consulter_coup(Point coup){
		Terrain tmp = T.clone();
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
	
	// Joue un coup aux coordonnées donnees. Si le coup n'est pas possible, rien ne se passe et retourne 1,
	//si la partie est terminée, retourne -1, 0 sinon.
	public int jouer_coup(Point coup){
		if(est_autorise(coup)){
			T=consulter_coup(coup);
			if(partie_terminee()){
				System.out.println("Partie terminée !");
				System.out.println("Le joueur " + joueur + " a gagné !");
				return -1;
			}
			histo.add(T.clone());
			redo.clear();
			swap_joueur();
			System.out.println("Tour du joueur " + joueur);
			return 0;
		}
		else{
			return 1;
		}
	}
	
	// Recule d'un cran dans l'historique. Renvoie 0 si tout s'est bien passé, 1 si on est déjà au terrain de départ.
	public int annuler(){
		if(histo.size()==1) return 1;
		else{
			redo.add(histo.remove(histo.size()-1));
			T=histo.get(histo.size()-1).clone();
			swap_joueur();
			System.out.println("Tour du joueur " + joueur);
			return 0;
		}
	}
	
	// Le contraire d'annuler. Renvoie 0 si tout s'est bien passé, 1 si on est à la fin de l'historique.
	public int refaire(){
		if(redo.size()==0) return 1;
		else{
			histo.add(redo.remove(redo.size()-1));
			T=histo.get(histo.size()-1);
			swap_joueur();
			System.out.println("Tour du joueur " + joueur);
			return 0;
		}
	}
}
