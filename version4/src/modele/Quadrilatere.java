package modele;

public class Quadrilatere extends Polygone {

	/**
	 * construit un quadrilatere
	 */
	public Quadrilatere() {
		super();	
	}
	
	
	/**
	 * methode qui indique le nombre de points necessaires pour creer un quadrilatere
	 * @return le nombre de point necessaire pour creer un quadrilatere
	 */
	public int nbPoints() {
		return 4;
	}
	
	/**
	 * methode qui permet de recreer la figure apres l'avoir modifiee
	 */
	@Override
	public FigureColoree recree() {
		FigureColoree fc = new Quadrilatere();
		fc.couleur = this.couleur;
		return fc;
	}
}
