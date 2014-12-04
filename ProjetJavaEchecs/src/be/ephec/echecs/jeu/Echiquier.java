package be.ephec.echecs.jeu;

import javax.swing.*;
import java.awt.*;

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
		
		}
	
	public void setEchiq(Case c, int x, int y){
		echiq[x][y] = c;
	}
	
}
