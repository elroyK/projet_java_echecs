package be.ephec.echecs.tcp;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;

import be.ephec.echecs.gui.ApplicationClient;

public class ClientTCP extends Socket {
	private ApplicationClient applicationClient;

	//TODO A ameliorer
	public ClientTCP() throws IOException, UnknownHostException{
		super("127.0.0.1", Param.NUMPORT);
		Socket socket = new Socket("Enzo", Param.NUMPORT);
		this.applicationClient = applicationClient;
	}
		
	
	/**
	 * Constructeur qui attend l’adresse ip du serveur et le numéro de port
	 */
	
	/*public ClientTCP(InetAddress address, int numPort){
		this.getInetAddress();
		Param.NUMPORT = numPort; 
		
	}*/
	
	public static void main(String[] args) {
		try{
			ClientTCP client = new ClientTCP();
		}catch(IOException e){
			//TODO auto-generate catch block
			e.printStackTrace();
		}	
			

	}

}

