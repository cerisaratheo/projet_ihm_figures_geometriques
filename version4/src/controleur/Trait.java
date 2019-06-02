package controleur;

import java.awt.*;

/**
 * classe servant a creer des traits
 */
public class Trait {

	private int debx, deby, finx, finy;
	private Color couleur;
	
	/**
	 * cree un nouveau trait
	 * @param dx, fx, dy, fy coordonnees du trait
	 * @param c couleur du trait
	 */
	public Trait(int dx,int fx,int dy,int fy,Color c) {
		debx = dx;
		deby = dy;
		finx = fx;
		finy = fy;
		couleur = c;
	}
	
	public int getDebx() {
		return debx;
	}
	
	public void setDebx(int debx) {
		this.debx = debx;
	}
	
	public int getDeby() {
		return deby;
	}
	
	public void setDeby(int deby) {
		this.deby = deby;
	}
	
	public int getFinx() {
		return finx;
	}
	
	public void setFinx(int finx) {
		this.finx = finx;
	}
	
	public int getFiny() {
		return finy;
	}
	
	public void setFiny(int finy) {
		this.finy = finy;
	}
	
	public Color getCouleur() {
		return couleur;
	}
	
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	
	
}
