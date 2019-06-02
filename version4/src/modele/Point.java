package modele;

/**
 * classe servant a gerer des points
 */
public class Point {

	private int x, y;
	
	/**
	 * construit un point
	 * @param x et y coordonnees d'un point
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * methode qui calcule la distance entre deux points
	 * @param p point avec lequel calculer la distance
	 * @return la distance entre le point actuel et le point passe en parametres
	 */
	public double distance(Point p) {
		return Math.sqrt(Math.pow((p.rendreX()-this.rendreX()), 2)+Math.pow((p.rendreY()-this.rendreY()), 2));
	}
	
	/**
	 * getter de l'abscisse
	 * @return l'abscisse du point
	 */
	public int rendreX() {
		return x;
	}

	/**
	 * getter de l'ordonnee
	 * @return l'ordonnee du point
	 */
	public int rendreY() {
		return y;
	}
	
	/**
	 * methode qui permet d'incrementer x
	 * @param dx valeur a ajouter a x
	 */
	public void incrementerX(int dx) {
		this.x += dx;
	}
	
	/**
	 * methode qui permet d'incrementer y
	 * @param dy valeur a ajouter a dy
	 */
	public void incrementerY(int dy) {
		this.y += dy;
	}
	
	/**
	 * setter de x
	 * @param x
	 */
	public void modifierX(int x) {
		this.x = x;
	}
	
	/**
	 * setter de y
	 * @param y
	 */
	public void modifierY(int y) {
		this.y = y;
	}
	
	/**
	 * methode qui fais translater un point 
	 * @param dx
	 * @param dy
	 */
	public void translation(int dx, int dy) {
		this.incrementerX(dx);
		this.incrementerY(dy);
	}
}
