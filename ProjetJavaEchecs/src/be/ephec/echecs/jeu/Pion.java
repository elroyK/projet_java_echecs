package be.ephec.echecs.jeu;

/**
 * Classe Pion, représentant la pièce Pion
 * date de création : 25/11/14
 * date de modification : 15/12/14
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
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
	 * genererPos : créé un tableau de positions possibles pour le pion en fonction des cases de l'échiquier
	 * @param : plateau : l'échiquier
	 * @return : un tableau de positions possibles par le pion
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
		}
		
		Position finalWork[] = new Position[n];
		for (int i=0;i<n;i++) {
			if (work[i].getX()<0) return new Position[0];
			finalWork[i]=work[i];
		}
		
		return finalWork;
	}
	
	/**
	 * Permet de promouvoir un pion en n'importe quelle pièce "morte"
	 * @param j : Le joueur à qui on va promouvoir
	 * @return : La liste des pièces mortes
	 */
	
	public String[] promotion(Joueur j) {
		String[] work = new String[8]; // Tableau de string représentant le nom des pièces mortes
		int iWork =0;
		if (j.getCouleur()==Param.NOIR) {
			if (this.pos.getY()==0) {
				this.setInGame(false);
				for (int i=0;i<j.tbPiece.length;i++) {
					if (!j.tbPiece[i].isInGame()) {
						if (!(j.tbPiece[i].getNom()=="Pion")) {
						work[iWork] = j.tbPiece[i].getNom();
						iWork++;
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
}
