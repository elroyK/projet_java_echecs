package be.ephec.echecs.jeu;

/**
 * Classe Roi, représentant le Roi
 * date de création : 25/11/14
 * date de modification : 15/12/14
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 */

public class Roi extends Piece {
	final static int NBMOV = 8;
	
	/**
	 * Constructeur de la classe Roi
	 * @param x : position en x sur l'échiquier
	 * @param y : position en y sur l'échiquier
	 * @param addImage : adresse de l'image représentant le Roi
	 * @param color : la couleur de la pièce
	 */
	
	public Roi (int x, int y, String addImage, String color) {
		super("Roi",addImage,true,x,y,color);
	}
	
	/**
	 * genererPos : créé un tableau de positions possibles pour le roi en fonction des cases de l'échiquier
	 * @param plateau : l'échiquier
	 * @return un tableau de position possible par le roi
	 */
	
	public Position[] genererPos(Echiquier plateau, String isSameTeam) {
		Position work[] = new Position[NBMOV];
		for (int i=0;i<NBMOV;i++)
			work[i]=new Position(8,8);
		
		int c=0;
		
		for (int i=-1;i<=1;i++){
			for (int j=-1;j<=1;j++){
				int xW = this.pos.getX()+i;
				int yW = this.pos.getY()+j;
				if (!(i==0 && i==j)
						&& xW >= 0
						&& xW <= 7
						&& yW >= 0
						&& yW <= 7
						&& !(plateau.echiq[xW][yW].getEstOccupe()==isSameTeam)){
					work[c].setX(xW);
					work[c].setY(yW);
					c++;
				}
			}
		}
		
		Position finalWork[] = new Position[c];
		for (int i=0;i<c;i++) {
			finalWork[i]=work[i];
		}
		return finalWork; 	
	}
	
}

