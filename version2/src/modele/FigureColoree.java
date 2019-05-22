package modele;

import java.awt.*;

public abstract class FigureColoree {

	static final private int TAILLE_CARRE_SELECTION = 5;
	private boolean selected;
	protected Color couleur;
	private Point[] tab_mem;
	
	public FigureColoree() {
		this.selected = false;
		this.couleur = Color.BLACK;
		this.tab_mem = new Point[nbPoints()];
	}

	public abstract FigureColoree recree();
	
	public abstract int nbPoints();
	
	public abstract int nbClics();
	
	public abstract void modifierPoints(Point[] p);
		
	public void affiche(Graphics g) {
		//g.setColor(this.couleur);
		if (this.selected = true) {
			System.out.println("Les petits carrés devraient s'afficher !");
		}
	}
	
	public void selectionne() {
		this.selected = true;
	}
	
	public void deSelectionne() {
		this.selected = false;
	}
	
	public void changeCouleur(Color c) {
		this.couleur = c;
	}
}
