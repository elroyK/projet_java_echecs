package be.ephec.echecs.jeu;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.EventListener.*;
import java.awt.event.*;

/**
 * Classe Case, représentant une case de l'échiquier
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 25/11/14
 * date de modification : 08/12/14
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
	 * @param col : Booleen représentant true (Blanc) et false(Noir)
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
		this.setPreferredSize(new Dimension(50, 50));
	}
	
	/**
	 * Actualise l'image de fond d'une case
	 */
	
	public void actualise(String add) {
		this.setIcon(new ImageIcon(getClass().getResource(add)));
	}
	
	/**
	 *  clic sur une case
	 */
	
	public void Clic(Partie game) {
		if (game.settings.isClic()) {
			// CLIC 1 : déclenche l'évènement tableau de case possibles pour un déplacement 
			this.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					game.settings.setClic1(new Position());
					this.wait();
				}}); 
		} else {
			// CLIC 2 : déplace la pièce et plusieurs évenements peuvent se passer
			this.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
				
				}}); 	
		}
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
		this.setEnabled(clic);
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

	public Position getPos() {
		return pos;
	}
	
}
