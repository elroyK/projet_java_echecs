package be.ephec.echecs.jeu;
/**
 * Classe Cavalier, représentant la pièce Cavalier
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 26/11/14
 * date de modification : 02/12/14
 */

public class Cavalier extends Piece {
	final static int NBMOV = 8;
	
	/**
	 * Constructeur de la classe Cavalier
	 * @param x : position en x
	 * @param y : position en y
	 * @param addImage : adresse de l'image du pion
	 */
	
	public Cavalier(int x, int y, String addImage) {
		super("Cavalier",addImage,true,x,y);
	}

	public Position[] genererPos(Echiquier plateau) {
		Position work[] = new Position[NBMOV];
		
		String isSameTeam = plateau.echiq[this.pos.getX()][this.pos.getY()].getEstOccupe();
		
		if ((((this.pos.getX()+1)>7)||((this.pos.getY()+2)>7))
				||(plateau.echiq[this.pos.getX()+1][this.pos.getX()+2].estOccupe == isSameTeam)) work[0]=null;
		else {
			work[0].setX(this.pos.getX()+1);
			work[0].setY(this.pos.getY()+2);
		}
		
		if ((((this.pos.getX()+1)>7)||((this.pos.getY()-2)<0))
				||(plateau.echiq[this.pos.getX()+1][this.pos.getX()-2].estOccupe == isSameTeam)) work[1]=null;
		else {
			work[1].setX(this.pos.getX()+1);
			work[1].setY(this.pos.getY()-2);
		}
		
		if ((((this.pos.getX()+2)>7)||((this.pos.getY()+1)>7))
				||(plateau.echiq[this.pos.getX()+2][this.pos.getX()+1].estOccupe == isSameTeam)) work[2]=null;
		else{		
			work[2].setX(this.pos.getX()+2);
			work[2].setY(this.pos.getY()+1);
		}
		
		if ((((this.pos.getX()+2)>7)||((this.pos.getY()-1)<0))
				||(plateau.echiq[this.pos.getX()+2][this.pos.getX()-1].estOccupe == isSameTeam)) work[3]=null;
		else {
			work[3].setX(this.pos.getX()+2);
			work[3].setY(this.pos.getY()-1);
		}
		
		if ((((this.pos.getX()-1)<0)||((this.pos.getY()+2)>0))
				||(plateau.echiq[this.pos.getX()-1][this.pos.getX()+2].estOccupe == isSameTeam)) work[4]=null;
		else {
			work[4].setX(this.pos.getX()-1);
			work[4].setY(this.pos.getY()+2);
		}
		
		if ((((this.pos.getX()-1)<0)||((this.pos.getY()-2)<0))
				||(plateau.echiq[this.pos.getX()-1][this.pos.getX()-2].estOccupe == isSameTeam)) work[5]=null;
		else {
			work[5].setX(this.pos.getX()-1);
			work[5].setY(this.pos.getY()-2);
		}
		
		if ((((this.pos.getX()-2)<0)||((this.pos.getY()+1)>7))
				||(plateau.echiq[this.pos.getX()-2][this.pos.getX()+1].estOccupe == isSameTeam)) work[6]=null;
		else {
			work[6].setX(this.pos.getX()-2);
			work[6].setY(this.pos.getY()+1);
		}
		
		if ((((this.pos.getX()-2)<0)||((this.pos.getY()-1)<0))
				||(plateau.echiq[this.pos.getX()-2][this.pos.getX()-1].estOccupe == isSameTeam)) work[7]=null;
		else {
			work[7].setX(this.pos.getX()-2);
			work[7].setY(this.pos.getY()-1);
		}
			
		return work; 	
	}
}