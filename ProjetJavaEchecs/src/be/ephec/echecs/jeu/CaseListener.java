package be.ephec.echecs.jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CaseListener implements ActionListener {
	
	protected Partie game;
	
	public CaseListener(Partie game){
		super();
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.game.plateau.echiq[game.settings.clic1.getX()][game.settings.clic1.getY()].actions(game);
	}

}
