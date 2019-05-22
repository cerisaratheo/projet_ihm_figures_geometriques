package modele;

public class Quadrilatere extends Polygone {

	public Quadrilatere() {
		super();	
	}
	
	public int nbPoints() {
		return 4;
	}
	
	public FigureColoree recree() {
		FigureColoree fc = new Quadrilatere();
		fc.couleur = this.couleur;
		return fc;
	}
}
