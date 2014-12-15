package be.ephec.echecs.jeu;
/**
 * Classe Piece, repr�sentant une pi�ce de l'�chiquier
 * date de cr�ation : 25/11/14
 * date de modification : 15/12/14
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 */
abstract public class Piece {
	protected String nom;
	protected String color;
	protected String addIcone;
	protected boolean inGame;
	protected Position pos = new Position();
	protected boolean dejaJoue;
	
	public Piece() {
	}
	
	/**
	 * Constructeur � 5 param�tres de la classe Piece
	 * @param n : nom de la pi�ce
	 * @param i : adresse de l'image de la pi�ce
	 * @param ig: mettre la pi�ce en jeu ou pas
	 * @param x : position sur l'�chiquier en x
	 * @param y : position sur l'�chiquier en y
	 * @param c : La couleur de la pi�ce
	 */
	public Piece(String n, String i, boolean ig, int x, int y, String c) {
		setNom(n);
		setAddIcone(i);
		setInGame(true);
		pos.setX(x);
		pos.setY(y);
		setColor(c);
		setDejaJoue(false);
	}
	
	abstract public Position[] genererPos(Echiquier plateau, String isSameTeam);
	
	/**
	 * kill : permet de tuer la pi�ce
	 */
	
	public void kill(){
		this.setInGame(false);
		this.pos = new Position(8,8);
	}
	
	/**
	 * genererCaseCliquable : permet de g�n�rer les cases cliquables pour le d�placement de la pi�ce
	 * @param plateau : Echiquier
	 * @param tb : Tableau de positions disponibles pour les d�placements de la pi�ce
	 */
	
	public void genererCaseCliquable(Echiquier plateau, Position tb[]) {
		// PARCOURS L'ECHIQUIER EN X
		for (int i=0;i<8;i++) {
			// PARCOURS L'ECHIQUIER EN Y
			for (int j=0;j<8;j++){	
				// PARCOURS LE TABLEAU DE POSITIONS POSSIBLES PAR LA PIECE
				for (int w=0;w<tb.length;w++) {
					if (tb[w].equals(plateau.echiq[i][j].pos)) {
						// SI LA CASE EST PRISE PAR UNE PIECE NOIRE
						if (plateau.echiq[i][j].getEstOccupe()==Param.NOIR) {
							// SI LA COULEUR DE CETTE PIECE EST NOIRE
							if (this.getColor()==Param.NOIR) {
								plateau.echiq[i][j].setCliquable(false);
							} else {
								plateau.echiq[i][j].setCliquable(true);
							}
						} // SI LA CASE EST PRISE PAR UNE PIECE BLANCHE
						else if (plateau.echiq[i][j].getEstOccupe()==Param.BLANC){
							// SI LA COULEUR DE CETTE PIECE EST BLANCHE
							if (this.getColor()==Param.BLANC) {
								plateau.echiq[i][j].setCliquable(false);
							} else {
								plateau.echiq[i][j].setCliquable(true);
							}	
							
						}
					}
				}
			}
		}	
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

	public boolean isDejaJoue() {
		return dejaJoue;
	}
	
	public void setDejaJoue(boolean dejaJoue) {
		this.dejaJoue = dejaJoue;
	}	

}