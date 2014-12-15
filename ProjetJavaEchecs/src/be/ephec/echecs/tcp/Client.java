package be.ephec.echecs.tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;


/**
* Classe Client : Représente un client à l'aide d'un Socket
* date de création : 12/12/14
* date de modification : 14/12/14
* @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * 
 */

public class Client {
	
	protected Socket socket;
	protected ObjectInputStream in;
	protected ObjectOutputStream out;
	

	/**
	 * Constructeur de la classe client qui attend un adresse ip et un numéro de port
	 * 
	 * @param adr : adresse ip du (serveur pour s'y connecter)
	 * @param port : port du serveur (pour s'y connecter)
	 * 
	 */
	public Client(String adr, int port) throws UnknownHostException, IOException{
		socket = new Socket(adr, port);
		in = new ObjectInputStream(socket.getInputStream());
		out = new ObjectOutputStream(socket.getOutputStream());
			out.flush();
	}
	
	
	public <E> void write(E obj) throws IOException{
		out.writeObject(obj);
			out.flush();
	}
	

	
	public <E> E read(Class<E> readClass) throws ClassNotFoundException, IOException{
		return (E)in.readObject();
	}

	public void close() throws IOException{
		in.close();
		out.close();
		socket.close();
	}
	
}
