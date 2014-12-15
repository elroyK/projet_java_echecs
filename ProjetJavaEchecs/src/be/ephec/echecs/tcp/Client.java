package be.ephec.echecs.tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;


/**
* Classe Client : Repr�sente un client � l'aide d'un Socket
* date de cr�ation : 12/12/14
* date de modification : 14/12/14
* @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * 
 */

public class Client {
	
	protected Socket socket;
	protected ObjectInputStream in;
	protected ObjectOutputStream out;
	

	/**
	 * Constructeur de la classe client qui attend un adresse ip et un num�ro de port
	 * 
	 * @param adr : adresse ip du (serveur pour s'y connecter)
	 * @param port : port du serveur (pour s'y connecter)
	 * @throws UnknownHostException si h�te inconnu
	 * @throws IOException si erreur de connexion
	 */
	public Client(String adr, int port) throws UnknownHostException, IOException{
		socket = new Socket(adr, port);
		in = new ObjectInputStream(socket.getInputStream());
		out = new ObjectOutputStream(socket.getOutputStream());
			out.flush();
	}
	
	/**
	 * Ecrit le flux
	 * @param obj : L'objet � envoyer
	 * @param <E> ?
	 * @throws IOException si erreur de connexion
	 */
	public <E> void write(E obj) throws IOException{
		out.writeObject(obj);
			out.flush();
	}
	

	/**
	 * Lit le flux
	 * @param readClass ?
	 * @param <E> ?
	 * @return l'info lue
	 * @throws ClassNotFoundException Si jamais il n'arrive pas � lire
	 * @throws IOException si erreur de connexion
	 */
	public <E> E read(Class<E> readClass) throws ClassNotFoundException, IOException{
		return (E)in.readObject();
	}
	
	/**
	 * Ferme la connexion
	 * @throws IOException si erreur de connexion
	 */
	public void close() throws IOException{
		in.close();
		out.close();
		socket.close();
	}
	
}
