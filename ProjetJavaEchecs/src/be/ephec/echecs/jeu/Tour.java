package be.ephec.echecs.jeu;
/**
 * Classe Tour, représentant la pièce Tour
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 26/11/14
 * date de modification : 04/12/14
 */

public class Tour extends Piece {
	final static int NBMOV = 14;
	protected boolean estRoquable;

	public Tour() {
		super();
	}
	
	/**
	 * Constructeur de la classe Tour
	 * @param x : position en x
	 * @param y : position en y
	 * @param addImage : adresse de l'image
	 * 
	 */
	
	public Tour (int x, int y, String addImage) {
		super("Tour",addImage,true,x,y);
	}
	
	/**
	 * Procédure qui génère l'ensemble des positions possible de la pièce à partir
	 * de sa position actuelle
	 * @return work = tableau de la classe Position, contenant un couple de coord (x,y)
	 */

	//TODO : completer l'algo (boucle générale ou pas ? ...) 
	public Position[] genererPos(){
		
		Position work [] = new Position[NBMOV]; 
		int tempX = pos.getX() + 1;
		int tempY = pos.getY() + 1;
		int i = 0;
		
		/*boucle pour l'horizontale droite */
		while ((tempX <= 7)) {
			work[i].setX(tempX);
			work[i].setY(tempY);
			i++;
			tempX++;
		}
		tempX = pos.getX() - 1;
		
		
		/*boucle pour l'horizontale gauche*/
		while ((tempX >= 0)) {
			work[i].setX(tempX);
			work[i].setY(tempY);
			i++;
			tempX--;
		}
		tempX = pos.getX() + 1;
		
		
		/*boucle pour la verticale haute*/
		while ((tempY <= 7)) {
			work[i].setY(tempY);
			work[i].setX(tempX);
			i++;
			tempY++;
		}
		tempY = pos.getY() - 1;
		
		/*boucle pour la verticale basse*/
		while (tempY <= 0) {
			work[i].setX(tempX);
			work[i].setY(tempY);
			i++;
			tempY--;
			}
		tempY = pos.getY() + 1;
		
		return work;
	}
}

