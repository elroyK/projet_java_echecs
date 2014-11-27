package echecs.jeu;
/**
 * Classe Param, repr�sentant les param�tres de la partie
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de cr�ation : 26/11/14
 * date de modification : 26/11/14
 */

public class Param {
	protected int tour; // 1 ou 2 (2joueurs..)
	protected Position clic1 = new Position();
	protected Position clic2 = new Position();
	
	/**
	 * Constructeur de la classe Param 
	 * Elle ne fait qu'initialiser le tour � 1;
	 */
	
	public Param() {
		this.setTour(1);
	}
	
	/**
	 * Proc�dure chgmTour, elle permet de changer de tour 
	 */
	
	public void chgmTour() {
		if (this.getTour()==1) {this.setTour(this.getTour()+1);}
		else {this.setTour(this.getTour()-1);}
	}

	// GETTERS ET SETTERS
	
	public int getTour() {
		return tour;
	}

	public void setTour(int tour) {
		this.tour = tour;
	}

}
