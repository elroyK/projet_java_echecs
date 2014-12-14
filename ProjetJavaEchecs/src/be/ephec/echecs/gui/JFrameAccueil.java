package be.ephec.echecs.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.ephec.echecs.tcp.*;

import java.awt.GridBagLayout;
import java.security.cert.CRLReason;

public class JFrameAccueil extends JFrame {
	protected JButton btnJeVeuxEtreS;
	protected JButton btnJeVeuxEtreC;
	protected JPanel contentPane;
	
	
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
								
					JFrameAccueil frame = new JFrameAccueil();
					ControlerTCP c = new ControlerTCP(frame);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameAccueil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Launcher");
		contentPane = new JPanelAccueil();
		setContentPane(contentPane);
	}

}
