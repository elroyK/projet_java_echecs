package be.ephec.echecs.jeu;
/**
 * Classe Reine, représentant la pièce Reine
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 26/11/14
 * date de modification : 03/12/14
 */

public class Reine extends Piece {
	final static int NBMOV = 28;
	
	// UNE REINE EST UN FOU ET UNE TOUR EN MEME TEMPS POUR SE DEPLACER
	private Fou f = new Fou();
	private Tour t = new Tour();
	
	/**
	 * Constructeur de la classe Fou
	 * @param x : position en x
	 * @param y : position en y
	 * @param addImage : adresse de l'image
	 */
	
	public Reine (int x, int y, String addImage) {
		super("Reine",addImage,true,x,y);
	}
	
	public Position[] genererPos(Echiquier plateau) {
		Position work1[] = new Position[NBMOV/2];
		Position work2[] = new Position[NBMOV/2];
		work1 = f.genererPos(plateau);
		work2 = t.genererPos(plateau);
		
		Position work[] = new Position[NBMOV];
		
		// FUSION DES DEUX
		for (int i=0;i<NBMOV;i++) {
			if (i<NBMOV/2) {
				work[i] = work1[i];
			} else {
				work[i] = work2[i-NBMOV/2];
			}
		}
		return work; 	
	}
}