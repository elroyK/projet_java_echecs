package be.ephec.echecs.jeu;

import javax.swing.*;

import java.awt.*;



/**
 * Classe Echiquier, repr�sentant le plateau du jeu (8/8 cases)
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de cr�ation : 25/11/14
 * date de modification : 25/11/14
 */
public class Echiquier extends JFrame {
	
	static final int NBOUTONS = 64;
	static final int NLIGNES = 8;
	
	public int x[] = new int[NBOUTONS];
	public int y[] = new int[NBOUTONS];
	public int larg[] = new int[NBOUTONS];
	public int haut[] = new int[NBOUTONS];
	public int px[] = new int[NBOUTONS];
	public int py[] = new int[NBOUTONS];
	
	protected Case echiq[][] = new Case[NLIGNES][NLIGNES];

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Echiquier fen = new Echiquier();	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Constructeur de la classe Echiquier
	 */
	
	public Echiquier() {
		boolean couleur = true;
		this.creationTableaux();
		setResizable(false);
		setTitle("Jeu d'echecs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		
		Container contenu = getContentPane();
		GridBagLayout g = new GridBagLayout();
		contenu.setLayout(g);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		for (int i = 0 ; i<x.length;i++){
			c.gridx = x[i];
			c.gridy = y[i];
			c.gridwidth = larg[i];
			c.gridheight = haut[i];
			c.weightx = px[i];
			c.weighty = py[i];
			this.echiq[c.gridx][c.gridy] = new Case(couleur, c.gridx, c.gridy);
			contenu.add (this.echiq[c.gridx][c.gridy], c);		
			
			if (!((i+1)%8 == 0)){
				couleur = !couleur;
			}
		}
	}
	
	/**
	 * Cr�er les param�tres pour les cases du GridBagLayout
	 */

	public void creationTableaux(){
		int i=0;
		for (int yW=0; yW<NLIGNES; yW++){
			for (int xW=0; xW<NLIGNES; xW++){
				x[i]=xW;
				y[i]=yW;
				larg[i]=1;
				haut[i]=1;
				px[i]=100/8;
				py[i]=100/8;
				i++;
			}
		}
	}
	
	/**
	 * setButtonCliquable : rend tous les boutons cliquables o� non
	 * @param b : true, rend les boutons cliquables
	 */
	public void setButtonsCliquable(boolean b) {
		for (int i=0;i<NLIGNES;i++) {
			for (int j=0;j<NLIGNES;j++) {
				this.echiq[i][j].setCliquable(b);
			}
		}
	}
	
	/**
	 * actualiser, permet de refresh la l'echiquier pour pouvoir d�placer une pi�ce
	 * @param j1 : joueur A, pour ses pi�ces
	 * @param j2 : joueur B, pour ses pi�ces
	 */
	
	public void actualiser(Joueur j1, Joueur j2){
		this.viderEchiquier(); 
		for (int i=0; i<Joueur.NBPIECE;i++){
			if (j1.tbPiece[0].isInGame()){
				this.echiq[j1.tbPiece[i].pos.getX()][j1.tbPiece[i].pos.getY()].actualise(j1.tbPiece[i].getAddIcone());
			}
			if (j2.tbPiece[i].isInGame()){
				this.echiq[j2.tbPiece[i].pos.getX()][j2.tbPiece[i].pos.getY()].actualise(j2.tbPiece[i].getAddIcone()); 
			}
		}
		this.setVisible(true);
	}
	
	/**
	 * Vide toutes les images des cases, afin de rafra�chir l'echiquier
	 */
	
	public void viderEchiquier(){
		for (int i=0; i<Echiquier.NLIGNES;i++){
			for (int j=0; j<Echiquier.NLIGNES;j++){
				this.echiq[i][j].setIcon(null);
			}
		}
	}
	
	/**
	 * showPieceChoice : permet de montrer � l'utilisateur les pi�ces o� peut cliquer
	 * @param tbP : tableau de pi�ces qu'on peut d�placer
	 */
	
	public void showPieceChoice(Piece tbP[]) {
		this.setButtonsCliquable(false);
		
		for (int i=0;i<tbP.length;i++) {
			this.echiq[tbP[i].pos.getX()][tbP[i].pos.getY()].setCliquable(true);
		}
	}
	
	/**
	 * showChoiceAvailable : permet de montrer � l'utilisateur les zones o� on peut d�placer la pi�ce.
	 * @param tbP : tableau de positions disponibles pour d�placer la pi�ce.
	 */
	
	public void showChoiceAvailable (Position tbP[]) {
		this.setButtonsCliquable(false);
		
		for (int i=0;i<tbP.length;i++) {
			this.echiq[tbP[i].getX()][tbP[i].getY()].setCliquable(true);
		}
	}
}