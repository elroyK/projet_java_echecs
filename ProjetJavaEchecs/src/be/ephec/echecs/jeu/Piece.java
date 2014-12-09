package be.ephec.echecs.jeu;
/**
 * Classe Piece, repr�sentant une pi�ce de l'�chiquier
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de cr�ation : 25/11/14
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
	
	abstract public Position[] genererPos();
	
	/**
	 * kill : permet de tuer une pi�ce
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
	 * genererCaseCliquable : permet de g�n�rer les cases cliquables pour le d�placement de la pi�ce
	 * @param plateau : Echiquier
	 * @param tb : Tableau de position disponible pour les deplacements de la pi�ce
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
	 * deplacement, permet le d�placement d'une pi�ce sur l'echiquier
	 * @param plateau : echiquier 
	 * @param pos : position ou on veut d�placer le joueur
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


