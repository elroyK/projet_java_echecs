package be.ephec.echecs.jeu;

import java.awt.Color;

import be.ephec.echecs.gui.FenPromotion;

/**
 * Classe Joueur, représentant un joueur
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 26/11/14
 * date de modification : 15/12/14
 */

public class Joueur {
	// Constante
	final static int NBPIECE = 16;

	protected String nom;
	protected String couleur;
	
	
	// Tableau de 16 pièces
	protected Piece[] tbPiece = new Piece[NBPIECE];
	
	/**
	 * Constructeur de la classe Joueur
	 * @param n : nom du joueur
	 * @param c : couleur du joueur
	 */
	public Joueur(String n, String c) {	
		this.setNom(n);
		this.setCouleur(c);
	}
	
	public Joueur(Piece[] tP){
		this.setNom(null);
		this.tbPiece = tP;
	}
	
	/**
	 * Genere un tableau avec toutes les pièces sélectionnables ce tour-ci.
	 * @param plateau : échiquier de la partie
	 * @return un tableau avec toutes les pièces de ce joueur qui ont la possibilité de faire un mouvement ce tour-ci
	 */
	public Position[] genererSelect(Echiquier plateau){
		Position work[] = new Position[NBPIECE];
		for (int i=0; i<NBPIECE; i++) work[i]=new Position();
		int n = 0;
		for (int i=0;i<NBPIECE;i++){
			if (this.tbPiece[i].isInGame()==true) {
				Position tbPos[] = this.tbPiece[i].genererPos(plateau, this.tbPiece[i].getColor());
				if (tbPos.length>0) {
					work[n].setX(this.tbPiece[i].pos.getX());
					work[n].setY(this.tbPiece[i].pos.getY());
					n++;
				}
			}
		}
		
		Position finalWork[] = new Position[n];
		
		for (int i=0;i<n;i++){
			finalWork[i] = work[i];
		}	
		
		return finalWork;

	}
	
	/**
	 * Genere un tableau de positions avec toutes les cases qui pourrraient accueillir une pièce du joueur après un mouvement.
	 * @param plateau : échiquier de la partie
	 * @return un tableau de positions (utilisé pour savoir si le Roi est échec (et mat)
	 */
	public Position[] allMove(Echiquier plateau){
		Position work[] = new Position[Reine.NBMOV];
		Position finalWork[] = new Position[Echiquier.NBOUTONS];
		int fWLength = 0;
		for (int i=0;i<this.tbPiece.length;i++){
			if (this.tbPiece[i].isInGame()){
				work = this.tbPiece[i].genererPos(plateau, this.getCouleur());
				for (int j=0;j<work.length;j++){
					finalWork[fWLength] = work[j];
					fWLength++;
				}
			}
		}
		Position aReturn[] = new Position[fWLength];
		for (int i=0;i<fWLength;i++){
			aReturn[i] = finalWork[i];
		}
		
		return aReturn;
	}
	
	/**
	 * Savoir si le roi du joueur est en échec ou non
	 * @param game : La partie en cours
	 * @return un boolean qui signifie l'état d'échec ou non
	 */
	public boolean estEchec (Partie game) {
		Joueur adverse = (game.settings.joueurActuel == 1) ? game.jB : game.jA;
		Position pWork[] = adverse.allMove(game.plateau);
		int i=0;
		while(i<pWork.length && !this.tbPiece[14].pos.equals(pWork[i])) {
			i++;
		};
		if (i<pWork.length && this.tbPiece[14].pos.equals(pWork[i])) {
			game.plateau.echiq[this.tbPiece[14].pos.getX()][this.tbPiece[14].pos.getY()].setBackground(new Color(255,95,95));
			game.plateau.setVisible(true);
			return true;
		}
		return false;
	}
	
	/**
	 * Savoir si le roi du joueur est en échec et mat
	 * @param game : La partie en cours
	 * @return un boolean qui signifie l'état d'échec et mat
	 */
	public boolean estMat (Partie game){
		Joueur adverse = (game.settings.joueurActuel == 1) ? game.jB : game.jA;
		Position ennemi[] = adverse.allMove(game.plateau);
		Position posW[] = this.tbPiece[14].genererPos(game.plateau, this.getCouleur());
		boolean idem = false;
		int e=0;
		int p=0;
		int nIdem=0;
		
		if (posW.length==0 || ennemi.length==0) return false;
		
		do{
			do{
				idem = posW[p].equals(ennemi[e]);
				if (idem) nIdem++;
				e++;
			}while (!idem && e<ennemi.length);
			p++;
			e=0;
		} while(p<posW.length);
		if (nIdem==posW.length && nIdem != 0 && this.estEchec(game)) {
			return true;
		}
		return false;
	}
	
	/*public void fairePromotion (){
		// JOUEUR 1
		int i=-1;
		String[] work = new String[Joueur.NBPIECE/2];
		do {
			i++;
			if (this.tbPiece[i].isInGame() && this.tbPiece[i].pos.getY()==0) {
				work = Pion.promotion(this,this.tbPiece[i]);
			}
			
		} while (i<Joueur.NBPIECE/2 && work==null);
		
		if (i == Joueur.NBPIECE/2){
			FenPromotion f = new FenPromotion(work);
			f.setVisible(true);
			String choix = f.getChoix();
			int j=-1;
			boolean found = false;
			do{
				j++;
				if (!this.tbPiece[j].isInGame()){
					if (this.tbPiece[j].getNom().equals(choix)){
						found=true;
					}
				}
				
			} while (j<Joueur.NBPIECE && !found);
			if (found){
				this.tbPiece[j].setInGame(true);
				this.tbPiece[j].pos.setX(this.tbPiece[i].pos.getX());
				this.tbPiece[j].pos.setY(this.tbPiece[i].pos.getY());
				this.tbPiece[i].kill();
			}
		}
	}*/
	
	// GETTERS ET SETTERS
	
	public static int getNBPIECE() {
		return NBPIECE;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

}