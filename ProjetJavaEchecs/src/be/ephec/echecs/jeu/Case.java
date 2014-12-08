package be.ephec.echecs.jeu;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Classe Case, repr�sentant une case de l'�chiquier
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de cr�ation : 25/11/14
 * date de modification : 04/12/14
 */

//import javax.swing.JButton;

public class Case extends JButton {

	
	protected boolean couleur; /* noir (false) - blanc (true) */
    protected boolean cliquable;
	protected String estOccupe;
	protected Position pos;
	protected int id;
	
	/**
	 * Constructeur de la classe Case
	 * @param col : Booleen repr�sentant true (Blanc) et false(Noir)
	 * 
	 */
	
	public Case(Boolean col, int x, int y) {
		if (col == true) {
			setCouleur(true);
			setBackgroundColor(couleur);
		} else {
			setCouleur(false);
			setBackgroundColor(couleur);
		}
		
		this.pos = new Position(x, y);
		
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
	 * Doit �tre ex�cut�e sur chaque case au moment de la s�lection d'une pi�ce � d�placer.
	 */
	public void isCliquable() {
		if (this.getCliquable()) this.setBackground(new Color(51, 153, 255));
	}
	
	/**
	 * Permet de mettre une ic�ne representant une pi�ce sur une case
	 * @param add : Adresse de l'image � mettre en fond
	 */
	
	public void setImage(String add) {
		this.setIcon(new ImageIcon(add));
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
