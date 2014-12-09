package be.ephec.echecs.tcp;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import be.ephec.echecs.gui.ApplicationServeur;
import be.ephec.echecs.tcp.Param;



public class ServeurTCP extends ServerSocket implements Runnable {
	
	private int numPort;
	private ArrayList<SocketCoteServeur> listeClients = new ArrayList<SocketCoteServeur>();
	private ApplicationServeur applicationServeur;
	
	public ServeurTCP() throws IOException{
		super(Param.NUMPORT);
		numPort = Param.NUMPORT;
		this.applicationServeur = applicationServeur;
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
	
	class SocketCoteServeur implements Runnable{
		private ApplicationServeur applicationServeur;
		private Socket socket;
		private Object objetRecu;
		private ObjectInputStream ois;
		private ObjectOutputStream oos;
	
	
	public SocketCoteServeur(Socket socket, ApplicationServeur applicationServeur){
		this.applicationServeur = applicationServeur;
		this.socket = socket;
		try{
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
		}catch (IOException e){
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread thread = new Thread(this);
		thread.start();
		}
	
	public void envoyer(Object o){
		try{
			oos.writeObject(o);
		}catch (IOException e){
			//TODO auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void run() {
		while (!socket.isClosed()){
			try{
				objetRecu = ois.readObject();
			}catch (ClassNotFoundException | IOException e){
				//TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
		}
	}
		public static void main(String[] args){
		try{
			ServeurTCP monServeur = new ServeurTCP();
			
		}catch(IOException e){
			//TODO auto-generate catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		
			try{
			while ( !this.isClosed()){	
				this.listeClients.add(new SocketCoteServeur(this.accept(), applicationServeur));
				System.out.println("Nouveau client connecté");
				}
			}catch (IOException e){
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	

