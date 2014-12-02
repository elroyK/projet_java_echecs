package be.ephec.echecs.jeu;
/**
 * Classe Partie, programme mère du projet
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 26/11/14
 * date de modification : 28/11/14
 */

public class Partie {
	// nom du joueur à rentrer dans une fenetre 
	private Joueur  jA = new Joueur("","blanc");
	private Joueur  jB = new Joueur("","noir"); 
	private Param settings = new Param();
	private boolean reset;
	
	public static void main(String[] args) {
		Partie game = new Partie();	
		do {
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
		// TODO : Implémenter les classes Reines, Roi et Tour pour qu' initialisation() compile.
		for (int i=0;i<Joueur.getNBPIECE();i++){
			// Initalisation pièces blanches
			switch (i) {
				case 0: this.jA.tbPiece[i] = new Pion(0,6,"");
						break;
				case 1: this.jA.tbPiece[i] = new Pion(1,6,"");
						break;
				case 2: this.jA.tbPiece[i] = new Pion(2,6,"");
						break;
				case 3: this.jA.tbPiece[i] = new Pion(3,6,"");
						break;
				case 4: this.jA.tbPiece[i] = new Pion(4,6,"");
						break;
				case 5: this.jA.tbPiece[i] = new Pion(5,6,"");
						break;
				case 6: this.jA.tbPiece[i] = new Pion(6,6,"");
						break;
				case 7: this.jA.tbPiece[i] = new Pion(7,6,"");
						break;
				case 8: this.jA.tbPiece[i] = new Cavalier(1,7,"");
						break;
				case 9: this.jA.tbPiece[i] = new Cavalier(6,7,"");
						break;
				case 10: this.jA.tbPiece[i] = new Tour(0,7,"");
						break;
				case 11: this.jA.tbPiece[i] = new Tour(7,7,"");
						break;
				case 12: this.jA.tbPiece[i] = new Fou(2,7,"");
						break;
				case 13: this.jA.tbPiece[i] = new Fou(5,7,"");
						break;
				case 14: this.jA.tbPiece[i] = new Roi(3,7,"");
				break;	
				default: this.jA.tbPiece[i] = new Reine(4,7,"");
					break;
				}
			// Initialisation pièces noires
			switch (i) {
				case 0: this.jB.tbPiece[i] = new Pion(0,1,"");
					break;
				case 1: this.jB.tbPiece[i] = new Pion(1,1,"");
					break;
				case 2: this.jB.tbPiece[i] = new Pion(2,1,"");
					break;
				case 3: this.jB.tbPiece[i] = new Pion(3,1,"");
					break;
				case 4: this.jB.tbPiece[i] = new Pion(4,1,"");
					break;
				case 5: this.jB.tbPiece[i] = new Pion(5,1,"");
					break;
				case 6: this.jB.tbPiece[i] = new Pion(6,1,"");
					break;
				case 7: this.jB.tbPiece[i] = new Pion(7,1,"");
					break;
				case 8: this.jB.tbPiece[i] = new Cavalier(1,0,"");
					break;
				case 9: this.jB.tbPiece[i] = new Cavalier(6,0,"");
					break;
				case 10: this.jB.tbPiece[i] = new Tour(0,0,"");
					break;
				case 11: this.jB.tbPiece[i] = new Tour(7,0,"");
					break;
				case 12: this.jB.tbPiece[i] = new Fou(2,0,"");
					break;
				case 13: this.jB.tbPiece[i] = new Fou(5,0,"");
					break;
				case 14: this.jB.tbPiece[i] = new Roi(4,0,"");
					break;	
				default: this.jB.tbPiece[i] = new Reine(3,0,"");
					break;
			}
		}
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