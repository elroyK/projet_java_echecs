package be.ephec.echecs.tcp;

import java.awt.EventQueue;

import be.ephec.echecs.gui.JFrameServeur;
import be.ephec.echecs.tcp.MonServeurTCP;

public class ApplicationServeur {
	private JFrameServeur jFrameServeur;
	private MonServeurTCP serveur;

	public ApplicationServeur(){
		jFrameServeur = new JFrameServeur(this);
		jFrameServeur.setVisible(true);
	}

	public JFrameServeur getjFrameServeur() {
		return jFrameServeur;
	}

	public void setjFrameServeur(JFrameServeur jFrameServeur) {
		this.jFrameServeur = jFrameServeur;
	}

	public MonServeurTCP getServeur() {
		return serveur;
	}

	public void setServeur(MonServeurTCP serveur) {
		this.serveur = serveur;
	}

	public static void main(String[] args) {
		ApplicationServeur applicationServeur = new ApplicationServeur();

	}

}


