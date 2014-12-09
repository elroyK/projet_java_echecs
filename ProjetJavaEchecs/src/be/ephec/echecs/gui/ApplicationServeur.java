package be.ephec.echecs.gui;

import java.awt.EventQueue;

import be.ephec.echecs.tcp.JFrameServeur;
import be.ephec.echecs.tcp.ServeurTCP;

public class ApplicationServeur {
	protected JFrameServeur jFrameServeur;
	protected ServeurTCP serveur; 
	
	public ApplicationServeur(){
		jFrameServeur = new JFrameServeur(this);
		jFrameServeur.setVisible(true);
		
	}

	//TODO Methode qui permet d'acceder au jTextArea plutot que via getters et setters
	
	public JFrameServeur getjFrameServeur() {
		return jFrameServeur;
	}

	public void setjFrameServeur(JFrameServeur jFrameServeur) {
		this.jFrameServeur = jFrameServeur;
	}

	public ServeurTCP getServeur() {
		return serveur;
	}

	public void setServeur(ServeurTCP serveur) {
		this.serveur = serveur;
	}

	
	public static void main(String[] args) {
		ApplicationServeur applicationServeur = new ApplicationServeur();

	}
	
}
