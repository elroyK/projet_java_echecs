package be.ephec.echecs.jeu;
/**
 * Classe Param, représentant les paramètres de la partie
 * date de création : 26/11/14
 * date de modification : 14/12/14
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * 
 */

public class Param {
	public final static String BLANC = "BLANC";
	public final static String NOIR  = "NOIR";
	public final static String LIBRE = "LIBRE";
	
	protected int joueurActuel; // 1 ou 2 (2joueurs..)
	static public int clic = 0; // CLIQUE 1 ou 2
	protected Position clic1 = new Position();
	protected Position clic2 = new Position();
	
	/**
	 * Constructeur de la classe Param 
	 * Elle ne fait qu'initialiser le JoueurActuel à 1;
	 */
	
	public Param() {
		this.setJoueurActuel(1);
		clic=0;
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

}