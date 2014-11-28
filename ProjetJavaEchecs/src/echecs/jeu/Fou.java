package echecs.jeu;
/**
 * Classe Fou, repr�sentant la pi�ce Fou
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de cr�ation : 26/11/14
 * date de modification : 27/11/14
 */
	
	public class Fou extends Piece {
	
		/**
		 * Constructeur de la classe Fou
		 * @param x : position en x
		 * @param y : position en y
		 * @param addImage : adresse de l'image
		 */
		
		public Fou (int x, int y, String addImage) {
			super("Pion",addImage,true,x,y);
		}
		
		/**
		 * Proc�dure permettant le d�placement du Fou
		 */
		
		public Position[] generateDeplacements(){
			
			Position work [] = new Position[14]; 
			int tempX = pos.getX() + 1;
			int tempY = pos.getY() + 1;
			int i = 0;
			
			/*boucle pour la diagonale haute droite */
			while ((tempX <= 8)&&(tempY <= 8)) {
				work[i].setX(tempX);
				work[i].setY(tempY);
				i++;
				tempX++;
				tempY++;
			}
			
			tempX = pos.getX() - 1;
			tempY = pos.getY() + 1;
			
			/*boucle pour la diagonale haute gauche*/
			while ((tempX >= 1)&&(tempY <= 8)) {
				work[i].setX(tempX);
				work[i].setY(tempY);
				i++;
				tempX--;
				tempY++;
			}
			
			tempX = pos.getX() + 1;
			tempY = pos.getY() - 1;
			
			/*boucle pour la diagonale basse droite*/
			while ((tempX >= 8)&&(tempY <= 1)) {
				work[i].setX(tempX);
				work[i].setY(tempY);
				i++;
				tempX++;
				tempY--;
			}
			
			tempX = pos.getX() - 1;
			tempY = pos.getY() - 1;
			
			/*boucle pour la diagonale basse gauche*/
			while ((tempX >= 1)&&(tempY <= 1)) {
				work[i].setX(tempX);
				work[i].setY(tempY);
				i++;
				tempX--;
				tempY--;
			}
			
			return work;
		}
		
		public void move() {
			Position[] deplacements = this.generateDeplacements();
			
			//TODO Tests savoir premi�re rencontr�e sur chaque axe m�thode � part
			//TODO Eclaircir cases jusque premi�re pi�ce incluse
			//TODO Mouvement en lui m�me
			//TODO test commit Enzo		
		}
	}
					