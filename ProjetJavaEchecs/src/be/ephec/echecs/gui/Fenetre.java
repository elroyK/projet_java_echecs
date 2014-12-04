package be.ephec.echecs.gui;

import be.ephec.echecs.jeu.*;

import javax.swing.*;

import java.awt.*;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

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


	
	public static int NBOUTONS = 64;
	public static int x[] = {0,1,2,3,4,5,6,7,0,1,2,3,4,5,6,7,0,1,2,3,4,5,6,7,0,1,2,3,4,5,6,7,
		0,1,2,3,4,5,6,7,0,1,2,3,4,5,6,7,0,1,2,3,4,5,6,7,0,1,2,3,4,5,6,7};
	public static int y[] = {0,0,0,0,0,0,0,0,
		1,1,1,1,1,1,1,1,
		2,2,2,2,2,2,2,2,
		3,3,3,3,3,3,3,3,
		4,4,4,4,4,4,4,4,
		5,5,5,5,5,5,5,5,
		6,6,6,6,6,6,6,6,
		7,7,7,7,7,7,7,7};
	public static int larg[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
		1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
	public static int haut[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
		1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
	public static int px[] = {100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8,
		100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8,
		100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8,
		100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8,
		100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8,
		100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8,
		100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8,
		100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8};
	public static int py[] = {100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8,
		100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8,
		100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8,
		100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8,
		100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8,
		100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8,
		100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8,
		100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8, 100/8};
	
	
	public Fenetre() {
		boolean couleur = true;
		setResizable(false);
		setTitle("Jeu d'echecs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
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
			contenu.add (new Case(couleur, i), c);
			
			if (!((i+1)%8 == 0)){
				if (couleur) couleur=false;
				else couleur=true;
			}
		}
		}
		
	}

