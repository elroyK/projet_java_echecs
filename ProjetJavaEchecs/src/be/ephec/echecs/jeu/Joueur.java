package be.ephec.echecs.jeu;
/**
 * Classe Joueur, représentant un joueur
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 26/11/14
 * date de modification : 10/12/14
 */

public class Joueur {
	// Constante
	final static int NBPIECE = 16;

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
	
	public Joueur(Piece[] tP){
		this.setNom(null);
		this.setNbVict(0);
		this.tbPiece = tP;
	}
	
	/**
	 * 
	 * @param plateau : échiquier de la partie
	 * @return un tableau avec toutes les pièces de ce joueur qui ont la possibilité de faire un mouvement ce tour-ci
	 */
	public Piece[] genererSelect(Echiquier plateau){
		Piece work[] = new Piece[NBPIECE];
		int n = 0;
		for (int i=0;i<NBPIECE;i++){
			if (this.tbPiece[i].isInGame()==true) {
				int k=0;
				Position tbPos[] = this.tbPiece[i].genererPos(plateau);
				while (k<tbPos.length && tbPos[k] == null){
					k++;
				};
				if (k<tbPos.length){
					work[n] = this.tbPiece[i];
					n++;
				}
			}
		}
		return work;
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