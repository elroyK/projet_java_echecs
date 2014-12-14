package be.ephec.echecs.tcp;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JOptionPane;





import be.ephec.echecs.gui.JFrameAccueil;
import be.ephec.echecs.gui.JPanelAccueil;
import be.ephec.echecs.gui.Param;
import be.ephec.echecs.jeu.Position;

public class ControlerTCP { 
	
	protected boolean debug = true;
	protected JFrameAccueil launcher;
	protected JPanelAccueil launcherJP;
	
	private boolean isServeur;
	private String ipAdv;
	
	protected Position cible;
	protected Position cibleAdv;
  
	
	private static int NUMPORT=62500;
	private Serveur serveur = null;
	private Client client = null;
	
	
	public ControlerTCP(JFrameAccueil launcher){
		super();
		this.launcher = launcher; 
		actionBouton();
		
	}
	
	
	public void actionBouton(){ 
	
	/*Action du bouton d'accueil "je veux etre serveur"*/
	launcher.getBtnJeVeuxEtreS().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			clientOuServeur(true);
					
		}
	});
	
	/*Action du bouton d'accueil "je veux etre client"*/
	launcher.getBtnJeVeuxEtreC().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Client");
			clientOuServeur(false);
		}
	});
	}	

	/**
	 * Méthode définissant si le joueur est le client ou le serveur
	 * 
	 * @param b : Définit si c'est un Serveur ou un client
	 */
	
	public void clientOuServeur(boolean b){	
		setServeur(b);
		if(debug)System.out.println("debug isServer : "+b);
		if(getIpFromLauncher()){
			if(isServeur){
				try {
					serveur = new Serveur();
					if(debug) System.out.println("Serveur en ligne et client accepté");
					serveur.write(new String("Bienvenue sur le seveur"));				
				} catch (IOException e) {
					//socketExceptionCatch(serveur);
				}
			} else {
				try {
					client = new Client(ipAdv,NUMPORT);
					String str = client.read(String.class);
					if(debug) System.out.println("Connecté au serveur");
					if(debug) System.out.println(str);
				} catch (IOException | ClassNotFoundException e) {
					//socketExceptionCatch(client);
				}
			}
			launcher.dispose();
			//LANCER LE JEU
			JOptionPane.showMessageDialog(null, "Connexion établie !\n");
		}
		else JOptionPane.showMessageDialog(null, "Adresse Ip non valide");
	}
	
	private void setServeur(boolean isServeur){
		this.isServeur = isServeur;		
	}
	
	/**
	 * Méthode qui obtient l'adresse ip du launcher et la place dans une variable 
	 * 
	 * @return false si l'adresse ip n'est pas valide, sinon True.
	 */
	private boolean getIpFromLauncher(){
		ipAdv = launcherJP.getTxtIpAdrverse().getText();	
		try {
	
			InetAddress ip = InetAddress.getByName(ipAdv);
		} catch (UnknownHostException e) {
			return false;
		}
		return true;
	}
	
	private void showWrongMove(){
		JOptionPane.showMessageDialog(launcher, "Vous ne pouvez pas déplacer votre pièce sur cette position");
	}
	
	private void showWin(){
		JOptionPane.showMessageDialog(launcher, "Vous avez gagné !");
	}
	
	
	/**
	 * Méthode gérant l'envoi du client
	 */
	private void clientEnvoi(){
		try {
			client.write(cible);
			if(client.read(boolean.class)) {  
				//Do something
			}else{
				showWrongMove();			
			}
		} catch (IOException | HeadlessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		//if(nbr de piece du joueur = 0){
			showWin();
		}
	}
 

