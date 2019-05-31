package modele;

import java.awt.*;

public class Cercle extends FigureColoree {
	
	private int x1, y1, taille;
	
	public Cercle() {
		super();
	}

	@Override
	public FigureColoree recree() {
		FigureColoree fc = new Cercle();
		fc.couleur = this.couleur;
		return fc;
	}

	@Override
	public int nbPoints() {
		return 2;
	}

	@Override
	public int nbClics() {
		return nbPoints();
	}

	@Override
	public void modifierPoints(Point[] tab_saisie) {
		x1 = tab_saisie[0].rendreX();
		y1 = tab_saisie[0].rendreY();
		int x2 = tab_saisie[1].rendreX();
		int y2 = tab_saisie[1].rendreY();
		taille = (int)Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
	}
	
	@Override
	public void affiche(Graphics g) {
		super.affiche(g);
		g.fillOval(x1, y1, taille, taille);
		
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
