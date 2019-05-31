package modele;

import java.awt.*;

public class Cercle extends FigureColoree {
	
	private int xcentre, ycentre, diametre;
	
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
		xcentre = tab_saisie[0].rendreX();
		ycentre = tab_saisie[0].rendreY();
		tab_mem = new Point[2];
		tab_mem[0] = new Point(xcentre, ycentre);
		int x2 = tab_saisie[1].rendreX();
		int y2 = tab_saisie[1].rendreY();
		diametre = (int)(2.*Math.sqrt(Math.pow((x2-xcentre),2) + Math.pow((y2-ycentre),2)));
		tab_mem[1] = new Point(xcentre+diametre/2, ycentre);
	}
	
	@Override
	public void affiche(Graphics g) {
		g.setColor(couleur);
		g.fillOval(xcentre-diametre/2, ycentre-diametre/2, diametre, diametre);
		super.affiche(g);
	}

	@Override
	public boolean estDedans(int x, int y) {
		double distanceAuCentre = Math.sqrt(Math.pow((x-xcentre),2) + Math.pow((y-ycentre),2));
		return distanceAuCentre<diametre/2;
	}

}
