package modele;

public class Triangle extends Polygone {
	
	/**
	 * construit un triangle
	 */
	public Triangle() {
		super();
	}

	/**
	 * methode qui recree la figure apres l'avoir modifiee
	 * @return la figure modifiee
	 */
	@Override
	public FigureColoree recree() {
		FigureColoree fc = new Triangle();
		fc.couleur = this.couleur;
		return fc;
	}

	/**
	 * methode qui indique le nombre de points necessaires pour creer la figure
	 * @return le nombre de points necessaires pour creer un rectangle
	 */
	@Override
	public int nbPoints() {
		return 3;
	}

}
