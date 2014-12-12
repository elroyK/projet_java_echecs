package be.ephec.echecs.jeu;

import java.lang.Math.*;
/**
 * Classe Fou, représentant la pièce Fou
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 26/11/14
 * date de modification : 03/12/14
 */
	
	public class Fou extends Piece {
		final static int NBMOV = 14;
		
		public Fou() {
			super();
		}
	
		/**
		 * Constructeur de la classe Fou
		 * @param x : position en x
		 * @param y : position en y
		 * @param addImage : adresse de l'image
		 */
		
		public Fou (int x, int y, String addImage, String color) {
			super("Fou",addImage,true,x,y, color);
		}
		
		/**
		 * genererPos : créer un tableau de position possible pour le fou en fonction des cases de l'échiquier
		 * @param : plateau : l'échiquier
		 * @return : un tableau de position possible par le fou
		 */
		
		public Position[] genererPos(Echiquier plateau, String isSameTeam){
			
			Position work [] = new Position[NBMOV];
			for (int i=0; i<NBMOV; i++) work[i] = new Position(8,8);
			int tempX;
			int tempY;
			int c = 0;
			
			for (int i=-1;i<=1;i++){
				for (int j=-1;j<=1;j++){
					if (Math.abs(i)==Math.abs(j) && i!=0){
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
			
			return work;
		}
}
					