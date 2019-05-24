package modele;

import java.util.*;
import java.awt.*;

public class DessinModele extends Observable {
	
	private ArrayList<FigureColoree> lfc = new ArrayList<FigureColoree>();
	private FigureColoree figureEnCours;
	private int nbClic;
	private Point[] pointsCliques;

	public DessinModele() {
		
	}
	
	public int getNbClic() {
		return nbClic;
	}
	
	public void setNbClic(int i) {
		nbClic = i;
	}
	
	public FigureColoree getFigureEnCours() {
		return figureEnCours;
	}
	
	public void setFigureEnCours(FigureColoree fc) {
		figureEnCours = fc;
		nbClic = 0;
	}
	
	public ArrayList<FigureColoree> getLfc() {
		return this.lfc;
	}
	
	public void setLfc(ArrayList<FigureColoree> p_lfc) {
		lfc=p_lfc;
	}
	
	public void changeCoul(FigureColoree fc, Color c) {
		fc.changeCouleur(c);
		setChanged();
		notifyObservers();
	}
	
	public void construit(FigureColoree fc) {
		figureEnCours = fc;
		nbClic = 0;
		pointsCliques = new Point[fc.nbPoints()];
		setChanged();
		notifyObservers();
	}
	
	public void ajoute(FigureColoree fc) {
		lfc.add(fc);
		fc.modifierPoints(pointsCliques);
	}
	
	public void ajoutePoint(int x, int y) {

		if (pointsCliques == null || figureEnCours == null) {
			return;
		}
		
		pointsCliques[nbClic++] = new Point(x,y);
		if (nbClic == figureEnCours.nbClics()) {
			this.ajoute(figureEnCours);
			figureEnCours = figureEnCours.recree();
			nbClic = 0;
		}
		setChanged();
		notifyObservers();
	}
}
