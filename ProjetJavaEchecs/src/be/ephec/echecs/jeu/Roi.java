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
	
	public Roi (int x, int y, String addImage) {
		super("Cavalier",addImage,true,x,y);
	}
	
	public Position[] genererPos() {
		Position work[] = new Position[NBMOV];
		
		work[0].setX(this.pos.getX()+1);
		work[0].setX(this.pos.getY()-1);
		
		work[1].setX(this.pos.getX()+1);
		work[1].setX(this.pos.getY());
		
		work[2].setX(this.pos.getX()+1);
		work[2].setX(this.pos.getY()+1);
		
		work[3].setX(this.pos.getX());
		work[3].setX(this.pos.getY()-1);
		
		work[4].setX(this.pos.getX());
		work[4].setX(this.pos.getY()+1);
		
		work[5].setX(this.pos.getX()-1);
		work[5].setX(this.pos.getY()-1);
		
		work[6].setX(this.pos.getX()-1);
		work[6].setX(this.pos.getY());
		
		work[7].setX(this.pos.getX()-1);
		work[7].setX(this.pos.getY()+1);
		
		return work; 	
	}
	
	public void move(Echiquier plateau) {
		Position tbPos[] = this.genererPos();
		this.genererCaseCliquable(plateau, tbPos);
		// TODO : AFFICHER LES CASES DISPOBIBLES EN VERT
		// TODO : CHOPER LA POSITION CLIQUE PAR LE JOUEUR
		Position zone = new Position(0,0); // A IMPLEMENTER AVEC LA POSITION DU JOUEUR
		this.deplacement(plateau,zone);
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

