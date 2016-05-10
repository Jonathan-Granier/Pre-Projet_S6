package main;

public class Joueur {

	private int score;
	private boolean isIa;
	private int iaLevel;
	
	public Joueur(boolean isIa,int iaLevel) {
		this.isIa = isIa;
		this.iaLevel = iaLevel;
		score = 0;
	}

	public int getIaLevel() {
		return iaLevel;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isIa() {
		return isIa;
	}

	public void setIa(boolean isIa) {
		this.isIa = isIa;
	}
	
	
	
}
