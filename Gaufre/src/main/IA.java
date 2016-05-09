package main;

import java.awt.Point;

public class IA {
	Terrain t;
	
	// Un coup est perdant si après celui-ci
	// l'adversaire se retrouve avec un terrain d'une seule ligne/colonne
	// d'une longueur supérieur à 1.
	public boolean est_perdant(Point coup)
	{
		// Les coups perdants ont forcement une coordonée <2
		if(coup.x < 2 || coup.y < 2)
		{
			if(t.)
		}
		return false;
	}
}
