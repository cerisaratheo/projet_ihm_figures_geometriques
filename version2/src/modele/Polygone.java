package modele;

import java.awt.*;

public abstract class Polygone extends FigureColoree {

	private Polygon p;
	
	public Polygone() {
		super();
	}
	
	public void affiche(Graphics g) {
		
	}
	
	public int nbClics() {
		return nbPoints();
	}
	
	public void modifierPoints(Point[] tab_saisie) {
		
		
	}
}
