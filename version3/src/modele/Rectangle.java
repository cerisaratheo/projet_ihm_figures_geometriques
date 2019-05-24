package modele;

import java.awt.Graphics;

public class Rectangle extends Polygone {

	private int x1, y1, x2, y2, x3, y3;
	private Point hg, hd, bg;
	private double L, l;
	
	public Rectangle() {
		super();
	}
	
	@Override
	public FigureColoree recree() {
		FigureColoree fc = new Rectangle();
		fc.couleur = this.couleur;
		return fc;
	}

	@Override
	public int nbPoints() {
		return 3;
	}
	
	@Override
	public void modifierPoints(Point[] tab_saisie) {
		this.x1 = tab_saisie[0].rendreX();
		this.y1 = tab_saisie[0].rendreY();
		this.x2 = tab_saisie[1].rendreX();
		this.y2 = tab_saisie[1].rendreY();
		this.x3 = tab_saisie[2].rendreX();
		this.y3 = tab_saisie[2].rendreY();
		L = tab_saisie[0].distance(tab_saisie[1]);
		l = tab_saisie[1].distance(tab_saisie[2]);
	}
	
	public void transfomation(int dx, int dy, int indice) {
		
	}
	
	@Override
	public void affiche(Graphics g) {
		super.affiche(g);
		g.fillRect(this.x1, this.y1, (int)this.L, (int)this.l);
	}

}
