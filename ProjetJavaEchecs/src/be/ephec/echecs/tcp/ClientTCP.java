package be.ephec.echecs.tcp;

import java.net.Socket;
import java.io.IOException;

public class ClientTCP extends Socket {

	public ClientTCP() throws IOException{
		super("127.0.0.1", Param.NUMPORT);
	}
	
	/**
	 * Constructeur qui attend l’adresse ip du serveur et le numéro de port
	 */
	
	/*public Socket (address, int numPort){
		//TODO
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

