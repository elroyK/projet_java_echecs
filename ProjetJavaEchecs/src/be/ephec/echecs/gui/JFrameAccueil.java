package be.ephec.echecs.gui;

/**
* Classe JFrameAccueil, permet de créer un fenêtre avec des bouttons de choix (serveur ou client)
* date de création : 13/12/14
* date de modification : 15/12/14
* @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
* 
*/


import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameAccueil extends JFrame {
	protected JButton btnJeVeuxEtreS;
	protected JButton btnJeVeuxEtreC;
	protected JPanel contentPane;
	
	/**
	 *Constructeur de la JFrame
	 */
	public JFrameAccueil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Launcher");
		contentPane = new JPanelAccueil();
		setContentPane(contentPane);
	}
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
								
					JFrameAccueil frame = new JFrameAccueil();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	//GETTERS ET SETTERS
	
	public JButton getBtnJeVeuxEtreS() {
		return btnJeVeuxEtreS;
	}

	public void setBtnJeVeuxEtreS(JButton btnJeVeuxEtreS) {
		this.btnJeVeuxEtreS = btnJeVeuxEtreS;
	}

	public JButton getBtnJeVeuxEtreC() {
		return btnJeVeuxEtreC;
	}

	public void setBtnJeVeuxEtreC(JButton btnJeVeuxEtreC) {
		this.btnJeVeuxEtreC = btnJeVeuxEtreC;
	}

}
