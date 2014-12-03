package be.ephec.echecs.jeu;
/**
 * Classe Piece, représentant une pièce de l'échiquier
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 25/11/14
 * date de modification : 03/12/14
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
	
	abstract public void move(Echiquier plateau);
	
	public void kill(){
		this.setInGame(false);
	}
	
	/**
	 * genererCaseCliquable : permet de générer les cases cliquables pour le déplacement de la pièce
	 * @param plateau : Echiquier
	 * @param tb : Tableau de position disponible pour les deplacements de la pièce
	 */
	
	public void genererCaseCliquable(Echiquier plateau, Position tb[]) {
		// PARCOURS L ECHIQUIER EN X
		for (int i=0;i<8;i++) {
			// PARCOURS L ECHIQUIER EN Y
			for (int j=0;j<8;j++){	
				// PARCOURS LE TABLEAU DE POSITION
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
						} // SI LA CASE EST PRISE PAR UNE PIECE NOIRE
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
}


