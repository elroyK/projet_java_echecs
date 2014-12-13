package be.ephec.echecs.jeu;

import be.ephec.echecs.gui.*;
import be.ephec.echecs.tcp.ControlerTCP;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
/**
 * Classe Partie, programme mère du projet
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 26/11/14
 * date de modification : 10/12/14
 */

public class Partie {
	// nom du joueur à rentrer dans une fenetre 
	protected Joueur  jA = new Joueur("");
	protected Joueur  jB = new Joueur("");
	protected Joueur  jEnCours = new Joueur("");
	protected Echiquier plateau = new Echiquier();
	protected Param settings = new Param();
	protected boolean reset;
	
	public static void main(String[] args) {
		Partie game = new Partie();	
//		do {	
				Echiquier.main(null);
				game.initialisation();
				game.plateau.actualiser(game.jA, game.jB); // Fonctionne
				//Début de tour
			
				Position workS[] = new Position[Joueur.NBPIECE];
				
				if (game.settings.getJoueurActuel()==1)
					workS = game.jA.genererSelect(game.plateau);
				else workS = game.jB.genererSelect(game.plateau);
				
				game.plateau.showPieceChoice(workS);
				do {
					for (int i=0;i<Echiquier.NLIGNES;i++){
						for (int j=0;j<Echiquier.NLIGNES;j++){
							game.plateau.echiq[i][j].actions(game);
						}
					}
					game.plateau.setVisible(true);
					//game.plateau.actualiser(game.jA, game.jB);
					
				} while(game.settings.getClic() !=2);
				game.plateau.actualiser(game.jA, game.jB); // REFRESH
				
			
		/*	while (game.finPartie()==true) {
				
				
				// IMPLEMENTATION A UN JOUEUR
				
				
				// FIN DE L IMPLEMENATION				
				
               /* if (game.settings.getJoueurActuel() == 1)
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
					 			
					
				} else
					// TOUR DU JOUEUR 2
				{
					/*
					 *  TODO :  .... inversément 
					 
				}
				game.settings.chgmJoueurActuel();
			}
			
			// TODO : A la fin de la partie demander l'accord de deux joueurs pour recommencer une partie
		} while (game.reset==true);*/
		 
		 
	}
	
	/**
	 * Constructeur de la classe Partie
	 */
	
	public Partie() {
		this.reset = false;
		this.settings.setClic(0);
	}
	
	/**
	 * findPiece, trouve la pièce ou se trouve clic1
	 * @param : Le joueur, pour avoir ses pièces
	 * @return : l'indice où se trouve la pièce dans le tableau de pièces du Joueur
	 */
	
	public int findPiece(Joueur j)  {
		int work=-1;
		for (int i=0;i<Joueur.NBPIECE;i++) {
			if (this.settings.clic1.equals(j.tbPiece[i].pos)) {
				work=i;
			}
		}
		return work;
	}
	
	/**
	 * Test les positions des pièces des deux joueurs si = -> kill une éventuelle pièce
	 */
	
	public void testPosPiece (){
		for (int i=0;i<Joueur.NBPIECE;i++) {
			for (int j=0;j<Joueur.NBPIECE;i++) {
				if (this.settings.getJoueurActuel()==1){
					if (this.jA.tbPiece[i].pos.equals(this.jB.tbPiece[j].pos)) {
						this.jB.tbPiece[i].kill();
					}
				} else {
					if (this.jB.tbPiece[i].pos.equals(this.jB.tbPiece[j].pos)) {
						this.jA.tbPiece[i].kill();
					}
				}	
			}
		}
	}
	
	/**
	 * initialisation, initialise toutes les pièces à leurs places respectives
	 */
	public void initialisation() {
		// Initialisation pièces blanches
		this.jA.tbPiece[0] = new Pion(0,6,"/img/pionB.gif",Param.BLANC);
		this.plateau.echiq[0][6].setEstOccupe("BLANC");
		this.jA.tbPiece[1] = new Pion(1,6,"/img/pionB.gif",Param.BLANC);
		this.plateau.echiq[1][6].setEstOccupe("BLANC");
		this.jA.tbPiece[2] = new Pion(2,6,"/img/pionB.gif",Param.BLANC);
		this.plateau.echiq[2][6].setEstOccupe("BLANC");
		this.jA.tbPiece[3] = new Pion(3,6,"/img/pionB.gif",Param.BLANC);
		this.plateau.echiq[3][6].setEstOccupe("BLANC");
		this.jA.tbPiece[4] = new Pion(4,6,"/img/pionB.gif",Param.BLANC);
		this.plateau.echiq[4][6].setEstOccupe("BLANC");
		this.jA.tbPiece[5] = new Pion(5,6,"/img/pionB.gif",Param.BLANC);
		this.plateau.echiq[5][6].setEstOccupe("BLANC");
		this.jA.tbPiece[6] = new Pion(6,6,"/img/pionB.gif",Param.BLANC);
		this.plateau.echiq[6][6].setEstOccupe("BLANC");
		this.jA.tbPiece[7] = new Pion(7,6,"/img/pionB.gif",Param.BLANC);
		this.plateau.echiq[7][6].setEstOccupe("BLANC");
		
		this.jA.tbPiece[8] = new Cavalier(1,7,"/img/cavalierB.gif",Param.BLANC);
		this.plateau.echiq[1][7].setEstOccupe("BLANC");
		this.jA.tbPiece[9] = new Cavalier(6,7,"/img/cavalierB.gif",Param.BLANC);
		this.plateau.echiq[6][7].setEstOccupe("BLANC");
		this.jA.tbPiece[10] = new Tour(0,7,"/img/tourB.gif",Param.BLANC);
		this.plateau.echiq[0][7].setEstOccupe("BLANC");
		this.jA.tbPiece[11] = new Tour(7,7,"/img/tourB.gif",Param.BLANC);
		this.plateau.echiq[7][7].setEstOccupe("BLANC");
		this.jA.tbPiece[12] = new Fou(2,7,"/img/fouB.gif",Param.BLANC);
		this.plateau.echiq[2][7].setEstOccupe("BLANC");
		this.jA.tbPiece[13] = new Fou(5,7,"/img/fouB.gif",Param.BLANC);
		this.plateau.echiq[5][7].setEstOccupe("BLANC");
		this.jA.tbPiece[14] = new Roi(3,7,"/img/roiB.gif",Param.BLANC);
		this.plateau.echiq[3][7].setEstOccupe("BLANC");
		this.jA.tbPiece[15] = new Reine(4,7,"/img/reineB.gif",Param.BLANC);
		this.plateau.echiq[4][7].setEstOccupe("BLANC");
		
		// Initialisation pièces noires
		this.jB.tbPiece[0] = new Pion(0,1,"/img/pionN.gif",Param.NOIR);
		this.plateau.echiq[0][1].setEstOccupe("NOIR");
		this.jB.tbPiece[1] = new Pion(1,1,"/img/pionN.gif",Param.NOIR);
		this.plateau.echiq[1][1].setEstOccupe("NOIR");
		this.jB.tbPiece[2] = new Pion(2,1,"/img/pionN.gif",Param.NOIR);
		this.plateau.echiq[2][1].setEstOccupe("NOIR");
		this.jB.tbPiece[3] = new Pion(3,1,"/img/pionN.gif",Param.NOIR);
		this.plateau.echiq[3][1].setEstOccupe("NOIR");
		this.jB.tbPiece[4] = new Pion(4,1,"/img/pionN.gif",Param.NOIR);
		this.plateau.echiq[4][1].setEstOccupe("NOIR"); 
		this.jB.tbPiece[5] = new Pion(5,1,"/img/pionN.gif",Param.NOIR);
		this.plateau.echiq[5][1].setEstOccupe("NOIR");
		this.jB.tbPiece[6] = new Pion(6,1,"/img/pionN.gif",Param.NOIR);
		this.plateau.echiq[6][1].setEstOccupe("NOIR");
		this.jB.tbPiece[7] = new Pion(7,1,"/img/pionN.gif",Param.NOIR);
		this.plateau.echiq[7][1].setEstOccupe("NOIR");
		
		this.jB.tbPiece[8] = new Cavalier(1,0,"/img/cavalierN.gif",Param.NOIR);
		this.plateau.echiq[1][0].setEstOccupe("NOIR");
		this.jB.tbPiece[9] = new Cavalier(6,0,"/img/cavalierN.gif",Param.NOIR);
		this.plateau.echiq[6][0].setEstOccupe("NOIR");
		this.jB.tbPiece[10] = new Tour(0,0,"/img/tourN.gif",Param.NOIR);
		this.plateau.echiq[0][0].setEstOccupe("NOIR");
		this.jB.tbPiece[11] = new Tour(7,0,"/img/tourN.gif",Param.NOIR);
		this.plateau.echiq[7][0].setEstOccupe("NOIR");
		this.jB.tbPiece[12] = new Fou(2,0,"/img/fouN.gif",Param.NOIR);
		this.plateau.echiq[2][0].setEstOccupe("NOIR");
		this.jB.tbPiece[13] = new Fou(5,0,"/img/fouN.gif",Param.NOIR);
		this.plateau.echiq[5][0].setEstOccupe("NOIR");
		this.jB.tbPiece[14] = new Roi(3,0,"/img/roiN.gif",Param.NOIR);
		this.plateau.echiq[4][0].setEstOccupe("NOIR");
		this.jB.tbPiece[15] = new Reine(4,0,"/img/reineN.gif",Param.NOIR);
		this.plateau.echiq[3][0].setEstOccupe("NOIR");
		
		/*ActionListener listener = new CaseListener(this);
		for (int x=0;x<Echiquier.NLIGNES;x++){
			for (int y=0;y<Echiquier.NLIGNES;y++){
				this.plateau.echiq[x][y].addActionListener(listener);
			}
		}*/
		
		this.plateau.setVisible(true);
		this.settings.setJoueurActuel(1);
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