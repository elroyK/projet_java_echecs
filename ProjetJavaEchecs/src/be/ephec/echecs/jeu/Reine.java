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
	
	public Reine (int x, int y, String addImage, String color) {
		super("Reine",addImage,true,x,y,color);
	}
	
	/**
	 * genererPos : créer un tableau de position possible pour la reine en fonction des cases de l'échiquier
	 * @param : plateau : l'échiquier
	 * @return : un tableau de position possible par la reine
	 */
	
	public Position[] genererPos(Echiquier plateau, String isSameTeam) {
		Position work1[] = new Position[NBMOV/2];
		Position work2[] = new Position[NBMOV/2];
		
		for (int i=0;i<NBMOV/2;i++){
			work1[i]=new Position();
			work2[i]=new Position();
		}
		
		work1 = f.genererPos(plateau, isSameTeam);
		work2 = t.genererPos(plateau, isSameTeam);
		
		Position work[] = new Position[NBMOV];
		
		for (int i=0;i<NBMOV;i++)
			work[i]=new Position();
		
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