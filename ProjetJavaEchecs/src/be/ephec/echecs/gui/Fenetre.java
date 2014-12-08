package be.ephec.echecs.gui;

import be.ephec.echecs.jeu.*;

import javax.swing.*;

import java.awt.*;


/**
 * Classe Fenêtre, qui génère le visuel de l'échiquier
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 04/12/14
 * date de modification : 04/12/14
 */
public class Fenetre extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre fen = new Fenetre();
					fen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public final int NBOUTONS = 64;
	public final int NLIGNES = 8;
	public int x[] = new int[NBOUTONS];
	public int y[] = new int[NBOUTONS];
	public int larg[] = new int[NBOUTONS];
	public int haut[] = new int[NBOUTONS];
	public int px[] = new int[NBOUTONS];
	public int py[] = new int[NBOUTONS];
	
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
	
	
	public Fenetre() {
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
			contenu.add (new Case(couleur), c);
			
			if (!((i+1)%8 == 0)){
				if (couleur) couleur=false;
				else couleur=true;
			}
		}
		}
		
	}

