package be.ephec.echecs.jeu;
/**
 * Classe Fou, repr�sentant la pi�ce Fou
 * @author Leroy Christophe - Pierret Cyril - Yaranossian Enzo
 * date de cr�ation : 26/11/14
 * date de modification : 03/02/14
 */
	
	public class Fou extends Piece {
	
		/**
		 * Constructeur de la classe Fou
		 * @param x : position en x
		 * @param y : position en y
		 * @param addImage : adresse de l'image
		 */
		
		public Fou (int x, int y, String addImage) {
			super("Fou",addImage,true,x,y);
		}
		
		/**
		 * Proc�dure qui g�n�re l'ensemble des positions possible de la pi�ce � partir
		 * de sa position actuelle
		 * @return work = tableau de la classe Position, contenant un couple de coord (x,y)
		 */
		
		public Position[] genererPos(){
			
			Position work [] = new Position[14]; 
			int tempX = pos.getX() + 1;
			int tempY = pos.getY() + 1;
			int i = 0;
			
			/*boucle pour la diagonale haute droite */
			while ((tempX <= 8)&&(tempY <= 8)) {
				work[i].setX(tempX);
				work[i].setY(tempY);
				i++;
				tempX++;
				tempY++;
			}
			
			tempX = pos.getX() - 1;
			tempY = pos.getY() + 1;
			
			/*boucle pour la diagonale haute gauche*/
			while ((tempX >= 1)&&(tempY <= 8)) {
				work[i].setX(tempX);
				work[i].setY(tempY);
				i++;
				tempX--;
				tempY++;
			}
			
			tempX = pos.getX() + 1;
			tempY = pos.getY() - 1;
			
			/*boucle pour la diagonale basse droite*/
			while ((tempX >= 8)&&(tempY <= 1)) {
				work[i].setX(tempX);
				work[i].setY(tempY);
				i++;
				tempX++;
				tempY--;
			}
			
			tempX = pos.getX() - 1;
			tempY = pos.getY() - 1;
			
			/*boucle pour la diagonale basse gauche*/
			while ((tempX >= 1)&&(tempY <= 1)) {
				work[i].setX(tempX);
				work[i].setY(tempY);
				i++;
				tempX--;
				tempY--;
			}
			
			return work;
		}
		
		/**
		 * M�thode qui illustre le mouvement de la pi�ce. Compare le tableau de position possible g�n�r�
		 * par genererPos() avec l'ensemble des positions sur l'�chiquier
		 * L'algo r�gle les cases cliquables ou non en fonction de certaines conditions (r�gle du jeu...)
		 */
		
		public void move(Echiquier plateau) {
			Position[] deplacements = this.genererPos();
			for (int i=0;i<8;i++) {
				for (int j=0;j<8;j++){
					
					//TODO : Simplifier le code en remettant tout en diff�rentes m�hodes
					// TODO : Ajouter methode kill
					for (int w=0;w<8;w++) {
						if (deplacements[w].equals(plateau.echiq[i][j].pos)) {
							//pi�ce qui se d�place est de couleur noire
							if(this.getColor()== Param.NOIR){
								//si la pi�ce qui est sur une position possible est blanche
								if(plateau.echiq[i][j].getEstOccupe()==Param.BLANC){
									plateau.echiq[i][j].setCliquable(true);
								}
									else{
										plateau.echiq[i][j].setCliquable(false);
									}
								}
							//pi�ce qui se d�place est de couleur blanche
							if(this.getColor()== Param.BLANC){
								//si la pi�ce qui est sur une position possible est noire
								if(plateau.echiq[i][j].getEstOccupe()==Param.NOIR){
									plateau.echiq[i][j].setCliquable(true);
									}
								else{
									plateau.echiq[i][j].setCliquable(false);
								}
							}
														
						} 
						else{
							plateau.echiq[i][j].setCliquable(false);
						}
					
					}
				}
			}
		}
	}
					