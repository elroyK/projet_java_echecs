package be.ephec.echecs.jeu;
/**
 * Classe Piece, représentant une pièce de l'échiquier
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 25/11/14
 * date de modification : 27/11/14
 */
abstract public class Piece {
	protected String nom;
	protected String color;
	protected String addIcone; // Adresse de l'image
	protected boolean inGame;
	protected Position pos = new Position();
	
	/**
	 * Constructeur à 5 paramètres de la classe Piece
	 * @param n : nom de la pièce
	 * @param i : adresse de l'image de la pièce
	 * @param ig: mettre la pièce en jeu ou pas
	 * @param x : position sur l'échiquier en x
	 * @param y : position sur l'échiquier en y
	 */
	public Piece(String n, String i, boolean ig, int x, int y) {
		setNom(n);
		setAddIcone(i);
		setInGame(true);
		pos.setX(x);
		pos.setY(y);	
	}
	
	abstract public void move();
	
	public void kill(){
		this.setInGame(false);
	}
	
	/* GETTERS ET SETTERS */
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAddIcone() {
		return addIcone;
	}

	public void setAddIcone(String icone) {
		this.addIcone = icone;
	}

	public boolean isInGame() {
		return inGame;
	}

	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void move(Echiquier plateau) {
		// TODO Auto-generated method stub
		
	}
	
	
}


