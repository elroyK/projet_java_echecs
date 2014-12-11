package be.ephec.echecs.jeu;

import java.lang.Math.*;

/**
 * Classe Cavalier, représentant la pièce Cavalier
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 26/11/14
 * date de modification : 02/12/14
 */

public class Cavalier extends Piece {
	final static int NBMOV = 8;
	
	/**
	 * Constructeur de la classe Cavalier
	 * @param x : position en x
	 * @param y : position en y
	 * @param addImage : adresse de l'image du pion
	 */
	
	public Cavalier(int x, int y, String addImage, String color) {
		super("Cavalier",addImage,true,x,y,color);
	}
	
	/**
	 * genererPos : créer un tableau de position possible pour le cavalier en fonction des cases de l'échiquier
	 * @param : plateau : l'échiquier
	 * @return : un tableau de position possible par le cavalier
	 */

	public Position[] genererPos(Echiquier plateau, String isSameTeam) {
		Position work[] = new Position[NBMOV];
		
		for (int i=0;i<NBMOV;i++) work[i] = new Position(8,8);
		
		int c=0;
		
		for (int i=-2;i<=2;i++){
			for (int j=-2;j<=2;j++){
				if (Math.abs(i)!=Math.abs(j) && i!=0 && j!=0){
					if (this.pos.getX()+i>=0
						||this.pos.getX()+i<=7
						||this.pos.getY()+j>=0
						||this.pos.getY()+j<=7
						||!plateau.echiq[this.pos.getX()+i][this.pos.getY()+j].getEstOccupe().equals(isSameTeam)){
						work[c].setX(this.pos.getX()+i);
						work[c].setY(this.pos.getY()+j);
						c++;
					}
				}
			}
		}
			
		return work; 	
	}
}