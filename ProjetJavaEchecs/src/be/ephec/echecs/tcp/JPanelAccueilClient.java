package be.ephec.echecs.tcp;


import java.awt.*;

import javax.swing.*;

import be.ephec.echecs.gui.ApplicationClient;
import be.ephec.echecs.jeu.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;


public class JPanelAccueilClient extends JPanel {
	private JTextField textField;
	private ApplicationClient applicationClient; 
	private JTextField textField_1;
	
	
	
	public JPanelAccueilClient(final ApplicationClient applicationClient) {
		this.applicationClient = applicationClient;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0,0,0,0,0,0,0,0,0,0,};
		gridBagLayout.rowHeights = new int[]{0,0,0,0,0,0,0,0};
		gridBagLayout.columnWeights = new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblAdresseIp = new JLabel("Adresse IP");
		GridBagConstraints gbc_lblAdresseIp = new GridBagConstraints();
		gbc_lblAdresseIp.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresseIp.anchor = GridBagConstraints.EAST;
		gbc_lblAdresseIp.gridx = 7;
		gbc_lblAdresseIp.gridy = 3;
		add(lblAdresseIp, gbc_lblAdresseIp);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 8;
		gbc_textField_1.gridy = 3;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
	
	
		JLabel lblNumDePort = new JLabel("Numero de port");
		GridBagConstraints gbc_lblNumDePort = new GridBagConstraints();
		gbc_lblNumDePort.insets = new Insets(0,0,5,5);
		gbc_lblNumDePort.anchor = GridBagConstraints.EAST; 
		gbc_lblNumDePort.gridx = 7;
		gbc_lblNumDePort.gridy = 4;
		add(lblNumDePort, gbc_lblNumDePort);
		
		textField = new JTextField();
		textField.setText(Param.NUMPORT+"");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets (0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 8;
		gbc_textField.gridy = 4;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnDemarrerLeClient = new JButton("Demarrer le Client");
		btnDemarrerLeClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try{
				// TODO A ameliorer ou update en fonction de ce qu'on décide d'afficher au lancement du serveur/client
				applicationClient.setClient(new ClientTCP());
				Partie frame = new Partie();
				frame.main(null);                                  
				applicationClient.getjFrameClient().setVisible(false);
				}catch (IOException e){
					//TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnDemarrerLeClient = new GridBagConstraints();
		gbc_btnDemarrerLeClient.gridx = 8;
		gbc_btnDemarrerLeClient .gridy = 6;
		add(btnDemarrerLeClient, gbc_btnDemarrerLeClient );
	}

}
