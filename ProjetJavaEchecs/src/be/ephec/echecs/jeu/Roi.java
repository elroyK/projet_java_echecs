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
	
	public Position[] genererPos(Echiquier plateau) {
		Position work[] = new Position[NBMOV];
		
		String isSameTeam = plateau.echiq[this.pos.getY()][this.pos.getX()].getEstOccupe();
		
		if(this.pos.getX()+1>7
				|| this.pos.getY()-1<0
				|| plateau.echiq[this.pos.getX()+1][this.pos.getY()-1].getEstOccupe() == isSameTeam)
			work[0]=null;
		else{
			work[0].setX(this.pos.getX()+1);
			work[0].setX(this.pos.getY()-1);
		}
		
		if(this.pos.getX()+1>7
				|| plateau.echiq[this.pos.getX()+1][this.pos.getY()].getEstOccupe() == isSameTeam)
			work[1]=null;
		else{
			work[1].setX(this.pos.getX()+1);
			work[1].setX(this.pos.getY());
		}
			
		if(this.pos.getX()+1>7
				|| this.pos.getY()+1>7
				|| plateau.echiq[this.pos.getX()+1][this.pos.getY()+1].getEstOccupe() == isSameTeam)
			work[2]=null;
		else{
			work[2].setX(this.pos.getX()+1);
			work[2].setX(this.pos.getY()+1);
		}
			
		if(this.pos.getY()-1<0
				|| plateau.echiq[this.pos.getX()][this.pos.getY()-1].getEstOccupe() == isSameTeam)
			work[3]=null;
		else{
			work[3].setX(this.pos.getX());
			work[3].setX(this.pos.getY()-1);
		}
			
		if(this.pos.getY()+1>7
				|| plateau.echiq[this.pos.getX()][this.pos.getY()+1].getEstOccupe() == isSameTeam)
			work[4]=null;
		else{
			work[4].setX(this.pos.getX());
			work[4].setX(this.pos.getY()+1);
		}
		
		if(this.pos.getX()-1<0
				|| this.pos.getY()-1<0
				|| plateau.echiq[this.pos.getX()-1][this.pos.getY()-1].getEstOccupe() == isSameTeam)
			work[5]=null;
		else{
			work[5].setX(this.pos.getX()-1);
			work[5].setX(this.pos.getY()-1);
		}
		
		if(this.pos.getX()-1<0
				|| plateau.echiq[this.pos.getX()-1][this.pos.getY()].getEstOccupe() == isSameTeam)
			work[6]=null;
		else{	
			work[6].setX(this.pos.getX()-1);
			work[6].setX(this.pos.getY());
		}
		
		if(this.pos.getX()-1<0
				|| this.pos.getY()+1>7
				|| plateau.echiq[this.pos.getX()-1][this.pos.getY()+1].getEstOccupe() == isSameTeam)
			work[7]=null;
		else{		
			work[7].setX(this.pos.getX()-1);
			work[7].setX(this.pos.getY()+1);
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

