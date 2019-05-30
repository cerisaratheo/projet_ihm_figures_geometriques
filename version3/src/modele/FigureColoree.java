package modele;

import java.awt.*;

public abstract class FigureColoree {

	static final private int TAILLE_CARRE_SELECTION = 5;
	protected boolean selected;
	protected Color couleur;
	protected Point[] tab_mem;
	
	public FigureColoree() {
		this.selected = false;
		this.couleur = Color.BLACK;
		this.tab_mem = new Point[nbPoints()];
	}

	public abstract boolean estDedans(int x, int y);

	public abstract FigureColoree recree();
	
	public abstract int nbPoints();
	
	public abstract int nbClics();
	
	public abstract void modifierPoints(Point[] p);
			
	public void affiche(Graphics g) {
		g.setColor(couleur);
		Color save = couleur;
		if (selected) {
			for (int i = 0; i < tab_mem.length; i++) {
				int x = tab_mem[i].rendreX();
				int y = tab_mem[i].rendreY();
				g.fillRect(x - TAILLE_CARRE_SELECTION, y - TAILLE_CARRE_SELECTION, TAILLE_CARRE_SELECTION * 2, TAILLE_CARRE_SELECTION * 2);
			}
			g.setColor(save);
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
		
	public void translation(int dx, int dy) {
		for (int i = 0; i < tab_mem.length; i++) {
			tab_mem[i].translation(dx, dy);
		}
		this.modifierPoints(tab_mem);
	}
	
	public void transformation(int dx, int dy, int indice) {
		tab_mem[indice].modifierX(dx);
		tab_mem[indice].modifierY(dy);
		this.modifierPoints(tab_mem);
	}
	
	public int carreDeSelection(int x, int y) {
		int i = 0;
		int res = -1;
		
		boolean arret = false;
		
		while (!arret && i < tab_mem.length) {
			if ((x >= (tab_mem[i].rendreX() - TAILLE_CARRE_SELECTION)) && (x <= (tab_mem[i].rendreX() + TAILLE_CARRE_SELECTION)) 
				&& (y >= (tab_mem[i].rendreY()-TAILLE_CARRE_SELECTION)) && (y <= (tab_mem[i].rendreY()+TAILLE_CARRE_SELECTION))) {
				res = i;
				arret = true;
			}
			else {
				i++;
			}
		}
		return res;
	}
}
