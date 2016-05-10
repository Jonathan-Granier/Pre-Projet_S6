package main;

public class Joueur {

	private int score;
	private boolean isIa;
	
	public Joueur(boolean isIa) {
		this.isIa = isIa;
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
