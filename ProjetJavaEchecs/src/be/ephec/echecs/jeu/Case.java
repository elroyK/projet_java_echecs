package be.ephec.echecs.jeu;
/**
 * Classe Case, représentant une case de l'échiquier
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 25/11/14
 * date de modification : 25/11/14
 */

//import javax.swing.JButton;

public class Case {
	public static String BLANC = "BLANC";
	public static String NOIR  = "NOIR";
	public static String LIBRE = "LIBRE";
	
	protected boolean couleur; /* noire (false) - blanc (true) */
//	protected JButton button;
	protected String estOccupe;
	
	/**
	 * Constructeur de la classe Case
	 * @param col : Booleen représentant true (Blanc) et false(Noir)
	 */
	
	public Case(Boolean col) {
		if (col == true) {
			setCouleur(true);
			setBackground(couleur);
		} else {
			setCouleur(true);
			setBackground(couleur);
		}
		
		/* TODO : Mettre le JButton en invisible
		 * 		: Définir la taille d'un coté en pixels
		 */
	}

	/**
	 * Permet de mettre le fond de la case en noir ou blanc
	 * @param col : couleur 
	 */
	
	public void setBackground(Boolean col) {
		if (col==true){
			// TODO : METTRE LA COULEUR DU BOUTON EN BLANC
		} else  {
			// TODO : METTRE LA COULEUR DU BOUTON EN NOIR
		}
	}
	
	/**
	 * Permet de mettre une icône representant une pièce sur une case
	 * @param add : Adresse de l'image à mettre en fond
	 */
	
	public void setImage(String add) {
		// TODO : METTRE UNE IMAGE EN FOND DE CASE
	}
	
	/**
	 * TOUS LES GETTERS ET SETTERS
	 */
	
	public Boolean getCouleur() {
		return couleur;
	}

	public void setCouleur(Boolean couleur) {
		this.couleur = couleur;
	}

	public String getEstOccupe() {
		return estOccupe;
	}

	public void setEstOccupe(String estOccupe) {
		this.estOccupe = estOccupe;
	}
}
