package modele;

import java.awt.*;

public class Ellipse extends FigureColoree {
	
	public Ellipse() {
		super();
	}

	@Override
	public FigureColoree recree() {
		FigureColoree fc = new Ellipse();
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
		int xtopleft = tab_saisie[0].rendreX();
		int ytopleft = tab_saisie[0].rendreY();
		tab_mem = new Point[2];
		tab_mem[0] = new Point(xtopleft, ytopleft);
		int xbotrig= tab_saisie[1].rendreX();
		int ybotrig = tab_saisie[1].rendreY();
		tab_mem[1] = new Point(xbotrig, ybotrig);
	}
	
	@Override
	public void affiche(Graphics g) {
		g.setColor(couleur);
		g.fillOval(tab_mem[0].rendreX(), tab_mem[0].rendreY(), tab_mem[1].rendreX()-tab_mem[0].rendreX(), tab_mem[1].rendreY()-tab_mem[0].rendreY());
		super.affiche(g);
	}

	@Override
	public boolean estDedans(int x, int y) {
		return x>=tab_mem[0].rendreX() && x<tab_mem[1].rendreX() && y>=tab_mem[0].rendreY() && y<tab_mem[1].rendreY();
	}

}
