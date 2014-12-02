package echecs.jeu;
/**
 * Classe Cavalier, représentant la pièce Cavalier
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 26/11/14
 * date de modification : 02/12/14
 */

public class Cavalier extends Piece {
	private static int NBMOV = 8;
	
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
		work[0].setX(this.pos.getX()+2);
		
		work[1].setX(this.pos.getX()+1);
		work[1].setX(this.pos.getX()-2);
		
		work[2].setX(this.pos.getX()+2);
		work[2].setX(this.pos.getX()+1);
		
		work[3].setX(this.pos.getX()+2);
		work[3].setX(this.pos.getX()-1);
		
		work[4].setX(this.pos.getX()-1);
		work[4].setX(this.pos.getX()+2);
		
		work[5].setX(this.pos.getX()-1);
		work[5].setX(this.pos.getX()-2);
		
		work[6].setX(this.pos.getX()-2);
		work[6].setX(this.pos.getX()+1);
		
		work[7].setX(this.pos.getX()-2);
		work[7].setX(this.pos.getX()-1);
		
		return work; 	
	}
	
	public void move() {
		Position tbPos[] = this.genererPos();
		boolean work[];
		for (int i=0;i<tbPos.length;i++) {
			// TODO : COMPARARER LES POSITIONS DU TABLEAU DE POSITION POSSIBLE
			//      : AVEC LES POSITIONS DES TABLEAU DE PIECES NOIRES ET BLANCHES 
			//      : POUR DEFINIR LES BOUTONS CLIQUABLES OU NON 
			//      : LE TABLEAU WORK S AJOUTE AU tbPos true : cliquable
			//                                          false: non cliquable
		}
	}