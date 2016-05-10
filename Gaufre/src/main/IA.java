package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/* Difficultés: 1: IA aléatoire
 * 				2: IA Aléatoire + coups gagnants/perdants
 * 				3: IA MiniMax
 */
public class IA {
	Moteur moteur;
	int difficulte;
	
	public IA (Moteur moteur, int difficulte)
	{
		this.moteur = moteur;
		this.difficulte = difficulte;
	}
	
	// Determine le prochain coup à jouer et le renvoie. Si aucun coup n'est possible , renvoi null;
	public Point jouer_coup(){
		System.out.println("IA: On me demande de jouer un coup");
		switch (difficulte)
		{
		case 1:
			return jouer_coup_aleatoire();
		case 2:
			return jouer_coup_perdant_gagnant();
		case 3:
			return jouer_coup_minimax();
		default:
			return new Point(0,0);
		}
	}
	
	// Renvoie un coup aléatoire parmi la liste de coup possible.
	private Point jouer_coup_aleatoire(){
		Random R = new Random();
		ArrayList<Point> list_possibilite = moteur.T.coups_possibles();
		if(list_possibilite.isEmpty())
		{
			return null;
		}
		Point coup = list_possibilite.get(R.nextInt(list_possibilite.size()));
		return coup;
	}
	
	// Renvoie un coup gagnant s'il en existe un, sinon renvoie un coup non perdant aléatoire.
	private Point jouer_coup_perdant_gagnant()
	{
		ArrayList <Point> list_coups = moteur.T.coups_possibles();
		if(list_coups.isEmpty())
		{
			return null;
		}
		ArrayList <Point> coups_gagnants = new ArrayList();
		ArrayList <Point> coups_perdants = new ArrayList();
		ArrayList <Point> coups_neutres = new ArrayList();
		for(int i=0; i< list_coups.size(); i++)
		{
			if(est_gagnant(list_coups.get(i)))
			{
				coups_gagnants.add(list_coups.get(i));
			}
			else if(est_perdant(list_coups.get(i)))
			{
				coups_perdants.add(list_coups.get(i));
			}
			else
			{
				coups_neutres.add(list_coups.get(i));
			}
		}
		
		Random R = new Random();
		// s'il existe un coup gagnant, on en renvoie un.
		if(! coups_gagnants.isEmpty()){
			System.out.println("Coup Gagnant");
			return coups_gagnants.get(R.nextInt(coups_gagnants.size()));
		}
		// s'il n'existe pas de coup gagnant, on renvoie un coup non perdant s'il en existe un.
		else if( !coups_neutres.isEmpty()){
			System.out.println("Coup neutres");
			return coups_neutres.get(R.nextInt(coups_neutres.size()));
		}
		// s'il n'existe que des coups perdants, on en renvoie un.
		else {
			System.out.println("Coup perdant");
			return coups_perdants.get(R.nextInt(coups_perdants.size()));
		}
	}
	
	// Renvoi le meilleur coup trouvé avec l'algo du minimax.
	private Point jouer_coup_minimax()
	{
		Random R = new Random();
		ArrayList<Point> list_coups = new ArrayList();
		
		ArrayList<Point> list_possibilite = moteur.T.coups_possibles();
		if(list_possibilite.isEmpty())
		{
			return null;
		}
		
		for(int i=0;i<list_possibilite.size();i++)
		{
			Point p_courant = list_possibilite.get(i);
			
			
			Terrain tmp = moteur.T.consulter_coup(p_courant);
			if( minimax_Min_B(tmp));
			{
				list_coups.add(p_courant);
			}
		}
		Point p_retour = list_coups.get(R.nextInt(list_coups.size()));
		return p_retour;
	}
	
	// C'est à B de jouer , si il doit jouer forcement sur la case (0;0) , on renvoi 1 , sinon on renvoi le maximum du prochain coup de A
	private boolean minimax_Min_B(Terrain t_courant)
	{
		ArrayList<Point> list_possibilite = t_courant.coups_possibles();
		boolean val= true;
		
		
		if(list_possibilite.size()==1)  // SI il ne reste que la case (0;0) à jouer , alors B à perdu 
		{
			return true;
		}
		
		for(int i=0;i<list_possibilite.size();i++)
		{
			Point p_courant = list_possibilite.get(i);
			
			Terrain tmp = t_courant.consulter_coup(p_courant);
			val = val && minimax_Max_A(tmp);
			
		}			
		return val;
	}
	
	// C'est à A de jouer , si il doit jouer forcement sur la case (0;0) , on renvoi -1 , sinon on renvoi le minimum du prochain coup de B
	private boolean minimax_Max_A(Terrain t_courant)
	{
		ArrayList<Point> list_possibilite = t_courant.coups_possibles();
		boolean val = false;
		
		if(list_possibilite.size()==1)  // SI il ne reste que la case (0;0) à jouer , alors B à perdu 
		{
			return false;
		}
		
		for(int i=0;i<list_possibilite.size();i++)
		{
			Point p_courant = list_possibilite.get(i);
			
			Terrain tmp = t_courant.consulter_coup(p_courant);
			val = (val || minimax_Min_B(tmp));
			
		}			
		
		return val;
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
		if(coup_egal(coup, 0,1) && moteur.T.t[1][0])
		{
			return true;
		}
		else if (coup_egal(coup, 1,0) && moteur.T.t[0][1])
		{
			return true;
		}
		else if (coup_egal(coup, 0,0))
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
		if( !moteur.T.t[0][1] && coup_egal(coup,1,0))
		{
			return true;
		}
		else if ( !moteur.T.t[1][0] && coup_egal(coup,0,1))
		{
			return true;
		}
		
		// Après ce coup, on va se retrouver dans une situation 1-1-1
		// Il faut vérifier que les cases internes sont encore valides.
		else if(!moteur.T.t[0][2] && !moteur.T.t[1][1] && coup_egal(coup,2,0) && moteur.T.t[0][1] && moteur.T.t[1][0])
		{
			return true;
		}
		else if (!moteur.T.t[0][2] && coup_egal(coup,1,1) && !moteur.T.t[2][0] && moteur.T.t[0][1] && moteur.T.t[1][0])
		{
			return true;
		}
		else if (coup_egal(coup,0,2) && !moteur.T.t[1][1] && !moteur.T.t[2][0] && moteur.T.t[0][1] && moteur.T.t[1][0])
		{
			return true;
		}
		return false;
	}
	
	private boolean coup_egal(Point coup, int x, int y)
	{
		return coup.x == x && coup.y ==y;
	}
	
	private int eval_Heuristique(Terrain t)
	{
		if(!t.t[1][1])
		{
			// on vérifie que les deux branches sont de la même longueure
			int x_max = 0;
			int y_max = 0;
			while( x_max < t.h && t.t[x_max][0])
				x_max++;
			while( y_max < t.l && t.t[0][y_max])
				y_max++;
			if( x_max == y_max)
			{
				// on retourne moins l'infini si les deux branches sont de la même longueur.
				return -1;
			}
			else if( x_max != y_max)
			{
				// on retourne plus l'infini si les deux branches sont de longueur différentes.
				return +1;
			}
		}
		else if(t.t[1][1])
		{
			int x_max = 0;
			int y_max = 0;
			while( x_max < t.h && t.t[x_max][0])
				x_max++;
			while( y_max < t.l && t.t[0][y_max])
				y_max++;
			if( x_max == y_max)
			{
				// on retourne plus l'infini si les deux branches sont de la même longueur.
				return 1;
			}
		}
		
		return 0;
	}
}
