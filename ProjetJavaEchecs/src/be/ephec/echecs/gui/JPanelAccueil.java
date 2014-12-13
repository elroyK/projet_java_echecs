package be.ephec.echecs.gui;

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
import java.net.UnknownHostException;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JPanelAccueil extends JPanel {
	public String txtIp = new String();
	private JTextField txtIpAdrverse;
	
	public String getTxtIp() {
		return txtIp;
	}

	public void setTxtIp(String txtIp) {
		this.txtIp = txtIp;
	}
	
	/**
	 * Create the panel.
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
		GridBagConstraints gbc_btnJeVeuxEtreS = new GridBagConstraints();
		gbc_btnJeVeuxEtreS.insets = new Insets(0, 0, 5, 5);
		gbc_btnJeVeuxEtreS.gridx = 3;
		gbc_btnJeVeuxEtreS.gridy = 2;
		add(btnJeVeuxEtreS, gbc_btnJeVeuxEtreS);
		
		/*Bouton d'accueil pour devenir client*/ 
		JButton btnJeVeuxEtreC = new JButton("Je veux etre client");
		GridBagConstraints gbc_btnJeVeuxEtreC = new GridBagConstraints();
		gbc_btnJeVeuxEtreC.insets = new Insets(0, 0, 5, 0);
		gbc_btnJeVeuxEtreC.gridx = 6;
		gbc_btnJeVeuxEtreC.gridy = 2;
		add(btnJeVeuxEtreC, gbc_btnJeVeuxEtreC);
		
		txtIpAdrverse = new JTextField();
		txtIpAdrverse.setText("Ip adverse : ");
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
		gbc_textArea.gridwidth = 4;
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 3;
		gbc_textArea.gridy = 5;
		add(textArea, gbc_textArea);
		}
	
	
	
		
	
	public JTextField getTxtIpAdrverse() {
		return txtIpAdrverse;
	}

	public void setTxtIpAdrverse(JTextField txtIpAdrverse) {
		this.txtIpAdrverse = txtIpAdrverse;
	}

	public String getIp(){
		try {
			txtIp = Inet4Address.getLocalHost().toString();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return txtIp;
	}
	
	}
	
