package be.ephec.echecs.jeu;
/**
 * Classe Echiquier, représentant le plateau du jeu (8/8 cases)
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de création : 25/11/14
 * date de modification : 25/11/14
 */
public class Echiquier {
	protected Case echiq[][];
	private static int NBCASE = 8;
	
	public Echiquier() {
		int i, j;
		boolean work;
		
		for (i=0;i<NBCASE;i++) {		
			/* Condition pour définir blanc ou noir */
			if ((i % 2) == 0) {	work=true;} 
			else {work=false;}
			
			for (j=0;j<NBCASE;j++) {
				echiq[i][j]= new Case(work);
				echiq[i][j].setEstOccupe(Case.LIBRE);
				/* Inverse la couleur quand on incrémente */
				if (work==true) {work=false;}
				else {work=true;}
				
			}
		}
	}
	
}
