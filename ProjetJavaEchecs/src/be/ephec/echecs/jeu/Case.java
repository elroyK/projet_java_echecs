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
		
		if (Param.clic ==0){
			this.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					Param.clic1 = new Position(pos.getX(), pos.getY());
					Param.clic++;
					}
				});
			}else if (Param.clic ==1){
				this.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						Param.clic2 = new Position(pos.getX(), pos.getY());
						Param.clic++;
						}
				});
			}
	}
		
	
	/**
	 * Actualise l'image de fond d'une case
	 */
	
	public void actualise(String add) {
		this.setIcon(new ImageIcon(getClass().getResource(add)));
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
