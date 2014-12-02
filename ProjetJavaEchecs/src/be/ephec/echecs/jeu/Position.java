package be.ephec.echecs.jeu;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}
