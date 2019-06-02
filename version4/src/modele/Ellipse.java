package modele;

import java.awt.*;

public class Ellipse extends FigureColoree {
	
	/**
	 * construit une ellipse
	 */
	public Ellipse() {
		super();
	}

	/**
	 * methode qui recree la figure apres l'avoir modifiee
	 */
	@Override
	public FigureColoree recree() {
		FigureColoree fc = new Ellipse();
		fc.couleur = this.couleur;
		return fc;
	}

	/**
	 * methode qui indique le nombre de clics necessaires pour creer la figure
	 * @return le nombre de clics necessaires pour creer une ellipse
	 */
	@Override
	public int nbPoints() {
		return 2;
	}

	/**
	 * methode qui retourne le nombre de clics pour creer la figure en fonction du nombre de points
	 */
	@Override
	public int nbClics() {
		return nbPoints();
	}

	/**
	 * methode qui permet de modifier les points du tableau de points
	 */
	@Override
	public void modifierPoints(Point[] tab_saisie) {
		int xtopleft = tab_saisie[0].rendreX();
		int ytopleft = tab_saisie[0].rendreY();
		tab_mem = new Point[2];
		tab_mem[0] = new Point(xtopleft, ytopleft);
		int xbotrig= tab_saisie[1].rendreX();
		int ybotrig = tab_saisie[1].rendreY();
		tab_mem[1] = new Point(xbotrig, ybotrig);
	}
	
	/**
	 * methode qui permet d'afficher l'ellipse 
	 */
	@Override
	public void affiche(Graphics g) {
		g.setColor(couleur);
		g.fillOval(tab_mem[0].rendreX(), tab_mem[0].rendreY(), tab_mem[1].rendreX()-tab_mem[0].rendreX(), tab_mem[1].rendreY()-tab_mem[0].rendreY());
		super.affiche(g);
	}

	/**
	 * methode qui permet de savoir si on se trouve dans une ellipse ou non
	 * @return un booleen qui vaut true si on clique dans une ellipse
	 */
	@Override
	public boolean estDedans(int x, int y) {
		return x>=tab_mem[0].rendreX() && x<tab_mem[1].rendreX() && y>=tab_mem[0].rendreY() && y<tab_mem[1].rendreY();
	}

}
