package be.ephec.echecs.jeu;

import java.awt.Color;

/**
 * Classe Joueur, représentant un joueur
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 26/11/14
 * date de modification : 10/12/14
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
	 * 
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
	
	public boolean estEchec (Partie game) {
		Joueur adverse = (game.settings.joueurActuel == 1) ? game.jB : game.jA;
		Joueur present = (game.settings.joueurActuel == 1) ? game.jA : game.jB;
		
		/*for (int i=0;i<adverse.tbPiece.length;i++) {
			if (adverse.tbPiece[i].isInGame()){
				Position work[]=adverse.tbPiece[i].genererPos(game.plateau, adverse.getCouleur());
				for (int j=0;j<work.length;j++) {
					if (present.tbPiece[14].pos.equals(adverse.tbPiece[i].genererPos))
						game.plateau.echiq[present.tbPiece[14].pos.getX()][present.tbPiece[14].pos.getY()].setBackground(new Color(255,95,95));
						
						return true;
				}
			}
		}
		return false;*/
		
		
		
		Position pWork[] = adverse.allMove(game.plateau);
		int i=0;
		while(i<pWork.length && !this.tbPiece[14].pos.equals(pWork[i])) {
			i++;
		};
		if (i<pWork.length && this.tbPiece[14].pos.equals(pWork[i])) {
			game.plateau.echiq[this.tbPiece[14].pos.getX()][this.tbPiece[14].pos.getY()].setBackground(new Color(255,95,95));
			game.plateau.setVisible(true);
			System.out.println("Ahoy");
			return true;
		}
		return false;
	}
	
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
			System.out.println("Yolo");
			return true;
		}
		return false;
	}
	
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