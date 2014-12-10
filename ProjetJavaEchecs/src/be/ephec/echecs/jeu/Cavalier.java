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
		
		int i=0;
		
		if ((((this.pos.getX()+1)>7)||((this.pos.getY()+2)>7))
				||(plateau.echiq[this.pos.getX()+1][this.pos.getY()+2].estOccupe == isSameTeam)) {
			work[i]=null;
			i++;
		}
		else {
			work[i].setX(this.pos.getX()+1);
			work[i].setY(this.pos.getY()+2);
			i++;
		}
		
		if ((((this.pos.getX()+1)>7)||((this.pos.getY()-2)<0))
				||(plateau.echiq[this.pos.getX()+1][this.pos.getY()-2].estOccupe == isSameTeam)) {
			work[i]=null;
			i++;
		}
		else {
			work[i].setX(this.pos.getX()+1);
			work[i].setY(this.pos.getY()-2);
			i++;
		}
		
		if ((((this.pos.getX()+2)>7)||((this.pos.getY()+1)>7))
				||(plateau.echiq[this.pos.getX()+2][this.pos.getY()+1].estOccupe == isSameTeam)) {
			work[i]=null;
			i++;
		}
		else{		
			work[i].setX(this.pos.getX()+2);
			work[i].setY(this.pos.getY()+1);
			i++;
		}
		
		if ((((this.pos.getX()+2)>7)||((this.pos.getY()-1)<0))
				||(plateau.echiq[this.pos.getX()+2][this.pos.getY()-1].estOccupe == isSameTeam)) {
			work[i]=null;
			i++;
		}
		else {
			work[i].setX(this.pos.getX()+2);
			work[i].setY(this.pos.getY()-1);
			i++;
		}
		
		if ((((this.pos.getX()-1)<0)||((this.pos.getY()+2)>0))
				||(plateau.echiq[this.pos.getX()-1][this.pos.getY()+2].estOccupe == isSameTeam)) {
			work[4]=null;
			i++;
		}
		else {
			work[i].setX(this.pos.getX()-1);
			work[i].setY(this.pos.getY()+2);
			i++;
		}
		
		if ((((this.pos.getX()-1)<0)||((this.pos.getY()-2)<0))
				||(plateau.echiq[this.pos.getX()-1][this.pos.getY()-2].estOccupe == isSameTeam)) {
			work[i]=null;
			i++;
		}
		else {
			work[i].setX(this.pos.getX()-1);
			work[i].setY(this.pos.getY()-2);
			i++;
		}
		
		if ((((this.pos.getX()-2)<0)||((this.pos.getY()+1)>7))
				||(plateau.echiq[this.pos.getX()-2][this.pos.getY()+1].estOccupe == isSameTeam)) {
			work[i]=null;
			i++;
		}
		else {
			work[i].setX(this.pos.getX()-2);
			work[i].setY(this.pos.getY()+1);
			i++;
		}
		
		if ((((this.pos.getX()-2)<0)||((this.pos.getY()-1)<0))
				||(plateau.echiq[this.pos.getX()-2][this.pos.getY()-1].estOccupe == isSameTeam)) {
			work[i]=null;
			i++;
		}
		else {
			work[i].setX(this.pos.getX()-2);
			work[i].setY(this.pos.getY()-1);
			i++;
		}
			
		return work; 	
	}
}