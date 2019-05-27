package modele;

import java.awt.Graphics;

public class Rectangle extends Quadrilatere {
	
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
	public int nbClics() {
		return 2;
	}
	
	@Override
	public void modifierPoints(Point[] tab_saisie) {
		p.addPoint(tab_saisie[0].rendreX(), tab_saisie[0].rendreY());
		p.addPoint(tab_saisie[1].rendreX(), tab_saisie[0].rendreY());
		p.addPoint(tab_saisie[1].rendreX(), tab_saisie[1].rendreY());
		p.addPoint(tab_saisie[0].rendreX(), tab_saisie[1].rendreY());
		tab_mem = tab_saisie;
	}
	
	public void transfomation(int dx, int dy, int indice) {
		tab_mem[indice].modifierX(dx);
		tab_mem[indice].modifierY(dy);
	}

}
