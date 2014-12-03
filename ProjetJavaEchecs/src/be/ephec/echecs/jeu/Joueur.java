package be.ephec.echecs.jeu;
/**
 * Classe Joueur, représentant un joueur
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 26/11/14
 * date de modification : 28/11/14
 */

public class Joueur {
	// Constante
	protected static int NBPIECE = 16;

	protected String nom;
	protected int nbVict;
	
	
	// Tableau de 16 pièces
	protected Piece[] tbPiece = new Piece[NBPIECE];
	
	/**
	 * Constructeur de la classe Joueur
	 * @param n : nom du joueur
	 * @param c : couleur du joueur
	 */
	public Joueur(String n) {	
		this.setNom(n);
		this.setNbVict(0);	
	}
	
	// GETTERS ET SETTERS
	
	public static int getNBPIECE() {
		return NBPIECE;
	}

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

}