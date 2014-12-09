package be.ephec.echecs.tcp;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.IOException;
import be.ephec.echecs.tcp.Param;



public class ServeurTCP extends ServerSocket implements Runnable {
	
	private int numPort;
	private ArrayList<Socket> listeClients = new ArrayList<Socket>();
	
	public ServeurTCP() throws IOException{
		super(Param.NUMPORT);
		numPort = Param.NUMPORT;
		Thread thread = new Thread(this);
		thread.start();
	}
	
	/**
	 * Constructeur qui prend un numéro de port et vérifie qu'il est libre, 
	 * si pas libre essaie avec le suivant
	 * @return 
	 * 
	 * @Param numPort actuel (ici déféni par une constante)
	 * @return 
	 * 
	 */
	
	/*public ServerSocket() throws IOException{
		super();
		//implémenter la méthode : si numPort pas libre, on essaie avec le port suivant
	}*/
	
	public static void main(String[] args){
		try{
			ServeurTCP monServeur = new ServeurTCP();
			}
		catch(IOException e){
			//TODO auto-generate catch block
			e.printStackTrace();
					
		}
	}

	@Override
	public void run() {
		
			try{
			while ( !this.isClosed()){	
				this.listeClients.add(this.accept());
				System.out.println("Nouveau client connecté");
				}
			}catch (IOException e){
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	

