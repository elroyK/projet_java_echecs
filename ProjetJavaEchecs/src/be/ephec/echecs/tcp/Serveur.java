package be.ephec.echecs.tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 *La classe Serveur permet de créer un serveur à l'aide d'un ServerSocket
 *date de création : 12/12/14
 *date de modification : 14/12/14
 *@author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * 
 */
 
public class Serveur {
	
	protected ServerSocket serverSocket;
	protected Socket socketForAccept;
	
	protected ObjectOutputStream out;
	protected ObjectInputStream in;
	
	protected int numPort = 62500;
	
	/**
	 * Constructeur de la classe Serveur, se connecte directement sur le port passé 
	 * en variable (numPort)
	 */
	
	public Serveur(){
			try {
				serverSocket = new ServerSocket(numPort);
				JOptionPane.showMessageDialog(null, "Serveur à l'écoute sur le port "+numPort);
				socketForAccept = serverSocket.accept();
				
				out = new ObjectOutputStream(socketForAccept.getOutputStream());
					out.flush();
				
				in = new ObjectInputStream(socketForAccept.getInputStream());

			} catch (IOException e) {
					e.printStackTrace();
			}

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
		socketForAccept.close();
	}
	
}