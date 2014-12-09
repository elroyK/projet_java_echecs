package be.ephec.echecs.tcp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.ephec.echecs.gui.ApplicationServeur;


public class JFrameServeur extends JFrame {

	private JPanel contentPane;
	private ApplicationServeur applicationServeur;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameServeur frame = new JFrameServeur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the frame.
	 */
	public JFrameServeur(ApplicationServeur applicationServeur) {
		this.applicationServeur = applicationServeur; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setVisible(true);
		this.setTitle("Serveur");
		contentPane = new JPanelAccueilServeur(applicationServeur);
		setContentPane(contentPane);
		
	}

}
