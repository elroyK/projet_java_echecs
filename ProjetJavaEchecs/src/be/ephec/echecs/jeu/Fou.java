package be.ephec.echecs.jeu;

import java.lang.Math.*;
/**
 * Classe Fou, représentant la pièce Fou
 * date de création : 26/11/14
 * date de modification : 15/12/14
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
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
		 * genererPos : créé un tableau de positions possibles pour le fou en fonction des cases de l'échiquier
		 * @param : plateau : l'échiquier
		 * @return : un tableau de positions possibles par le fou
		 */
		
		public Position[] genererPos(Echiquier plateau, String isSameTeam){
			
			Position work [] = new Position[NBMOV];
			for (int i=0; i<NBMOV; i++) work[i] = new Position();
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
								&& plateau.echiq[tempX][tempY].getEstOccupe().equals(Param.LIBRE)){
							work[c].setX(tempX);
							work[c].setY(tempY);
							tempX += i;
							tempY += j;
							c++;
						}
						String oppositeTeam = "";
						switch (isSameTeam){
						case Param.BLANC : oppositeTeam = Param.NOIR;break;
						case Param.NOIR : oppositeTeam = Param.BLANC;break;
						}
						if (tempX <= 7
								&& tempX >= 0
								&& tempY <= 7
								&& tempY >= 0
								&& plateau.echiq[tempX][tempY].getEstOccupe().equals(oppositeTeam)){
							work[c].setX(tempX);
							work[c].setY(tempY);
							c++;
						}
					}
				}
			}
			Position finalWork[] = new Position[c];
			for (int i=0;i<c;i++) finalWork[i] = work[i];
			
			return finalWork;
		}
}
					