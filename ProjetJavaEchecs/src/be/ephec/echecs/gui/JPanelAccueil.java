package be.ephec.echecs.gui;

/**
* Classe JPanelAccueil, permet de créer le contenu de ce qui sera affiché dans la JFrameAccueil
* date de création : 13/12/14
* date de modification : 15/12/14
* @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
* 
*/

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import be.ephec.echecs.tcp.*;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class JPanelAccueil extends JPanel {
	protected String txtIp = new String();
	protected JTextField txtIpAdrverse;
	
	protected Serveur serveur;
	protected Client client;
	protected String ipAdv;
	protected boolean isServeur;
	
	protected static int NUMPORT=62500;
	
	/**
	 * Constructeur du JPanel
	 */
	public JPanelAccueil() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		/*Bouton d'accueil pour devenir serveur*/
		JButton btnJeVeuxEtreS = new JButton("Je veux etre serveur");
		btnJeVeuxEtreS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			clientOuServeur(true);
						
			}
		});
		
		GridBagConstraints gbc_btnJeVeuxEtreS = new GridBagConstraints();
		gbc_btnJeVeuxEtreS.insets = new Insets(0, 0, 5, 5);
		gbc_btnJeVeuxEtreS.gridx = 3;
		gbc_btnJeVeuxEtreS.gridy = 2;
		add(btnJeVeuxEtreS, gbc_btnJeVeuxEtreS);
		
		/*Bouton d'accueil pour devenir client*/ 
		JButton btnJeVeuxEtreC = new JButton("Je veux etre client");
		btnJeVeuxEtreC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clientOuServeur(false);
			}
		});
	
		GridBagConstraints gbc_btnJeVeuxEtreC = new GridBagConstraints();
		gbc_btnJeVeuxEtreC.insets = new Insets(0, 0, 5, 0);
		gbc_btnJeVeuxEtreC.gridx = 6;
		gbc_btnJeVeuxEtreC.gridy = 2;
		add(btnJeVeuxEtreC, gbc_btnJeVeuxEtreC);
		
		JLabel lblIpAdverse = new JLabel("Ip adverse :");
		GridBagConstraints gbc_lblIpAdverse = new GridBagConstraints();
		gbc_lblIpAdverse.insets = new Insets(0, 0, 5, 5);
		gbc_lblIpAdverse.anchor = GridBagConstraints.EAST;
		gbc_lblIpAdverse.gridx = 2;
		gbc_lblIpAdverse.gridy = 4;
		add(lblIpAdverse, gbc_lblIpAdverse);
		
		txtIpAdrverse = new JTextField();
		GridBagConstraints gbc_txtIpAdrverse = new GridBagConstraints();
		gbc_txtIpAdrverse.gridwidth = 3;
		gbc_txtIpAdrverse.insets = new Insets(0, 0, 5, 5);
		gbc_txtIpAdrverse.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIpAdrverse.gridx = 3;
		gbc_txtIpAdrverse.gridy = 4;
		add(txtIpAdrverse, gbc_txtIpAdrverse);
		txtIpAdrverse.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		getIp();
		textArea.setText("Votre ip est : "+getTxtIp());
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 3;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 3;
		gbc_textArea.gridy = 5;
		add(textArea, gbc_textArea);
		}
	/**
	 * Méthode définissant si le joueur est le client ou le serveur
	 * 
	 * @param b : true si serveur, false si client
	 */
	
	public void clientOuServeur(boolean b){	
		setServeur(b);
		if(getIpFromLauncher()){
			if(isServeur){
				try {
					serveur = new Serveur();
					serveur.write(new String("Bienvenue sur le seveur"));				
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					client = new Client(ipAdv,NUMPORT);
					String str = client.read(String.class);
					 System.out.println(str);
					
				} catch (IOException | ClassNotFoundException e) {
				
				}
			}
		
			JOptionPane.showMessageDialog(null, "Connexion établie !\n");
		}
		else JOptionPane.showMessageDialog(null, "Adresse Ip non valide");
	}
	
	private void setServeur(boolean isServeur){
		this.isServeur = isServeur;		
	}
	
	/**
	 * Méthode qui obtient l'adresse ip du launcher et la place dans une variable 
	 * 
	 * @return false si l'adresse ip n'est pas valide, sinon True.
	 */
	private boolean getIpFromLauncher(){
		ipAdv = getTxtIpAdrverse().getText();	
		try {
	
			InetAddress ip = InetAddress.getByName(ipAdv);
		} catch (UnknownHostException e) {
			return false;
		}
		return true;
	}
	/**
	 * Méthode qui recupère l'adresse ip du pc et la transforme en String 
	 * @return txtIp : adresse ip sous forme d'un string
	 */
	public String getIp(){
		try {
			txtIp = Inet4Address.getLocalHost().toString();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return txtIp;
	}
	
	//GETTERS ET SETTERS
	public JTextField getTxtIpAdrverse() {
		return txtIpAdrverse;
	}

	public void setTxtIpAdrverse(JTextField txtIpAdrverse) {
		this.txtIpAdrverse = txtIpAdrverse;
	}
	
	public String getTxtIp() {
		return txtIp;
	}

	public void setTxtIp(String txtIp) {
		this.txtIp = txtIp;
	}
}	

	
