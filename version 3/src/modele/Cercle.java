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

}
