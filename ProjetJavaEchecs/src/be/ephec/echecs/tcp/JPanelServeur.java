package be.ephec.echecs.tcp;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JTextArea;

public class JPanelServeur extends JPanel {
	private JTextField txtMessaegEnvoyer;

	/**
	 * Create the panel.
	 */
	public JPanelServeur() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		txtMessaegEnvoyer = new JTextField();
		txtMessaegEnvoyer.setText("Message à envoyer");
		GridBagConstraints gbc_txtMessaegEnvoyer = new GridBagConstraints();
		gbc_txtMessaegEnvoyer.gridwidth = 5;
		gbc_txtMessaegEnvoyer.insets = new Insets(0, 0, 5, 5);
		gbc_txtMessaegEnvoyer.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMessaegEnvoyer.gridx = 3;
		gbc_txtMessaegEnvoyer.gridy = 1;
		add(txtMessaegEnvoyer, gbc_txtMessaegEnvoyer);
		txtMessaegEnvoyer.setColumns(10);
		
		JButton btnEnvoyer = new JButton("Envoyer");
		GridBagConstraints gbc_btnEnvoyer = new GridBagConstraints();
		gbc_btnEnvoyer.insets = new Insets(0, 0, 5, 0);
		gbc_btnEnvoyer.gridx = 10;
		gbc_btnEnvoyer.gridy = 2;
		add(btnEnvoyer, gbc_btnEnvoyer);
		
		JTextArea txtrMessagesReus = new JTextArea();
		txtrMessagesReus.setText("Messages reçus : ");
		GridBagConstraints gbc_txtrMessagesReus = new GridBagConstraints();
		gbc_txtrMessagesReus.insets = new Insets(0, 0, 0, 5);
		gbc_txtrMessagesReus.fill = GridBagConstraints.BOTH;
		gbc_txtrMessagesReus.gridx = 2;
		gbc_txtrMessagesReus.gridy = 3;
		add(txtrMessagesReus, gbc_txtrMessagesReus);

	}

}
