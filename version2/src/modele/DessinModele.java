package modele;

import java.util.*;
import java.awt.*;

public class DessinModele extends Observable {
	
	private ArrayList<FigureColoree> lfc;
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
		
		this.figureEnCours = fc;
		nbClic = 0;
		pointsCliques = new Point[fc.nbPoints()];
		setChanged();
		notifyObservers();
	}
	
	public void ajoute(FigureColoree fc) {
		lfc.add(fc);
	}
	
	public void ajoutePoint(int x, int y) {

		pointsCliques[0] = new Point(x,y);
		++nbClic;
		if (nbClic == figureEnCours.nbPoints()) {
			this.ajoute(figureEnCours);
		}
		setChanged();
		notifyObservers();
	}
}
