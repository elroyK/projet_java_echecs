package be.ephec.echecs.jeu;

import javax.swing.*;

import java.awt.*;



/**
 * Classe Echiquier, représentant le plateau du jeu (8/8 cases)
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 25/11/14
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
					fen.setVisible(true);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
	
	public void setButtonNCliquable() {
		for (int i=0;i<NLIGNES;i++) {
			for (int j=0;j<NLIGNES;j++) {
				this.echiq[i][j].setCliquable(false);
			}
		}
	}
	
	
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
				if (couleur) couleur=false;
				else couleur=true;
			}
		}
		
		
	}
	
	public void actualiser(Joueur j1, Joueur j2){
		//this.viderEchiquier(); 
		//for (int i=0; i<Joueur.NBPIECE;i++){
			if (j1.tbPiece[0].isInGame()){
				this.echiq[0][1].setIcon(new ImageIcon(getClass().getResource("/img/pionB.gif")));
				this.echiq[j1.tbPiece[0].pos.getX()][j1.tbPiece[0].pos.getY()].actualise(j1.tbPiece[0].getAddIcone());
			}
			/*if (j2.tbPiece[i].isInGame()){
				this.echiq[j2.tbPiece[i].pos.getX()][j2.tbPiece[i].pos.getY()].actualise(j2.tbPiece[i].getAddIcone()); 
			}*/
		//}
	}
	
	
	public void viderEchiquier(){
		for (int i=0; i<Echiquier.NLIGNES;i++){
			for (int j=0; j<Echiquier.NLIGNES;j++){
				this.echiq[i][j].setIcon(null);
			}
		}
	}
		
}