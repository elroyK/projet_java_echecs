package be.ephec.echecs.jeu;
/**
 * Classe Cavalier, repr�sentant la pi�ce Cavalier
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de cr�ation : 26/11/14
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

	public Position[] genererPos() {
		Position work[] = new Position[NBMOV];
		
		work[0].setX(this.pos.getX()+1);
		work[0].setX(this.pos.getY()+2);
		
		work[1].setX(this.pos.getX()+1);
		work[1].setX(this.pos.getY()-2);
		
		work[2].setX(this.pos.getX()+2);
		work[2].setX(this.pos.getY()+1);
		
		work[3].setX(this.pos.getX()+2);
		work[3].setX(this.pos.getY()-1);
		
		work[4].setX(this.pos.getX()-1);
		work[4].setX(this.pos.getY()+2);
		
		work[5].setX(this.pos.getX()-1);
		work[5].setX(this.pos.getY()-2);
		
		work[6].setX(this.pos.getX()-2);
		work[6].setX(this.pos.getY()+1);
		
		work[7].setX(this.pos.getX()-2);
		work[7].setX(this.pos.getY()-1);
		
		return work; 	
	}
}