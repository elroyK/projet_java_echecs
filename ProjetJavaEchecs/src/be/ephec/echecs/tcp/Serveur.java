package be.ephec.echecs.tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * La classe Serveur permet de créer un serveur à l'aide d'un Socket
 * 
 */

public class Serveur {
	
	private ServerSocket serverSock;
	private Socket socketForAccept;
	
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	private int numPort = 62500;
	
	
	public Serveur(){
			try {
				serverSock = new ServerSocket(numPort);
				System.out.println("Debug");
				JOptionPane.showMessageDialog(null, "Serveur à l'écoute sur le port "+numPort);
				socketForAccept = serverSock.accept();
				
				out = new ObjectOutputStream(socketForAccept.getOutputStream());
					out.flush();
				
				in = new ObjectInputStream(socketForAccept.getInputStream());

			} catch (IOException e) {

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