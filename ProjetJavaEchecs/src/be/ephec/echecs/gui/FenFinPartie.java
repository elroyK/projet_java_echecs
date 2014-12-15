package be.ephec.echecs.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.ephec.echecs.jeu.Param;
import be.ephec.echecs.jeu.Partie;

/**
 * Classe FenFinPartie, qui est la JFrame qui s'ouvre lorsque la partie est finie et qui affiche le gagnant ou l'égalité
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 15/12/14
 * date de modification : 15/12/14
 */
public class FenFinPartie extends JFrame {

	private JPanel contentPane;
	
	public FenFinPartie(Partie game) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 99);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JLabel labelFin = new JLabel("");
		
		if (game.estEnd()){
			String winner = "";
			switch (Partie.getjEnCours().getCouleur()){
			case Param.BLANC : winner = "joueur 2";break;
			case Param.NOIR : winner = "joueur 1";break;
			}
		
			labelFin = new JLabel("Le "+ winner +" remporte la partie !");
		}
		
		if (game.estPat()){
			labelFin = new JLabel("Egalité !");
		}
		
		contentPane.add(labelFin, BorderLayout.NORTH);
		
		JButton btnOk = new JButton("Fin");
		contentPane.add(btnOk, BorderLayout.CENTER);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
}
