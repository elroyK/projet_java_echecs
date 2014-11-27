package echecs.jeu;
/**
 * Classe Joueur, représentant un joueur
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 26/11/14
 * date de modification : 26/11/14
 */

public class Joueur {
	protected String nom;
	protected int nbVict;
	protected String color;
	
	/**
	 * Constructeur de la classe Joueur
	 * @param n : nom du joueur
	 * @param c : couleur du joueur
	 */
	public Joueur(String n, String c) {	
		this.setNom(n);
		this.setNbVict(0);
		this.setColor(c);
		
	}
	
	// GETTERS ET SETTERS

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbVict() {
		return nbVict;
	}

	public void setNbVict(int nbVict) {
		this.nbVict = nbVict;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
