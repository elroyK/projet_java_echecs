package be.ephec.echecs.jeu;
/**
 * Classe Tour, représentant la pièce Tour
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 26/11/14
 * date de modification : 04/12/14
 */

public class Tour extends Piece {
	final static int NBMOV = 14;
	
	protected boolean estRoquable;

	public Tour() {
		super();
	}

	/**
	 * Constructeur de la classe Tour
	 * @param x : position en x
	 * @param y : position en y
	 * @param addImage : adresse de l'image
	 */
	
	public Tour (int x, int y, String addImage, String color) {
		super("Tour",addImage,true,x,y,color);
		this.setEstRoquable(true);
	}
	
	/**
	 * genererPos : créer un tableau de position possible pour la tour en fonction des cases de l'échiquier
	 * @param : plateau : l'échiquier
	 * @return : un tableau de position possible par la tour
	 */

	public Position[] genererPos(Echiquier plateau, String isSameTeam){
		
		Position work [] = new Position[NBMOV];
		for (int i=0; i<NBMOV; i++) work[i]=new Position(8,8);
		int tempX;
		int tempY;
		int c = 0;
		
		for (int i=-1;i<=1;i++){
			for (int j=-1;j<=1;j++){
				if (Math.abs(i)!=Math.abs(j)){
					tempX = pos.getX()+i;
					tempY = pos.getY()+j;
					while(tempX <= 7
							&& tempX >= 0
							&& tempY <= 7
							&& tempY >= 0
							&& !(plateau.echiq[tempX][tempY].getEstOccupe()==isSameTeam)){
						work[c].setX(tempX);
						work[c].setY(tempY);
						tempX += i;
						tempY += j;
						c++;
					}
				}
			}
		}	
		Position finalWork[] = new Position[c];
		for (int i=0;i<c;i++) finalWork[i] = work[i];
		
		return finalWork;
	}
	
	// GETTERS ET SETTERS
	
	public boolean isEstRoquable() {
		return estRoquable;
	}

	public void setEstRoquable(boolean estRoquable) {
		this.estRoquable = estRoquable;
	}
}

