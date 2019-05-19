package modele;

import java.awt.*;

public abstract class FigureColoree {

	static final private int TAILLE_CARRE_SELECTION = 5;
	private boolean selected;
	private Color couleur;
	
	public FigureColoree() {
		
	}
	
	public abstract int nbPoints();
	
	public abstract int nbClics();
	
	public abstract void modifierPoints(Point[] p);
		
	public void affiche(Graphics g) {
		
	}
	
	public void selectionne() {
		
	}
	
	public void deSelectionne() {
		
	}
	
	public void changeCouleur(Color c) {
		this.couleur=c;
	}
}
