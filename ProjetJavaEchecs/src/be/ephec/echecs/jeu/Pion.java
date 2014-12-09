package be.ephec.echecs.jeu;
/**
 * Classe Pion, représentant la pièce Pion
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 25/11/14
 * date de modification : 03/12/14
 */

public class Pion extends Piece {
	private boolean dejaJoue;

	private static String COULNOIR = "noir";
	
	/**
	 * Constructeur de la classe Pion
	 * @param x : position en x
	 * @param y : position en y
	 * @param addImage : adresse de l'image du pion
	 */
	public Pion(int x, int y, String addImage) {
		super("Pion",addImage,true,x,y);
		setDejaJoue(false);
	}
	
	/**
	 * @return : un tableau de position possible par le pion
	 */
	
	public Position[] genererPos(Echiquier plateau) {
		
		Position work[] = new Position[2];
		
		if (this.getColor() == Param.BLANC) {
			String isBusy = plateau.echiq[this.pos.getX()][this.pos.getY()+1].estOccupe;
			if (isBusy != Param.LIBRE){
				work[0] = null;
				return work;
			}
			work[0].setY(this.pos.getY()+1);
			if (this.isDejaJoue()) {
				work[1].setY(this.pos.getY()+2);
				setDejaJoue(true);
			}		
		} else {
			String isBusy = plateau.echiq[this.pos.getX()][this.pos.getY()-1].estOccupe;
			if (isBusy != Param.LIBRE){
				work[0] = null;
				return work;
			}
			work[0].setY(this.pos.getY()-1);
			if (this.isDejaJoue()) {
				work[1].setY(this.pos.getY()-2);
				setDejaJoue(true);
			}
		}
		
		return work;
	}
	
	/**
	 * Permet de promouvoir un pion en n'importe quel pièce "morte"
	 * @param jCol : Couleur du joueur (noir ou blanc)
	 * Si c'est joueur noir => les pièces descendent
	 * Si c'est joueur blanc => les pièces montent
	 */
	public void promotion(String jCol) {
		if (jCol==COULNOIR) {
			if (this.pos.getY()==0) {
				this.setInGame(false);
				// TODO : Implementer la méthode
				/*
				 * Trouver toutes les pièces mortes
				 * Proposer dans une liste déroulante les pièces disponible pour la promotion
				 * Création de la pièce choisie
				 * On place la pièce sur l'échiquier mais ou ??
				 */
			}
		} else {
			if (this.pos.getY()==8) {
				this.setInGame(false);
				// TODO : Implementer la méthode
			}
		}
	}
	
	public void prisePassant() {
		// TODO : implémenter la méthode
	}

	/* GETTERS ET SETTERS */
	public boolean isDejaJoue() {
		return dejaJoue;
	}

	public void setDejaJoue(boolean dejaJoue) {
		this.dejaJoue = dejaJoue;
	}
	
}
