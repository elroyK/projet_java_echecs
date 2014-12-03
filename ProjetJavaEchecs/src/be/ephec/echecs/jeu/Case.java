package be.ephec.echecs.jeu;

import java.awt.Color;

import javax.swing.JButton;

/**
 * Classe Case, représentant une case de l'échiquier
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 25/11/14
 * date de modification : 03/12/14
 */

//import javax.swing.JButton;

public class Case extends JButton {
	public static String BLANC = "BLANC";
	public static String NOIR  = "NOIR";
	public static String LIBRE = "LIBRE";
	
	protected boolean couleur; /* noir (false) - blanc (true) */
    protected boolean cliquable;
	protected String estOccupe;
	protected Position pos;
	
	/**
	 * Constructeur de la classe Case
	 * @param col : Booleen représentant true (Blanc) et false(Noir)
	 * 
	 */
	
	public Case(Boolean col) {
		if (col == true) {
			setCouleur(true);
			setBackgroundColor(couleur);
		} else {
			setCouleur(false);
			setBackgroundColor(couleur);
		}
		
		/* TODO : Définir la taille d'un coté en pixels
		 */
	}

	/**
	 * Permet de mettre le fond de la case en noir ou blanc
	 * @param col : couleur 
	 */
	
	public void setBackgroundColor(Boolean col) {
		if (col==true){
			this.setBackground(Color.WHITE);
		} else  {
			this.setBackground(Color.BLACK);
		}
	}
	
	
	/**
	 * Permet de mettre le fond de la case en bleu si jamais elle est cliquable.
	 * Doit être exécutée sur chaque case au moment de la sélection d'une pièce à déplacer.
	 */
	public void isCliquable() {
		if (this.getCliquable()) this.setBackground(new Color(51, 153, 255));
	}
	
	/**
	 * Permet de mettre une icône representant une pièce sur une case
	 * @param add : Adresse de l'image à mettre en fond
	 */
	
	public void setImage(String add) {
		// TODO : METTRE UNE IMAGE EN FOND DE CASE
	}
	
	/**
	 * TOUS LES GETTERS ET SETTERS
	 */
	
	public boolean getCouleur() {
		return couleur;
	}

	public void setCouleur(boolean couleur) {
		this.couleur = couleur;
	}

	public String getEstOccupe() {
		return estOccupe;
	}

	public void setEstOccupe(String estOccupe) {
		this.estOccupe = estOccupe;
	}
	
	public void setCliquable(boolean clic) {
		this.cliquable = clic;
	}
	
	public boolean getCliquable() {
		return cliquable;
	}
}
