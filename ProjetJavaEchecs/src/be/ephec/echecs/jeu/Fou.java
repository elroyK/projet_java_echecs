package be.ephec.echecs.jeu;
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
		
		public Fou (int x, int y, String addImage) {
			super("Fou",addImage,true,x,y);
		}
		
		/**
		 * genererPos : créer un tableau de position possible pour le fou en fonction des cases de l'échiquier
		 * @param : plateau : l'échiquier
		 * @return : un tableau de position possible par le fou
		 */
		
		public Position[] genererPos(Echiquier plateau){
			
			Position work [] = new Position[NBMOV]; 
			int tempX = pos.getX() + 1;
			int tempY = pos.getY() + 1;
			int i = 0;
			
			work[i]=null;
			
			String isSameTeam = plateau.echiq[this.pos.getY()][this.pos.getX()].getEstOccupe();
			
			/*boucle pour la diagonale haute droite */
			while ((tempX <= 7)&&(tempY <= 7) && isSameTeam != plateau.echiq[tempX][tempY].getEstOccupe()) {
				work[i].setX(tempX);
				work[i].setY(tempY);
				i++;
				tempX++;
				tempY++;
			}
			
			tempX = pos.getX() - 1;
			tempY = pos.getY() + 1;
			
			work[i]=null;
			
			/*boucle pour la diagonale haute gauche*/
			while ((tempX >= 0)&&(tempY <= 7) && isSameTeam != plateau.echiq[tempX][tempY].getEstOccupe()) {
				work[i].setX(tempX);
				work[i].setY(tempY);
				i++;
				tempX--;
				tempY++;
			}
			
			tempX = pos.getX() + 1;
			tempY = pos.getY() - 1;
			
			work[i]=null;
			
			/*boucle pour la diagonale basse droite*/
			while ((tempX >= 7)&&(tempY <= 0) && isSameTeam != plateau.echiq[tempX][tempY].getEstOccupe()) {
				work[i].setX(tempX);
				work[i].setY(tempY);
				i++;
				tempX++;
				tempY--;
			}
			
			tempX = pos.getX() - 1;
			tempY = pos.getY() - 1;
			
			work[i]=null;
			
			/*boucle pour la diagonale basse gauche*/
			while ((tempX >= 0)&&(tempY <= 0) && isSameTeam != plateau.echiq[tempX][tempY].getEstOccupe()) {
				work[i].setX(tempX);
				work[i].setY(tempY);
				i++;
				tempX--;
				tempY--;
			}
			
			
			return work;
		}
}
					