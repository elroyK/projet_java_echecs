package be.ephec.echecs.gui;
/**
* Classe FenPromotion, crée la fenêtre de choix lorsque la promotion est disponible pour un pion
* date de création : 14/12/14
* date de modification : 14/12/14
* @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
* 
*/


import javax.swing.JFrame;
import javax.swing.JPanel;

import be.ephec.echecs.jeu.Echiquier;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;

public class FenPromotion extends JFrame {
	protected String choix;
	private JTextField txtChoisissezEnQuoi;
	
	public String getChoix() {
		return choix;
	}

	public void setChoix(String choix) {
		this.choix = choix;
	}

	public static void main(final String[] tbPiece) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenPromotion fen = new FenPromotion(tbPiece);	
					fen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public FenPromotion(String[] tbPiece) {
		setForeground(new Color(240, 240, 240));
		setBounds(350, 350, 400, 150);
		setResizable(false);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(tbPiece));
		getContentPane().add(comboBox, BorderLayout.CENTER);
		
		txtChoisissezEnQuoi = new JTextField();
		txtChoisissezEnQuoi.setEditable(false);
		txtChoisissezEnQuoi.setText("Choisissez en quoi votre piece sera promue :");
		getContentPane().add(txtChoisissezEnQuoi, BorderLayout.NORTH);
		txtChoisissezEnQuoi.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		getContentPane().add(btnOk, BorderLayout.EAST);
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setChoix(comboBox.getSelectedItem().toString());
			}
		});
		
		
	}

}
