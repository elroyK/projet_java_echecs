package be.ephec.echecs.jeu;

import be.ephec.echecs.gui.*;
/**
 * Classe Partie, programme mère du projet
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 26/11/14
 * date de modification : 28/11/14
 */

public class Partie {
	// nom du joueur à rentrer dans une fenetre 
	private Joueur  jA = new Joueur("");
	private Joueur  jB = new Joueur(""); 
	private Echiquier plateau = new Echiquier();
	private Param settings = new Param();
	private boolean reset;
	
	public static void main(String[] args) {
		Partie game = new Partie();	
		do {
			Fenetre.main(null);
			game.initialisation();
			while (game.finPartie()==true) {
				if (game.settings.getJoueurActuel() == 1)
					// TOUR DU JOUEUR 1
				{
					/*
					 *  TODO :  1.locké tous les boutons pour le joueurs 2
					 *  	   	2.le joueur 1 ne peut sélectionner que ces pièces (si elles sont toujours vivantes)
					 *  		3.Après le premier clic :
					 *  			retenir le premier clic 
					 *  			générer cases vertes (déplacement) possibles
					 *  			locké les cases impossibles à cliqué
					 *  			p.s. : s'il clique sur une de ces pièces on rechange le premier clic ?
					 *  		4.Après le second clic
					 *  			faire le déplacement et eventuelles kills
					 */				
					
				} else
					// TOUR DU JOUEUR 2
				{
					/*
					 *  TODO :  .... inversément 
					 */
				}
				game.settings.chgmJoueurActuel();
			}
			
			// TODO : A la fin de la partie demander l'accord de deux joueurs pour recommencer une partie
		} while (game.reset==true);
		 
		 
	}
	/**
	 * Constructeur de la classe Partie
	 */
	
	public Partie() {
		this.reset = false;
	}
	
	/**
	 * initialisation, initialise toutes les pièces à leurs places respectives
	 */
	public void initialisation() {
		// Initialisation pièces blanches
		this.jA.tbPiece[0] = new Pion(0,6,"img/pionB.gif");
		this.plateau.echiq[0][6].setEstOccupe("BLANC");
		this.jA.tbPiece[1] = new Pion(1,6,"img/pionB.gif");
		this.plateau.echiq[1][6].setEstOccupe("BLANC");
		this.jA.tbPiece[2] = new Pion(2,6,"img/pionB.gif");
		this.plateau.echiq[2][6].setEstOccupe("BLANC");
		this.jA.tbPiece[3] = new Pion(3,6,"img/pionB.gif");
		this.plateau.echiq[3][6].setEstOccupe("BLANC");
		this.jA.tbPiece[4] = new Pion(4,6,"img/pionB.gif");
		this.plateau.echiq[4][6].setEstOccupe("BLANC");
		this.jA.tbPiece[5] = new Pion(5,6,"img/pionB.gif");
		this.plateau.echiq[5][6].setEstOccupe("BLANC");
		this.jA.tbPiece[6] = new Pion(6,6,"img/pionB.gif");
		this.plateau.echiq[6][6].setEstOccupe("BLANC");
		this.jA.tbPiece[7] = new Pion(7,6,"img/pionB.gif");
		this.plateau.echiq[7][6].setEstOccupe("BLANC");
		
		this.jA.tbPiece[8] = new Cavalier(1,7,"img/cavalierB.gif");
		this.plateau.echiq[1][7].setEstOccupe("BLANC");
		this.jA.tbPiece[9] = new Cavalier(6,7,"img/cavalierB.gif");
		this.plateau.echiq[6][7].setEstOccupe("BLANC");
		this.jA.tbPiece[10] = new Tour(0,7,"img/tourB.gif");
		this.plateau.echiq[0][7].setEstOccupe("BLANC");
		this.jA.tbPiece[11] = new Tour(7,7,"img/tourB.gif");
		this.plateau.echiq[7][7].setEstOccupe("BLANC");
		this.jA.tbPiece[12] = new Fou(2,7,"img/fouB.gif");
		this.plateau.echiq[2][7].setEstOccupe("BLANC");
		this.jA.tbPiece[13] = new Fou(5,7,"img/fouB.gif");
		this.plateau.echiq[5][7].setEstOccupe("BLANC");
		this.jA.tbPiece[14] = new Roi(3,7,"img/roiB.gif");
		this.plateau.echiq[3][7].setEstOccupe("BLANC");
		this.jA.tbPiece[15] = new Reine(4,7,"img/reineB.gif");
		this.plateau.echiq[4][7].setEstOccupe("BLANC");
		
		// Initialisation pièces noires
		this.jB.tbPiece[0] = new Pion(0,1,"img/pionN.gif");
		this.plateau.echiq[0][1].setEstOccupe("NOIR");
		this.jB.tbPiece[1] = new Pion(1,1,"img/pionN.gif");
		this.plateau.echiq[1][1].setEstOccupe("NOIR");
		this.jB.tbPiece[2] = new Pion(2,1,"img/pionN.gif");
		this.plateau.echiq[2][1].setEstOccupe("NOIR");
		this.jB.tbPiece[3] = new Pion(3,1,"img/pionN.gif");
		this.plateau.echiq[3][1].setEstOccupe("NOIR");
		this.jB.tbPiece[4] = new Pion(4,1,"img/pionN.gif");
		this.plateau.echiq[4][1].setEstOccupe("NOIR");
		this.jB.tbPiece[5] = new Pion(5,1,"img/pionN.gif");
		this.plateau.echiq[5][1].setEstOccupe("NOIR");
		this.jB.tbPiece[6] = new Pion(6,1,"img/pionN.gif");
		this.plateau.echiq[6][1].setEstOccupe("NOIR");
		this.jB.tbPiece[7] = new Pion(7,1,"img/pionN.gif");
		this.plateau.echiq[7][1].setEstOccupe("NOIR");
		
		this.jB.tbPiece[8] = new Cavalier(1,0,"img/cavalierN.gif");
		this.plateau.echiq[1][0].setEstOccupe("NOIR");
		this.jB.tbPiece[9] = new Cavalier(6,0,"img/cavalierN.gif");
		this.plateau.echiq[6][0].setEstOccupe("NOIR");
		this.jB.tbPiece[10] = new Tour(0,0,"img/tourN.gif");
		this.plateau.echiq[0][0].setEstOccupe("NOIR");
		this.jB.tbPiece[11] = new Tour(7,0,"img/tourN.gif");
		this.plateau.echiq[7][0].setEstOccupe("NOIR");
		this.jB.tbPiece[12] = new Fou(2,0,"img/fouN.gif");
		this.plateau.echiq[2][0].setEstOccupe("NOIR");
		this.jB.tbPiece[13] = new Fou(5,0,"img/fouN.gif");
		this.plateau.echiq[5][0].setEstOccupe("NOIR");
		this.jB.tbPiece[14] = new Roi(4,0,"img/roiN.gif");
		this.plateau.echiq[4][0].setEstOccupe("NOIR");
		this.jB.tbPiece[15] = new Reine(3,0,"img/reineN.gif");
		this.plateau.echiq[5][0].setEstOccupe("NOIR");		
}
			
	
	/**
	 * finPartie, permet de mettre fin à une partie
	 * @return : "true" si la partie est fini, "false" si la partie n'est pas fini
	 */
	
	public boolean finPartie() {
		// TODO : Implémenter la méthode avec tous les tests.......................
		return true;
	}

}