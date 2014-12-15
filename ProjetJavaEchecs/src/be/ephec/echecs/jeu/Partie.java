package be.ephec.echecs.jeu;

import be.ephec.echecs.gui.*;

import javax.swing.*;

/**
 * Classe Partie, programme mère du projet
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 26/11/14
 * date de modification : 10/12/14
 */

public class Partie {
	// nom du joueur à rentrer dans une fenetre 
	protected Joueur  jA = new Joueur("",Param.BLANC);
	protected Joueur  jB = new Joueur("",Param.NOIR);
	private static Joueur  jEnCours = new Joueur("","");
	protected Echiquier plateau = new Echiquier();
	protected Param settings = new Param();

	/**
	 * Lance la partie et le premier tour. A partir de là, c'est la fin du tour (à clic==2) d'un joueur qui lance le tour suivant.
	 * @param args : rien
	 */
	public static void main(String[] args) {
		Partie game = new Partie();	
			
				Echiquier.main(null);
				game.initialisation();
				if (game.settings.getJoueurActuel()==1) Partie.setjEnCours(game.jA);
				else Partie.setjEnCours(game.jB);
				game.tour(Partie.getjEnCours());

	}
	
	/**
	 * Constructeur de la classe Partie
	 */
	
	public Partie() {
		Param.clic = 0;
	}
	
	/**
	 * findPiece, trouve la pièce ou se trouve clic1
	 * @param j : Le joueur, pour avoir ses pièces
	 * @param pos : La position pour laquelle on veut vérifier s'il y a une pièce dessus
	 * @return : l'indice où se trouve la pièce dans le tableau de pièces du Joueur
	 */
	
	public int findPiece(Joueur j, Position pos)  {
		int work=-1;
		for (int i=0;i<Joueur.NBPIECE;i++) {
			if (pos.equals(j.tbPiece[i].pos)) {
				work=i;
			}
		}
		return work;
	}
	
	/**
	 * Teste les positions des pièces des deux joueurs ; si idem alors kill une éventuelle pièce
	 */
	
	public void testPosPiece (){
		for (int i=0;i<Joueur.NBPIECE;i++) {
			for (int j=0;j<Joueur.NBPIECE;i++) {
				if (this.settings.getJoueurActuel()==1){
					if (this.jA.tbPiece[i].pos==this.jB.tbPiece[j].pos) {
						this.jB.tbPiece[i].kill();
					}
				} else {
					if (this.jA.tbPiece[i].pos.equals(this.jB.tbPiece[j].pos))  {
						this.jA.tbPiece[i].kill();
					}
				}	
			}
		}
	}
	
	/**
	 * initialisation : initialise toutes les pièces à leurs places respectives,
	 * met les actionListener sur les cases, et décide du premier joueur
	 */
	public void initialisation() {
		// Initialisation pièces blanches
		this.jA.tbPiece[0] = new Pion(0,6,"/img/pionB.gif",Param.BLANC);
		this.plateau.echiq[0][6].setEstOccupe(Param.BLANC);
		this.jA.tbPiece[1] = new Pion(1,6,"/img/pionB.gif",Param.BLANC);
		this.plateau.echiq[1][6].setEstOccupe(Param.BLANC);
		this.jA.tbPiece[2] = new Pion(2,6,"/img/pionB.gif",Param.BLANC);
		this.plateau.echiq[2][6].setEstOccupe(Param.BLANC);
		this.jA.tbPiece[3] = new Pion(3,6,"/img/pionB.gif",Param.BLANC);
		this.plateau.echiq[3][6].setEstOccupe(Param.BLANC);
		this.jA.tbPiece[4] = new Pion(4,6,"/img/pionB.gif",Param.BLANC);
		this.plateau.echiq[4][6].setEstOccupe(Param.BLANC);
		this.jA.tbPiece[5] = new Pion(5,6,"/img/pionB.gif",Param.BLANC);
		this.plateau.echiq[5][6].setEstOccupe(Param.BLANC);
		this.jA.tbPiece[6] = new Pion(6,6,"/img/pionB.gif",Param.BLANC);
		this.plateau.echiq[6][6].setEstOccupe(Param.BLANC);
		this.jA.tbPiece[7] = new Pion(7,6,"/img/pionB.gif",Param.BLANC);
		this.plateau.echiq[7][6].setEstOccupe(Param.BLANC);
		
		this.jA.tbPiece[8] = new Cavalier(1,7,"/img/cavalierB.gif",Param.BLANC);
		this.plateau.echiq[1][7].setEstOccupe(Param.BLANC);
		this.jA.tbPiece[9] = new Cavalier(6,7,"/img/cavalierB.gif",Param.BLANC);
		this.plateau.echiq[6][7].setEstOccupe(Param.BLANC);
		this.jA.tbPiece[10] = new Tour(0,7,"/img/tourB.gif",Param.BLANC);
		this.plateau.echiq[0][7].setEstOccupe(Param.BLANC);
		this.jA.tbPiece[11] = new Tour(7,7,"/img/tourB.gif",Param.BLANC);
		this.plateau.echiq[7][7].setEstOccupe(Param.BLANC);
		this.jA.tbPiece[12] = new Fou(2,7,"/img/fouB.gif",Param.BLANC);
		this.plateau.echiq[2][7].setEstOccupe(Param.BLANC);
		this.jA.tbPiece[13] = new Fou(5,7,"/img/fouB.gif",Param.BLANC);
		this.plateau.echiq[5][7].setEstOccupe(Param.BLANC);
		this.jA.tbPiece[14] = new Roi(4,7,"/img/roiB.gif",Param.BLANC);
		this.plateau.echiq[3][7].setEstOccupe(Param.BLANC);
		this.jA.tbPiece[15] = new Reine(3,7,"/img/reineB.gif",Param.BLANC);
		this.plateau.echiq[4][7].setEstOccupe(Param.BLANC);
		
		// Initialisation pièces noires
		this.jB.tbPiece[0] = new Pion(0,1,"/img/pionN.gif",Param.NOIR);
		this.plateau.echiq[0][1].setEstOccupe(Param.NOIR);
		this.jB.tbPiece[1] = new Pion(1,1,"/img/pionN.gif",Param.NOIR);
		this.plateau.echiq[1][1].setEstOccupe(Param.NOIR);
		this.jB.tbPiece[2] = new Pion(2,1,"/img/pionN.gif",Param.NOIR);
		this.plateau.echiq[2][1].setEstOccupe(Param.NOIR);
		this.jB.tbPiece[3] = new Pion(3,1,"/img/pionN.gif",Param.NOIR);
		this.plateau.echiq[3][1].setEstOccupe(Param.NOIR);
		this.jB.tbPiece[4] = new Pion(4,1,"/img/pionN.gif",Param.NOIR);
		this.plateau.echiq[4][1].setEstOccupe(Param.NOIR); 
		this.jB.tbPiece[5] = new Pion(5,1,"/img/pionN.gif",Param.NOIR);
		this.plateau.echiq[5][1].setEstOccupe(Param.NOIR);
		this.jB.tbPiece[6] = new Pion(6,1,"/img/pionN.gif",Param.NOIR);
		this.plateau.echiq[6][1].setEstOccupe(Param.NOIR);
		this.jB.tbPiece[7] = new Pion(7,1,"/img/pionN.gif",Param.NOIR);
		this.plateau.echiq[7][1].setEstOccupe(Param.NOIR);
		
		this.jB.tbPiece[8] = new Cavalier(1,0,"/img/cavalierN.gif",Param.NOIR);
		this.plateau.echiq[1][0].setEstOccupe(Param.NOIR);
		this.jB.tbPiece[9] = new Cavalier(6,0,"/img/cavalierN.gif",Param.NOIR);
		this.plateau.echiq[6][0].setEstOccupe(Param.NOIR);
		this.jB.tbPiece[10] = new Tour(0,0,"/img/tourN.gif",Param.NOIR);
		this.plateau.echiq[0][0].setEstOccupe(Param.NOIR);
		this.jB.tbPiece[11] = new Tour(7,0,"/img/tourN.gif",Param.NOIR);
		this.plateau.echiq[7][0].setEstOccupe(Param.NOIR);
		this.jB.tbPiece[12] = new Fou(2,0,"/img/fouN.gif",Param.NOIR);
		this.plateau.echiq[2][0].setEstOccupe(Param.NOIR);
		this.jB.tbPiece[13] = new Fou(5,0,"/img/fouN.gif",Param.NOIR);
		this.plateau.echiq[5][0].setEstOccupe(Param.NOIR);
		this.jB.tbPiece[14] = new Roi(4,0,"/img/roiN.gif",Param.NOIR);
		this.plateau.echiq[4][0].setEstOccupe(Param.NOIR);
		this.jB.tbPiece[15] = new Reine(3,0,"/img/reineN.gif",Param.NOIR);
		this.plateau.echiq[3][0].setEstOccupe(Param.NOIR);
		
		for (int i=0;i<Echiquier.NLIGNES;i++){
			for (int j=0;j<Echiquier.NLIGNES;j++){
				this.plateau.echiq[i][j].actions(this);
			}
		}
		
		this.plateau.actualiser(this.jA, this.jB);
		this.plateau.setVisible(true);
		this.settings.setJoueurActuel(1);
	}
	
	/**
	 * Le tour d'un joueur
	 * @param joueur dont c'est le tour
	 */
	public void tour(Joueur joueur) {
		
		Param.clic = 0;
		
		Position workS[] = new Position[Joueur.NBPIECE];
		
		workS = joueur.genererSelect(this.plateau);
		Partie.setjEnCours(joueur);
		
		
		this.plateau.showPieceChoice(workS);
		
		//Partie.getjEnCours().fairePromotion();
		
		
		if (this.settings.getJoueurActuel() == 1) Partie.setjEnCours(this.jA);
		else Partie.setjEnCours(this.jB);
		
		Partie.getjEnCours().estEchec(this);
		
		if (this.estEnd()) this.finPartie();
		
	}
	
	
	/**
	 * finPartie, permet de mettre fin à une partie
	 */
	public void finPartie() {
		JFrame winEnd = new FenFinPartie(this);
		winEnd.setVisible(true);
	}
	
	public boolean estEnd() {
		if (!Partie.getjEnCours().tbPiece[14].isInGame()) return true;
		if (Partie.getjEnCours().estMat(this)) return true;
		if (this.estPat()) return true;
		
		return false;
	}
	
	/**
	 * Fait un scan des deux tableaux de pièces pour savoir si c'est Pat (égalité, si chacun n'a qu'un pion et le roi en jeu)
	 * @return un boolean qui est true si c'est pat
	 */
	public boolean estPat(){
		int nbPionsA=0;
		int nbPionsB=0;
		for (int i=0;i<8;i++){
			if (this.jA.tbPiece[i].isInGame()) nbPionsA++;
			if (this.jB.tbPiece[i].isInGame()) nbPionsB++;
		}
		if (nbPionsA > 1 || nbPionsB > 1) return false;
		for (int i=8;i<16;i++){
			if (this.jA.tbPiece[i].isInGame() && i!=14) return false;
			if (this.jB.tbPiece[i].isInGame() && i!=14) return false;
		}
		return true;
	}
	
	//GETTERS & SETTERS
	
	public static Joueur getjEnCours() {
		return jEnCours;
	}

	public static void setjEnCours(Joueur jEnCours) {
		Partie.jEnCours = jEnCours;
	}
	
	public Joueur getJA() {
		return jA;
	}
	
	public Joueur getJB() {
		return jB;
	}

}