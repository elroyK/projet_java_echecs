package be.ephec.echecs.tcp;

import be.ephec.echecs.gui.JFrameClient;
import be.ephec.echecs.tcp.MonClientTCP;

public class ApplicationClient {
	private MonClientTCP client;
	private JFrameClient jFrameClient;
	
	public ApplicationClient(){
		jFrameClient = new JFrameClient(this);
		jFrameClient.setVisible(true);
	}

	public MonClientTCP getClient() {
		return client;
	}


	public void setClient(MonClientTCP client) {
		this.client = client;
	}


	public JFrameClient getjFrameClient() {
		return jFrameClient;
	}


	public void setjFrameClient(JFrameClient jFrameClient) {
		this.jFrameClient = jFrameClient;
	}


	public static void main(String[] args) {
		ApplicationClient client = new ApplicationClient();

	}

}
