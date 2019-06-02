package modele;

import java.awt.*;

/**
 * classe qui gere les polygones
 */
public abstract class Polygone extends FigureColoree {

	protected Polygon p;
	
	/**
	 * construit un polygone
	 */
	public Polygone() {
		super();
		this.p = new Polygon();
	}
	
	/**
	 * methode qui permet d'afficher le polygone	
	 */
	@Override
	public void affiche(Graphics g) {
		super.affiche(g);
		g.fillPolygon(this.p);
	}
	
	/**
	 * methode qui retourne le nombre de clics pour creer la figure en fonction du nombre de points
	 */
	public int nbClics() {
		return nbPoints();
	}
	
	/**
	 * methode qui permet de modifier les points du tableau de points
	 */
	@Override
	public void modifierPoints(Point[] tab_pts) {
		p.reset();
		for (int i = 0; i < tab_pts.length; i++) {
			p.addPoint(tab_pts[i].rendreX(), tab_pts[i].rendreY());
			tab_mem = tab_pts;
		}
	}
	
	/**
	 * methode qui permet de savoir si on se trouve dans le polygone ou non
	 * @return un booleen qui vaut true si on clique dans le polygone
	 */
	@Override
	public boolean estDedans(int x, int y) {
		boolean res = false;
		int[] xpoint = new int[nbPoints()];
		int[] ypoint = new int[nbPoints()];
		for (int i = 0; i < tab_mem.length; i++) {
			xpoint[i] = tab_mem[i].rendreX();
			ypoint[i] = tab_mem[i].rendreY();
		}
		Polygon pol = new Polygon(xpoint, ypoint, nbPoints());
		if (pol.contains(x, y)) {
			res = true;
		}
		return res;
	}
		
}
