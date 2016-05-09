package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/* Difficultés: 1: IA aléatoire
 * 				2: IA Aléatoire + coups gagnants/perdants
 * 				3: IA MinMax
 */
public class IA {
	Moteur moteur;
	int difficulte;
	Terrain t;
	
	public IA (Moteur moteur, int difficulte)
	{
		this.moteur = moteur;
		this.difficulte = difficulte;
		this.t = moteur.T;
	}
	
	// Renvoie un coup. Pas d'autre effet de bord.
	public Point jouer_coup(){
		switch (difficulte)
		{
		case 1:
			return jouer_coup_aleatoire();
		default:
			return new Point(0,0);
		}
	}
	
	// Renvoie un coup aléatoire parmi la liste de coup possible.
	private Point jouer_coup_aleatoire(){
		Random R = new Random();
		ArrayList<Point> list_possibilite = moteur.coups_possibles();
		Point coup = list_possibilite.get(R.nextInt(list_possibilite.size()));
		return coup;
	}
	/*
	 Un coup est perdant si après celui-ci
	 l'adversaire se retrouve avec un terrain d'une seule ligne/colonne
	 d'une longueur supérieur à 1.
	 On suppose le coup possible et qu'il n'y a pas de coup gagnant.
	 */
	private boolean est_perdant(Point coup)
	{
		// Les coups perdants ont forcement une coordonée <2
		if(coup_egal(coup, 0,1) && t.t[1][0])
		{
			return true;
		}
		else if (coup_egal(coup, 1,0) && t.t[0][1])
		{
			return true;
		}
		return false;
	}
	
	/* Un coup est gagnant si:
	 On ne laisse que le poison (après le coup)
	 ou on laisse le poison et deux case non adjacentes. : 
	  X O
	  O
	 */
	private boolean est_gagnant(Point coup)
	{
		//L'une des case adjacente est déjà bloqué et on bloque l'autre.
		if( !t.t[0][1] && coup_egal(coup,1,0))
		{
			return true;
		}
		else if ( !t.t[1][0] && coup_egal(coup,0,1))
		{
			return true;
		}
		
		// Après ce coup, on va se retrouver dans une situation 1-1-1
		else if(!t.t[0][2] && !t.t[1][1] && coup_egal(coup,2,0))
		{
			return true;
		}
		else if (!t.t[0][2] && coup_egal(coup,1,1) && !t.t[2][0])
		{
			return true;
		}
		else if (coup_egal(coup,0,2) && !t.t[1][1] && !t.t[2][0])
		{
			return true;
		}
		return false;
	}
	
	private boolean coup_egal(Point coup, int x, int y)
	{
		return coup.x == x && coup.y ==y;
	}
}
