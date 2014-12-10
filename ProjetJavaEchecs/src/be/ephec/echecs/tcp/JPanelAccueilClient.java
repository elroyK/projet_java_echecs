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
	
	
	
	public JPanelAccueilClient(final ApplicationClient applicationClient) {
		this.applicationClient = applicationClient;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0,0,0,0,0,0,0,0,0,0,};
		gridBagLayout.rowHeights = new int[]{0,0,0,0,0,0,0,0};
		gridBagLayout.columnWeights = new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
	
	
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
				applicationClient.setClient(new ClientTCP());
				applicationClient.getjFrameClient().setContentPane(new Echiquier());//remplacer le null par la fenetre de jeu
				applicationClient.getjFrameClient().setVisible(true);
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
