package be.ephec.echecs.gui;

import java.awt.EventQueue;

import be.ephec.echecs.tcp.JFrameClient;
import be.ephec.echecs.tcp.ClientTCP;

public class ApplicationClient {
	protected JFrameClient jFrameClient;
	protected ClientTCP client; 
	
	public ApplicationClient(){
		jFrameClient = new JFrameClient(this);
		jFrameClient.setVisible(true);
		
	}

	//TODO Methode qui permet d'acceder au jTextArea plutot que via getters et setters
	
	public JFrameClient getjFrameClient() {
		return jFrameClient;
	}

	public void setjFrameClient(JFrameClient jFrameClient) {
		this.jFrameClient = jFrameClient;
	}

	public ClientTCP getClient() {
		return client;
	}

	public void setClient(ClientTCP client) {
		this.client = client;
	}

	
	public static void main(String[] args) {
		ApplicationClient applicationClient = new ApplicationClient();

	}
	
}
