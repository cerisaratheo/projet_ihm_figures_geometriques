package modele;

public class Rectangle extends Polygone {

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
	public int nbPoints() {
		return 4;
	}

}
