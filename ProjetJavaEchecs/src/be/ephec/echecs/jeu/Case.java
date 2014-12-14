package be.ephec.echecs.jeu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	/**
	 * Constructeur de la classe Case
	 * @param col : Booleen représentant true (Blanc) et false(Noir)
	 * @param x : position en x sur l'échiquier
	 * @param y : position en y sur l'échiquier
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
		this.setEstOccupe(Param.LIBRE);
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
		if (this.getCliquable()){
			if (this.getEstOccupe()==Param.LIBRE) this.setBackground(new Color(51, 153, 255));
		}
		else this.setBackgroundColor(this.couleur);
	}
	
	
	/**
	 * Permet de savoir quelle action effectuer en fonction de "l'ordre" du clic (1 ou 2)
	 * @param game La partie en cours
	 */
	
	public void actions(final Partie game){		
		this.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if (Param.clic == 0) {
					game.settings.clic1 = new Position(pos.getX(), pos.getY());
					Param.clic = 1;
					System.out.println(game.settings.clic1.getX()+" "+game.settings.clic1.getY());
					int work = game.findPiece(Partie.getjEnCours());
					Position[] tbPos = Partie.getjEnCours().tbPiece[work].genererPos(game.plateau, Partie.getjEnCours().getCouleur());
					game.plateau.setButtonsCliquable(false);
					for (int i=0; i<tbPos.length; i++){
						game.plateau.echiq[tbPos[i].getX()][tbPos[i].getY()].setCliquable(true);
						System.out.println(i +": "+tbPos[i].getX()+" "+tbPos[i].getY());
					}
					game.plateau.echiq[pos.getX()][pos.getY()].setCliquable(true);
				} else if (Param.clic == 1) {
					game.settings.clic2 = new Position(pos.getX(), pos.getY());
					System.out.println(game.settings.clic2.getX()+" "+game.settings.clic2.getY());
					System.out.println(Param.clic);
					if (game.settings.clic2.equals(game.settings.clic1)){
						Param.clic = 0;
						System.out.println("Coucou");
						game.plateau.setButtonsCliquable(false);
						Position[] work = Partie.getjEnCours().genererSelect(game.plateau);
						for (int i=0;i<work.length;i++){
							game.plateau.echiq[work[i].getX()][work[i].getY()].setCliquable(true);
						}
						game.plateau.setVisible(true);
					}
					else {
						Param.clic = 2;
						int work = game.findPiece(Partie.getjEnCours());
						Partie.getjEnCours().tbPiece[work].pos.setX(game.settings.clic2.getX());
						Partie.getjEnCours().tbPiece[work].pos.setY(game.settings.clic2.getY());
						game.plateau.echiq[game.settings.clic2.getX()]
								[game.settings.clic2.getY()].setEstOccupe(Partie.getjEnCours().getCouleur());
						game.plateau.echiq[game.settings.clic1.getX()]
								[game.settings.clic1.getY()].setEstOccupe(Param.LIBRE);
						
						game.plateau.actualiser(game.jA,game.jB);
						game.plateau.setVisible(true);
						
						game.settings.chgmJoueurActuel();
						if (game.settings.getJoueurActuel() == 1) {
							Partie.setjEnCours(game.jA);
						}
						else Partie.setjEnCours(game.jB);
						game.tour(Partie.getjEnCours());
						
					}}}});
	}
	
	/*
	 * GETTERS ET SETTERS
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
		this.cliquable=clic;
		this.isCliquable();
		this.setVisible(true);
	}
	
	public boolean getCliquable() {
		return cliquable;
	}
	
}
