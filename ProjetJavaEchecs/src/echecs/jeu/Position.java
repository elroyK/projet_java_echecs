package echecs.jeu;
/**
 * Classe Position, repr�sentant la position d'une pi�ce sur l'�chiquier
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de cr�ation : 25/11/14
 * date de modification : 25/11/14
 */

public class Position {
	protected int x;
	protected int y;
	
	/**
	 * Constructeur de la classe Position
	 */
	
	public Position() {
		setX(0);
		setY(0);
	}
	
	/**
	 * Constructeur avec deux param�tres de la classe Position
	 * @param a : case en hauteur
	 * @param b : case en largeur
	 */
	
	public Position(int a, int b) {
		setX(b);
		setY(a);
	}
	
	/* GETTERS ET SETTERS */
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
