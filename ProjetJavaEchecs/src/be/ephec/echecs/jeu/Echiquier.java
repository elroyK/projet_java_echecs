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
	
	public final int NBOUTONS = 64;
	public final int NLIGNES = 8;
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
		
	}