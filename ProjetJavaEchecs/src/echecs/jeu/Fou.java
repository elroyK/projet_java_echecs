package echecs.jeu;
/**
 * Classe Fou, représentant la pièce Fou
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 26/11/14
 * date de modification : 26/11/14
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
		 * Procédure permettant le déplacement du Fou
		 */
		
		public void move(){
			
			int tempX;
			int tempY;
			
			//TODO : AJOUTER les conditions avec le(s) future(s) méthode(s) (quand le fou est 
			//     			  entourré ou tombe sur une pièce et qu'il puisse la prendre ou pas)
			
			// TODO : SUGGESTION : il faudrait pas mettre l'ensemble des positions possibles 
			//						qui ressortent de chaque boucle dans une seule variable... ?
			
			/*boucle pour la diagonale haute droite */
			for (int i = 0; i < 7-pos.getX(); i++) {
				for (int j = 0; j <7-pos.getY(); j++) {
					tempX = pos.getX();
					pos.setX(tempX+1);
					tempY = pos.getY();
					pos.setY(tempY+1);
					}
				}
			
			/*boucle pour la diagonale haute gauche*/
			for (int i = 0; i < 7-pos.getX(); i--) {
				for (int j = 0; j <7-pos.getY(); j++) {
					tempX = pos.getX();
					pos.setX(tempX-1);
					tempY = pos.getY();
					pos.setY(tempY+1);
					}
				}
					
			/*boucle pour la diagonale basse droite */
			for (int i = 0; i < 7-pos.getX(); i++) {
				for (int j = 0; j <7-pos.getY(); j--) {
					tempX = pos.getX();
					pos.setX(tempX+1);
					tempY = pos.getY();
					pos.setY(tempY-1);
					}
				}	
			
			/*boucle pour la diagonale basse gauche */
			for (int i = 0; i < 7-pos.getX(); i--) {
				for (int j = 0; j <7-pos.getY(); j--) {
					tempX = pos.getX();
					pos.setX(tempX-1);
					tempY = pos.getY();
					pos.setY(tempY-1);
					}
				}
		}
	}
					