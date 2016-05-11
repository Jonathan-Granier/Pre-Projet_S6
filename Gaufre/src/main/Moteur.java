package main;

import java.awt.Point;
import java.util.ArrayList;

public class Moteur {
	Terrain T;
	int joueur;		// joueur actuel : 1 ou 2
	ArrayList<Terrain> histo,redo;
	String message;
	Joueur [] j;
	
	public Moteur(Terrain T,Joueur j1, Joueur j2){
		this.T=T;
		histo=new ArrayList<Terrain>();
		histo.add(T.clone());
		redo=new ArrayList<Terrain>();
		joueur = 1;
		message = "Tour du joueur " + joueur;
		j = new Joueur[3];
		j[1] = j1;
		j[2] = j2;
	}
	
	// Réinitialise le terrain
	public void nouvelle_partie(){
		for(int i=0;i<T.l;i++){
			for(int j=0;j<T.h;j++){
				T.t[i][j]=true;
			}
		}
		histo.clear();
		histo.add(T.clone());
		redo.clear();
		joueur = 1;
		message = "Tour du joueur " + joueur;
	}
	
	public int getJ(){
		return joueur;
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
	
	// Joue un coup aux coordonnées donnees. Si le coup n'est pas possible, rien ne se passe et retourne -1,
	// si la partie est terminée, retourne le numero du joueur qui a gagne, 0 sinon.
	public int jouer_coup(Point coup){
		if(T.est_autorise(coup)){
			T=T.consulter_coup(coup);
			if(partie_terminee()){
				if(s_est_suicide(joueur)) swap_joueur();
				message = "Joueur " + joueur + " gagne!";
				j[joueur].incrScore();
				return joueur;
			}
			histo.add(T.clone());
			redo.clear();
			swap_joueur();
			message = "Tour du joueur " + joueur;
			return 0;
		}
		else{
			return -1;
		}
	}
	
	public void initScore(){
		j[1].setScore(0);
		j[2].setScore(0);
	}
	
	// Recule d'un cran dans l'historique. Renvoie 0 si tout s'est bien passé, 1 si on est déjà au terrain de départ.
	public int annuler(){
		if(histo.size()==1) return 1;
		else{
			redo.add(histo.remove(histo.size()-1));
			T=histo.get(histo.size()-1);
			swap_joueur();
			message = "Tour du joueur " + joueur;
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
			message = "Tour du joueur " + joueur;
			return 0;
		}
	}
}
