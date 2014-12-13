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
		
		Fou f = new Fou(this.pos.getX(),this.pos.getY(),"","");
		Tour t = new Tour(this.pos.getX(),this.pos.getY(),"","");
		
		work1 = f.genererPos(plateau, isSameTeam);
		work2 = t.genererPos(plateau, isSameTeam);
		
		Position work[] = new Position[NBMOV];
		
		// FUSION DES DEUX
		int c=0;		
		int i=0;
		
		for (i=0;i<work1.length;i++){
			work[c]=work1[i];
			c++;
		}
		
		for (i=0;i<work2.length;i++){
			work[c]=work2[i];
			c++;
		}
		
		Position finalWork[] = new Position[c];
		for (int j=0;j<c;j++){
			finalWork[i] = work[i];
		}
		
		return finalWork; 	
	}
}