package modele;

public class Triangle extends Polygone {
	
	public Triangle() {
		super();
	}

	@Override
	public FigureColoree recree() {
		FigureColoree fc = new Triangle();
		fc.couleur = this.couleur;
		return fc;
	}

	@Override
	public int nbPoints() {
		return 3;
	}

}
