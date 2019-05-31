package modele;

import java.awt.*;

public abstract class Polygone extends FigureColoree {

	protected Polygon p;
	
	
	public Polygone() {
		super();
		this.p = new Polygon();
	}
	
	@Override
	public void affiche(Graphics g) {
		super.affiche(g);
		g.fillPolygon(this.p);
	}
	
	public int nbClics() {
		return nbPoints();
	}
	
	@Override
	public void modifierPoints(Point[] tab_pts) {
		p.reset();
		for (int i = 0; i < tab_pts.length; i++) {
			p.addPoint(tab_pts[i].rendreX(), tab_pts[i].rendreY());
			tab_mem = tab_pts;
		}
	}
	
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
