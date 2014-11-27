package echecs.jeu;
/**
 * Classe Piece, repr�sentant une pi�ce de l'�chiquier
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de cr�ation : 25/11/14
 * date de modification : 26/11/14
 */
public class Piece {
	protected String nom;
	protected String addIcone; // Adresse de l'image
	protected boolean inGame;
	protected Position pos = new Position();
	
	/**
	 * Constructeur � 5 param�tres de la classe Piece
	 * @param n : nom de la pi�ce
	 * @param i : adresse de l'image de la pi�ce
	 * @param ig: mettre la pi�ce en jeu ou pas
	 * @param x : position sur l'�chiquier en x
	 * @param y : position sur l'�chiquier en y
	 */
	public Piece(String n, String i, boolean ig, int x, int y) {
		setNom(n);
		setAddIcone(i);
		setInGame(true);
		pos.setX(x);
		pos.setY(y);	
	}
	
	public void move() {
		// TODO : ?? 
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
	
	
}


