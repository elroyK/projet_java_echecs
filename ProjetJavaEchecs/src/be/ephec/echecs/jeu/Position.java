package be.ephec.echecs.jeu;
/**
 * Classe Position, représentant la position d'une pièce sur l'échiquier
 * date de création : 25/11/14
 * date de modification : 15/12/14
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 */

public class Position {
	protected int x;
	protected int y;
	
	/**
	 * Constructeur de la classe Position
	 */
	
	public Position() {
		setX(-1);
		setY(-1);
	}
	
	/**
	 * Constructeur à deux paramètres de la classe Position
	 * @param x : abscisse de la case
	 * @param y : ordonnée de la case
	 */
	
	public Position(int x, int y) {
		setX(x);
		setY(y);
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
