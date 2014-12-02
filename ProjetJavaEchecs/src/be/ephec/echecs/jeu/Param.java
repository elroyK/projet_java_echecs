package be.ephec.echecs.jeu;
/**
 * Classe Param, repr�sentant les param�tres de la partie
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de cr�ation : 26/11/14
 * date de modification : 26/11/14
 */

public class Param {
	
	protected int joueurActuel; // 1 ou 2 (2joueurs..)
	protected Position clic1 = new Position();
	protected Position clic2 = new Position();
	
	/**
	 * Constructeur de la classe Param 
	 * Elle ne fait qu'initialiser le JoueurActuel � 1;
	 */
	
	public Param() {
		this.setJoueurActuel(1);
	}
	
	/**
	 * Proc�dure chgmJoueurActuel, elle permet de changer de JoueurActuel 
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
