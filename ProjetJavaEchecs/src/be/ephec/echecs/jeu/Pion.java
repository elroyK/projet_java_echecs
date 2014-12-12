package be.ephec.echecs.jeu;
/**
 * Classe Pion, repr�sentant la pi�ce Pion
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de cr�ation : 25/11/14
 * date de modification : 03/12/14
 */

public class Pion extends Piece {
	final static int NBMOV = 2;
	protected boolean dejaJoue;
	
	/**
	 * Constructeur de la classe Pion
	 * @param x : position en x
	 * @param y : position en y
	 * @param addImage : adresse de l'image du pion
	 */
	
	public Pion(int x, int y, String addImage, String color) {
		super("Pion",addImage,true,x,y, color);
		setDejaJoue(false);
	}
	
	/**
	 * genererPos : cr�er un tableau de position possible pour le pion en fonction des cases de l'�chiquier
	 * @param : plateau : l'�chiquier
	 * @return : un tableau de position possible par le pion
	 */
	
	public Position[] genererPos(Echiquier plateau, String isSameTeam) {
		
		Position work[] = new Position[NBMOV];
		
		for (int i=0;i<NBMOV;i++) work[i] = new Position(8,8);
		
		if (isSameTeam==Param.BLANC) {
			String isBusy = plateau.echiq[this.pos.getX()][this.pos.getY()-1].estOccupe;
			if (isBusy==Param.LIBRE){
				return work;
			}
			work[0].setX(this.pos.getX());
			work[0].setY(this.pos.getY()-1);
			if (!this.isDejaJoue()) {
				work[1].setX(this.pos.getX());
				work[1].setY(this.pos.getY()-2);
				setDejaJoue(true);
			}		
		} else {
			String isBusy = plateau.echiq[this.pos.getX()][this.pos.getY()+1].estOccupe;
			if (!isBusy.equals(Param.LIBRE)){
				return work;
			}
			work[0].setX(this.pos.getX());
			work[0].setY(this.pos.getY()+1);
			if (!this.isDejaJoue()) {
				work[1].setX(this.pos.getX());
				work[1].setY(this.pos.getY()+2);
				setDejaJoue(true);
			}
		}
		
		return work;
	}
	
	/**
	 * Permet de promouvoir un pion en n'importe quel pi�ce "morte"
	 * @param jCol : Couleur du joueur (noir ou blanc)
	 * Si c'est joueur noir => les pi�ces descendent
	 * Si c'est joueur blanc => les pi�ces montent
	 */
	
	public void promotion(String jCol) {
		if (jCol==Param.NOIR) {
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
