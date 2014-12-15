package be.ephec.echecs.jeu;

/**
 * Classe Pion, repr�sentant la pi�ce Pion
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de cr�ation : 25/11/14
 * date de modification : 03/12/14
 */

public class Pion extends Piece {
	final static int NBMOV = 4;
	
	/**
	 * Constructeur de la classe Pion
	 * @param x : position en x
	 * @param y : position en y
	 * @param addImage : adresse de l'image du pion
	 */
	
	public Pion(int x, int y, String addImage, String color) {
		super("Pion",addImage,true,x,y, color);
	}
	
	/**
	 * genererPos : cr�er un tableau de position possible pour le pion en fonction des cases de l'�chiquier
	 * @param : plateau : l'�chiquier
	 * @return : un tableau de position possible par le pion
	 */
	
public Position[] genererPos(Echiquier plateau, String isSameTeam) {
		
		Position work[] = new Position[NBMOV];
		int n = 0;
		
		//for (int i=0;i<NBMOV;i++) work[i] = new Position();
		
		if (isSameTeam==Param.BLANC) {
			String isBusy = plateau.echiq[this.pos.getX()][this.pos.getY()-1].getEstOccupe();
			if (isBusy==Param.LIBRE){
				work[n] = new Position(this.pos.getX(),this.pos.getY()-1) ;
				n++;
				if (!this.isDejaJoue()) {
					work[n] = new Position(this.pos.getX(),this.pos.getY()-2) ;
					n++;
				}
			}
			for (int w=-1; w<=1; w++){
				if (w!=0 && this.pos.getX()>0 && this.pos.getX()<7){
					if (this.pos.getX()+w>=0
							&& this.pos.getX()+w<=7
							&& plateau.echiq[this.pos.getX()+w][this.pos.getY()-1].getEstOccupe() == Param.NOIR){
						work[n] = new Position(this.pos.getX()+w, this.pos.getY()-1);
						n++;
					}
				}
			}
			
		/*	if (this.prisePassant(plateau)==(new Position())) {
				work[2] = this.prisePassant(plateau);
			}*/
			
		} else {
			String isBusy = plateau.echiq[this.pos.getX()][this.pos.getY()+1].getEstOccupe();
			if (isBusy==Param.LIBRE){
				work[n] = new Position(this.pos.getX(),this.pos.getY()+1) ;
				n++;
				if (!this.isDejaJoue()) {
					work[n] = new Position(this.pos.getX(),this.pos.getY()+2) ;
					n++;
				}
			}
			for (int w=-1; w<=1; w++){
				if (w!=0 && this.pos.getX()>=0 && this.pos.getX()<=7){
					if (this.pos.getX()+w>=0
							&& this.pos.getX()+w<=7
							&& plateau.echiq[this.pos.getX()+w][this.pos.getY()+1].getEstOccupe() == Param.BLANC){
						work[n] = new Position(this.pos.getX()+w, this.pos.getY()+1);
						n++;
					}
				}
			}
			
			/*if (this.prisePassant(plateau)!=(new Position())) {
				work[2] = this.prisePassant(plateau);
			}*/
		}
		
		Position finalWork[] = new Position[n];
		for (int i=0;i<n;i++) {
			if (work[i].getX()<0) return new Position[0];
			finalWork[i]=work[i];
		}
		
		return finalWork;
	}
	
	/**
	 * Permet de promouvoir un pion en n'importe quel pi�ce "morte"
	 * @param jCol : Couleur du joueur (noir ou blanc)
	 * Si c'est joueur noir => les pi�ces descendent
	 * Si c'est joueur blanc => les pi�ces montent
	 */
	
	public String[] promotion(String jCol, Joueur j) {
		String[] work = new String[8]; // Tableau de string repr�sentant le nom des pi�ces mortes
		int iWork =0;
		if (jCol==Param.NOIR) {
			if (this.pos.getY()==0) {
				this.setInGame(false);
				for (int i=0;i<j.tbPiece.length;i++) {
					if (!j.tbPiece[i].isInGame()) {
						if (!(j.tbPiece[i].getNom()=="Pion")) {
						work[iWork] = j.tbPiece[i].getNom();
						}
					}
				}			
			}
		} else {
			if (this.pos.getY()==8) {
				this.setInGame(false);
				for (int i=0;i<j.tbPiece.length;i++) {
					if (!j.tbPiece[i].isInGame()) {
						if (!(j.tbPiece[i].getNom()=="Pion")) {
						work[iWork] = j.tbPiece[i].getNom();
						}
					}
				}
			}
		}
		return work;	
	}
	
	/**
	 * prisePassant  : un pion peut prendre la pi�ce qui se trouve
	 * @param plateau : l'�chiquier pour savoir si la case est occup�e
	 * @return la position ou le pion peut se d�placer en prendre une pi�ce en passant
	 */
	
	public Position prisePassant(Echiquier plateau) {
		Position work = new Position();
		
		if ((plateau.echiq[this.pos.getX()+1][this.pos.getY()].getEstOccupe() != Param.LIBRE) && 
			 (plateau.echiq[this.pos.getX()+1][this.pos.getY()].getEstOccupe()!=this.getColor())) {
			if (this.getColor()==Param.BLANC) {
				work.setX(this.pos.getX()+1);
				work.setY(this.pos.getY()+1);
			} else {
				work.setX(this.pos.getX()+1);
				work.setY(this.pos.getY()-1);
			}
			return work;
		}
		
		if ((plateau.echiq[this.pos.getX()-1][this.pos.getY()].getEstOccupe() != Param.LIBRE) && 
			(plateau.echiq[this.pos.getX()-1][this.pos.getY()].getEstOccupe()!=this.getColor())) {
			if (this.getColor()==Param.BLANC) {
				work.setX(this.pos.getX()-1);
				work.setY(this.pos.getY()+1);
			} else {
				work.setX(this.pos.getX()-1);
				work.setY(this.pos.getY()-1);
			}
				return work;
			}
		
		return work;
	}
}
