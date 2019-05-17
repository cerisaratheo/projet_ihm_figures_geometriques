package modele;

import java.util.ArrayList;
import java.util.Observable;

public class DessinModele extends Observable{
	
	private ArrayList<FigureColoree> lfc;
	private FigureColoree figureEnCours;
	private int nbClic;
	private Point[] pointsCliques;

	public DessinModele() {
		
	}
	
	public void construit(FigureColoree fc) {
		
		this.figureEnCours = fc;
		nbClic = 0;
		pointsCliques = new Point[fc.nbPoints()];
	}
	
	public void ajoutePoint(int x, int y) {

		pointsCliques[0] = new Point(x,y);
		++nbClic;
	}
}
