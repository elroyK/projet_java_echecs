package be.ephec.echecs.jeu;

import be.ephec.echecs.gui.FenPromotion;

/**
 * Classe Pion, représentant la pièce Pion
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 25/11/14
 * date de modification : 03/12/14
 */

public class Pion extends Piece {
	final static int NBMOV = 2;
	protected boolean dejaJoue;
	
	/**
	 * Constructeur de la classe Pion
	 * @param x : position en x
	 * @param y : position en y
	 * @param addImage : adresse de l'image du pion
	 */
	
	public Pion(int x, int y, String addImage, String color) {
		super("Pion",addImage,true,x,y, color);
		setDejaJoue(false);
	}
	
	/**
	 * genererPos : créer un tableau de position possible pour le pion en fonction des cases de l'échiquier
	 * @param : plateau : l'échiquier
	 * @return : un tableau de position possible par le pion
	 */
	
	public Position[] genererPos(Echiquier plateau, String isSameTeam) {
		
		Position work[] = new Position[NBMOV];
		
		for (int i=0;i<NBMOV;i++) work[i] = new Position(8,8);
		
		if (isSameTeam==Param.BLANC) {
			String isBusy = plateau.echiq[this.pos.getX()][this.pos.getY()-1].estOccupe;
			if (isBusy==Param.LIBRE){
				return work;
			}
			work[0].setX(this.pos.getX());
			work[0].setY(this.pos.getY()-1);
			if (!this.isDejaJoue()) {
				work[1].setX(this.pos.getX());
				work[1].setY(this.pos.getY()-2);
				setDejaJoue(true);
			}		
		} else {
			String isBusy = plateau.echiq[this.pos.getX()][this.pos.getY()+1].estOccupe;
			if (!isBusy.equals(Param.LIBRE)){
				return work;
			}
			work[0].setX(this.pos.getX());
			work[0].setY(this.pos.getY()+1);
			if (!this.isDejaJoue()) {
				work[1].setX(this.pos.getX());
				work[1].setY(this.pos.getY()+2);
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
	
	public String[] promotion(String jCol, Joueur j) {
		String[] work = new String[8]; // Tableau de string représentant le nom des pièces mortes
		int iWork =0;
		if (jCol==Param.NOIR) {
			if (this.pos.getY()==0) {
				this.setInGame(false);
				for (int i=0;i<j.tbPiece.length;i++) {
					if (!j.tbPiece[i].isInGame()) {
						if (!(j.tbPiece[i].getNom()=="Pion")) {
						work[iWork] = j.tbPiece[i].getNom();
						}
					}
				}			
			}
		} else {
			if (this.pos.getY()==8) {
				this.setInGame(false);
				for (int i=0;i<j.tbPiece.length;i++) {
					if (!j.tbPiece[i].isInGame()) {
						if (!(j.tbPiece[i].getNom()=="Pion")) {
						work[iWork] = j.tbPiece[i].getNom();
						}
					}
				}
			}
		}
		return work;	
	}
	
	/**
	 * prisePassant  : un pion peut prendre la pièce qui se trouve
	 * @param plateau : l'échiquier pour savoir si la case est occupée
	 * @return la position ou le pion peut se déplacer en prendre une pièce en passant
	 */
	
	public Position prisePassant(Echiquier plateau) {
		Position work = new Position(8,8);
		
		if ((plateau.echiq[this.pos.getX()+1][this.pos.getY()].getEstOccupe() != Param.LIBRE) && 
			 (plateau.echiq[this.pos.getX()+1][this.pos.getY()].getEstOccupe()!=this.getColor())) {
			if (this.getColor()==Param.BLANC) {
				work.setX(this.pos.getX()+1);
				work.setY(this.pos.getY()+1);
			} else {
				work.setX(this.pos.getX()+1);
				work.setY(this.pos.getY()-1);
			}
			return work;
		}
		
		if ((plateau.echiq[this.pos.getX()-1][this.pos.getY()].getEstOccupe() != Param.LIBRE) && 
			(plateau.echiq[this.pos.getX()-1][this.pos.getY()].getEstOccupe()!=this.getColor())) {
			if (this.getColor()==Param.BLANC) {
				work.setX(this.pos.getX()-1);
				work.setY(this.pos.getY()+1);
			} else {
				work.setX(this.pos.getX()-1);
				work.setY(this.pos.getY()-1);
			}
				return work;
			}
		
		return work;
	}

	/* GETTERS ET SETTERS */
	public boolean isDejaJoue() {
		return dejaJoue;
	}

	public void setDejaJoue(boolean dejaJoue) {
		this.dejaJoue = dejaJoue;
	}
	
}
