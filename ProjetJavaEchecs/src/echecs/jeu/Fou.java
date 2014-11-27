package echecs.jeu;
/**
 * Classe Fou, repr�sentant la pi�ce Fou
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de cr�ation : 26/11/14
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
		 * Proc�dure permettant le d�placement du Fou
		 */
		
		public void move(){
			
			int tempX;
			int tempY;
			
			//TODO : AJOUTER les conditions avec le(s) future(s) m�thode(s) (quand le fou est 
			//     			  entourr� ou tombe sur une pi�ce et qu'il puisse la prendre ou pas)
			
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
					