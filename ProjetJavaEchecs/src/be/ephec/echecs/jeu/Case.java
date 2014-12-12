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
 * Classe Case, repr�sentant une case de l'�chiquier
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de cr�ation : 25/11/14
 * date de modification : 08/12/14
 */

//import javax.swing.JButton;

public class Case extends JButton{
	protected boolean couleur; /* noir (false) - blanc (true) */
    protected boolean cliquable;
	protected String estOccupe;
	protected Position pos;
	
	/**
	 * Constructeur de la classe Case
	 * @param col : Booleen repr�sentant true (Blanc) et false(Noir)
	 * @param x : position en x sur l'�chiquier
	 * @param y : position en y sur l'�chiquier
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
		if (this.getCliquable()){
			if (this.getEstOccupe() == Param.LIBRE) this.setBackground(new Color(51, 153, 255));
		}
	}
	
	
	/**
	 * Permet de savoir quelle action effectuer en fonction de "l'ordre" du clic (1 ou 2)
	 * @param game La partie en cours
	 */
	
	public void actions(final Partie game){
		Piece[] tPW = new Piece[Joueur.NBPIECE]; 
		if (game.settings.getJoueurActuel()==1) tPW = game.jA.tbPiece;
		else tPW = game.jB.tbPiece;			
		
		final Joueur j = new Joueur(tPW);
		
		if (game.settings.getClic() == 0) {
			/*this.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					//game.settings.clic1 = new Position(pos.getX(), pos.getY());
					game.settings.clic1.setX(0);
					game.settings.clic1.setY(6);
					game.settings.setClic(game.settings.getClic()+1);
					
					Position work[] = j.tbPiece[game.findPiece(j)].genererPos(game.plateau,j.tbPiece[0].getColor());
					
					for (int i=0;i<work.length;i++){
						game.plateau.echiq[work[i].getX()][work[i].getY()].setCliquable(true);
						}
					
					game.plateau.echiq[game.settings.clic1.getX()][game.settings.clic1.getY()].setCliquable(true);
					}
			});*/
			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					game.settings.clic1.setX(pos.getX());
					game.settings.clic1.setY(pos.getY());
					game.settings.setClic(game.settings.getClic()+1);
					
					Position work[] = j.tbPiece[game.findPiece(j)].genererPos(game.plateau,j.tbPiece[0].getColor());
					for (int i=0;i<work.length;i++){
						game.plateau.echiq[work[i].getX()][work[i].getY()].setCliquable(true);
						}
					
					game.plateau.echiq[game.settings.clic1.getX()][game.settings.clic1.getY()].setCliquable(true);}
			});
		} else if (game.settings.clic ==1){
			/*this.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					game.settings.clic2 = new Position(pos.getX(), pos.getY());
					if (game.settings.clic2.equals(game.settings.clic1)) game.settings.setClic(0);
					else {
						game.settings.setClic(game.settings.getClic()+1);
						//TODO Faire bouger la pi�ce
					}
				}
			});*/
			this.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					game.settings.clic2 = new Position(pos.getX(), pos.getY());
					if (game.settings.clic2.equals(game.settings.clic1)) game.settings.setClic(0);
					else {
						game.settings.setClic(game.settings.getClic()+1);
						//TODO Faire bouger la pi�ce
					}}
			});
		}
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
