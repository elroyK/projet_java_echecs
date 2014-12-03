package be.ephec.echecs.jeu;
/**
 * Classe Pion, repr�sentant la pi�ce Pion
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de cr�ation : 25/11/14
 * date de modification : 03/12/14
 */

public class Pion extends Piece {
	private boolean dejaJoue;

	private static String COULNOIR = "noir";
	
	/**
	 * Constructeur de la classe Pion
	 * @param x : position en x
	 * @param y : position en y
	 * @param addImage : adresse de l'image du pion
	 */
	public Pion(int x, int y, String addImage) {
		super("Pion",addImage,true,x,y);
		setDejaJoue(false);
	}
	
	/**
	 * @return : un tableau de position possible par le pion
	 */
	
	public Position[] genererPos() {
		
		Position work[] = new Position[2];
		
		if (this.getColor() == Param.BLANC) {
			work[0].setY(this.pos.getY()+1);
			if (this.isDejaJoue()) {
				work[1].setY(this.pos.getY()+2);
				setDejaJoue(true);
			}		
		} else {
			work[0].setY(this.pos.getY()-1);
			if (this.isDejaJoue()) {
				work[1].setY(this.pos.getY()-2);
				setDejaJoue(true);
			}
		}
		
		return work;
	}
	
	/**
	 * Permet de bouger le pion
	 * @param jColor : Couleur du joueur (noir ou blanc)
	 * Si c'est joueur noir => les pi�ces descendent
	 * Si c'est joueur blanc => les pi�ces montent
	 */
	@Override
	public void move(Echiquier plateau) {

		Position tbPos[] = this.genererPos();
		this.genererCaseCliquable(plateau, tbPos);
		// TODO : AFFICHER LES CASES DISPOBIBLES EN VERT
		// TODO : CHOPER LA POSITION CLIQUE PAR LE JOUEUR
		Position zone = new Position(0,0); // A IMPLEMENTER AVEC LA POSITION DU JOUEUR
		this.deplacement(plateau,zone); 
	}
	
	/**
	 * Permet de promouvoir un pion en n'importe quel pi�ce "morte"
	 * @param jCol : Couleur du joueur (noir ou blanc)
	 * Si c'est joueur noir => les pi�ces descendent
	 * Si c'est joueur blanc => les pi�ces montent
	 */
	public void promotion(String jCol) {
		if (jCol==COULNOIR) {
			if (this.pos.getY()==0) {
				this.setInGame(false);
				// TODO : Implementer la m�thode
				/*
				 * Trouver toutes les pi�ces mortes
				 * Proposer dans une liste d�roulante les pi�ces disponible pour la promotion
				 * Cr�ation de la pi�ce choisie
				 * On place la pi�ce sur l'�chiquier mais ou ??
				 */
			}
		} else {
			if (this.pos.getY()==8) {
				this.setInGame(false);
				// TODO : Implementer la m�thode
			}
		}
	}
	
	public void prisePassant() {
		// TODO : impl�menter la m�thode
	}

	/* GETTERS ET SETTERS */
	public boolean isDejaJoue() {
		return dejaJoue;
	}

	public void setDejaJoue(boolean dejaJoue) {
		this.dejaJoue = dejaJoue;
	}
	
}
