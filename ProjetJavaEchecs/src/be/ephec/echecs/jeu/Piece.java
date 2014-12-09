package be.ephec.echecs.jeu;
/**
 * Classe Piece, représentant une pièce de l'échiquier
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 25/11/14
 * date de modification : 04/12/14
 */
abstract public class Piece {
	protected String nom;
	protected String color;
	protected String addIcone; // Adresse de l'image
	protected boolean inGame;
	protected Position pos = new Position();
	protected int id;
	
	public Piece() {
		
	}
	
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
	
	abstract public Position[] genererPos();
	
	/**
	 * kill : permet de tuer une pièce
	 */
	
	public void kill(){
		this.setInGame(false);
		this.pos = new Position(8,8); // ecartez du plateau pour des eventuelles bugs pendant les deplacements
	}
	
	public void move(Echiquier plateau) {
		Position tbPos[] = this.genererPos();
		this.genererCaseCliquable(plateau, tbPos);
		// TODO : AFFICHER LES CASES DISPOBIBLES EN VERT
		// TODO : CHOPER LA POSITION CLIQUE PAR LE JOUEUR
		Position zone = new Position(0,0); // A IMPLEMENTER AVEC LA POSITION DU JOUEUR
		this.deplacement(plateau,zone);
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
				// PARCOURS LE TABLEAU DE POSITION POSSIBLE PAR LA PIECE
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
	
	/**
	 * deplacement, permet le déplacement d'une pièce sur l'echiquier
	 * @param plateau : echiquier 
	 * @param pos : position ou on veut déplacer le joueur
	 */
	
	public void deplacement(Echiquier plateau, Position pos) {
		if (plateau.echiq[pos.getX()][pos.getY()].getEstOccupe()!=Param.LIBRE) {
			// TODO : KILL LA PIECE OCCUPE MAIS COMMENT ??
			this.pos.setX(pos.getX());
			this.pos.setY(pos.getY());
		} else {
			this.pos.setX(pos.getX());
			this.pos.setY(pos.getY());
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
}


