package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import modele.DessinModele;
import modele.FigureColoree;
import modele.Point;

public class FabricantFigures implements MouseListener {
	
	private DessinModele model;
	private Point[] pointsCliques;
	private int nbClic=0;
	FigureColoree figureEnCours=null;

	/**
	 * methode pour commencer une figure
	 * @param f figure en cours
	 */
	public void debutCreation(FigureColoree f) {
		figureEnCours=f;
		pointsCliques = new Point[f.nbClics()];
		nbClic=0;
	}

	/**
	 * methode pour ajouter les points plac�s par l'utilisateur dans le tableau de points et ajouter la figure en cours � la liste des figures cr��es
	 * @param x abscisse d'un point
	 * @param y ordonnee d'un point
	 */
	public void ajoutePoint(int x, int y) {
		pointsCliques[nbClic++] = new Point(x,y);
		if (nbClic == pointsCliques.length) {
			model.ajoute(figureEnCours);
			figureEnCours.modifierPoints(pointsCliques);
			figureEnCours = figureEnCours.recree();
			model.setFigureEnCours(figureEnCours);
			debutCreation(figureEnCours);
		}
	}
	
	public FabricantFigures(DessinModele dm) {
		
		this.model=dm;
	}

	public void setModele(DessinModele m) {
		model = m;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		ajoutePoint(arg0.getX(), arg0.getY());
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
