package modele;

public class Quadrilatere extends Polygone {

	public Quadrilatere() {
		super();	
	}
	
	public int nbPoints() {
		return 4;
	}
	
	public FigureColoree recree() {
		return new Quadrilatere();
	}
}
