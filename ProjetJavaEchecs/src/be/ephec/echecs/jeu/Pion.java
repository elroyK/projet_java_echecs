package be.ephec.echecs.jeu;

import be.ephec.echecs.gui.FenPromotion;

/**
 * Classe Pion, repr�sentant la pi�ce Pion
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de cr�ation : 25/11/14
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
	 * genererPos : cr�er un tableau de position possible pour le pion en fonction des cases de l'�chiquier
	 * @param : plateau : l'�chiquier
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
	 * Permet de promouvoir un pion en n'importe quel pi�ce "morte"
	 * @param jCol : Couleur du joueur (noir ou blanc)
	 * Si c'est joueur noir => les pi�ces descendent
	 * Si c'est joueur blanc => les pi�ces montent
	 */
	
	public String[] promotion(String jCol, Joueur j) {
		String[] work = new String[8]; // Tableau de string repr�sentant le nom des pi�ces mortes
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
	 * prisePassant  : un pion peut prendre la pi�ce qui se trouve
	 * @param plateau : l'�chiquier pour savoir si la case est occup�e
	 * @return la position ou le pion peut se d�placer en prendre une pi�ce en passant
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
