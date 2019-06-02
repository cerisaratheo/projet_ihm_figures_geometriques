package modele;

import java.awt.*;

public abstract class FigureColoree {

	static final private int TAILLE_CARRE_SELECTION = 5;
	protected boolean selected;
	protected Color couleur;
	protected Point[] tab_mem;
	
	/**
	 * constructeur
	 */
	public FigureColoree() {
		this.selected = false;
		this.couleur = Color.BLACK;
		this.tab_mem = new Point[nbPoints()];
	}

	/**
	 * methode qui indique si le curseur est dans la figure
	 * @param x et y coordonnees du clic
	 * @return un booleen qui vaut true si l'utilisateur a clique dans une figure
	 */
	public abstract boolean estDedans(int x, int y);

	/**
	 * methode qui recree la figure apres l'avoir modifiee
	 * @return
	 */
	public abstract FigureColoree recree();
	
	/**
	 * methode qui retourne le nombre de points de la figure
	 * @return
	 */
	public abstract int nbPoints();
	
	/**
	 * methode qui retourne le nombre de clics necessaires pour creer la figure
	 * @return
	 */
	public abstract int nbClics();
	
	/**
	 * methode qui modifie les coordonnees des points pour modifier la figure
	 * @param p
	 */
	public abstract void modifierPoints(Point[] p);
			
	/**
	 * methode qui affiche la figure et les carres de selection
	 * @param g
	 */
	public void affiche(Graphics g) {
		g.setColor(couleur);
		Color save = couleur;
		if (selected) {
			for (int i = 0; i < tab_mem.length; i++) {
				int x = tab_mem[i].rendreX();
				int y = tab_mem[i].rendreY();
				g.setColor(Color.GRAY);
				g.fillRect(x - TAILLE_CARRE_SELECTION, y - TAILLE_CARRE_SELECTION, TAILLE_CARRE_SELECTION * 2, TAILLE_CARRE_SELECTION * 2);
			}
			g.setColor(save);
		}
	}
	
	/**
	 * methode qui selectionne une figure
	 */
	public void selectionne() {
		this.selected = true;
	}

	/**
	 * methode qui deselectionne une figure
	 */
	public void deSelectionne() {
		this.selected = false;
	}
	
	/**
	 * methode qui change la couleur de la figure
	 * @param c
	 */
	public void changeCouleur(Color c) {
		this.couleur = c;
	}
		
	/**
	 * methode qui fais translater les points de la figure
	 * @param dx
	 * @param dy
	 */
	public void translation(int dx, int dy) {
		for (int i = 0; i < tab_mem.length; i++) {
			tab_mem[i].translation(dx, dy);
		}
		this.modifierPoints(tab_mem);
	}
	
	/**
	 * methode qui modifie les points de la figure
	 * @param dx
	 * @param dy
	 * @param indice
	 */
	public void transformation(int dx, int dy, int indice) {
		tab_mem[indice].modifierX(dx);
		tab_mem[indice].modifierY(dy);
		this.modifierPoints(tab_mem);
	}
	
	/**
	 * methode qui cree les coordonnes des carres pour indiquer que la figure est selectionnee
	 * @param x
	 * @param y
	 * @return
	 */
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
