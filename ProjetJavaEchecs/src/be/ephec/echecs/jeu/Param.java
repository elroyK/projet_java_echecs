package be.ephec.echecs.jeu;
/**
 * Classe Param, représentant les paramètres de la partie
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 26/11/14
 * date de modification : 26/11/14
 */

public class Param {
	public static String BLANC = "BLANC";
	public static String NOIR  = "NOIR";
	public static String LIBRE = "LIBRE";
	
	public static int NBCASE = 8;
	
	protected int joueurActuel; // 1 ou 2 (2joueurs..)
	protected boolean clic; // CLIQUE 1 ou 2
	protected Position clic1 = new Position();
	protected Position clic2 = new Position();
	
	/**
	 * Constructeur de la classe Param 
	 * Elle ne fait qu'initialiser le JoueurActuel à 1;
	 */
	
	public Param() {
		this.setJoueurActuel(1);
		this.setClic(true); // mise à un du clic
	}
	
	public Position getClic1() {
		return clic1;
	}

	public void setClic1(Position clic1) {
		this.clic1 = clic1;
	}

	public Position getClic2() {
		return clic2;
	}

	public void setClic2(Position clic2) {
		this.clic2 = clic2;
	}

	public boolean isClic() {
		return clic;
	}

	public void setClic(boolean clic) {
		this.clic = clic;
	}

	/**
	 * Procédure chgmJoueurActuel, elle permet de changer de JoueurActuel 
	 */
	
	public void chgmJoueurActuel() {
		if (this.getJoueurActuel()==1) {this.setJoueurActuel(this.getJoueurActuel()+1);}
		else {this.setJoueurActuel(this.getJoueurActuel()-1);}
	}

	// GETTERS ET SETTERS
	
	public int getJoueurActuel() {
		return joueurActuel;
	}

	public void setJoueurActuel(int JoueurActuel) {
		this.joueurActuel = JoueurActuel;
	}

}
