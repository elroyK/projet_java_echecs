package be.ephec.echecs.jeu;
/**
 * Classe Roi, représentant le Roi
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 25/11/14
 * date de modification : 03/12/14
 */

public class Roi extends Piece {
	final static int NBMOV = 8;
	
	protected boolean estEchec;
	protected boolean estMat;
	protected boolean estRoquable;
	
	/**
	 * Constructeur de la classe Roi
	 * @param x : position en x sur l'échiquier
	 * @param y : position en y sur l'échiquier
	 * @param addImage : adresse de l'image du bouton
	 */
	
	public Roi (int x, int y, String addImage, String color) {
		super("Roi",addImage,true,x,y,color);
	}
	
	/**
	 * genererPos : créer un tableau de position possible pour le roi en fonction des cases de l'échiquier
	 * @param : plateau : l'échiquier
	 * @return : un tableau de position possible par le roi
	 */
	
	public Position[] genererPos(Echiquier plateau, String isSameTeam) {
		Position work[] = new Position[NBMOV];
		for (int i=0;i<NBMOV;i++)
			work[i]=new Position(8,8);
		
		int c=0;
		
		for (int i=-1;i<=1;i++){
			for (int j=-1;j<=1;j++){
				if (!(i==0 && i==j)
						&& this.pos.getX()+i >= 0
						&& this.pos.getX()+i <= 7
						&& this.pos.getY()+j >= 0
						&& this.pos.getY()+j <= 7
						&& !(plateau.echiq[this.pos.getX()+i][this.pos.getY()+j].getEstOccupe()==isSameTeam)){
							work[c].setX(this.pos.getX()+i);
							work[c].setY(this.pos.getY()+j);
							c++;
				}
			}
		}	
		return work; 	
	}
	
	// GETTERS ET SETTERS

	public boolean isEstEchec() {
		return estEchec;
	}

	public void setEstEchec(boolean estEchec) {
		this.estEchec = estEchec;
	}

	public boolean isEstMat() {
		return estMat;
	}

	public void setEstMat(boolean estMat) {
		this.estMat = estMat;
	}

	public boolean isEstRoquable() {
		return estRoquable;
	}

	public void setEstRoquable(boolean estRoquable) {
		this.estRoquable = estRoquable;
	}
}

