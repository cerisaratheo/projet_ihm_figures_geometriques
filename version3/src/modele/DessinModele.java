package modele;

import java.util.*;
import java.awt.*;

public class DessinModele extends Observable {
	
	private ArrayList<FigureColoree> lfc = new ArrayList<FigureColoree>();
	private FigureColoree figureEnCours;
	private Color lastCoul = Color.BLACK;

	public DessinModele() {
	}
	
	public void modeleChange() {
		setChanged();
		notifyObservers();
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
		lastCoul = c;
		if (fc == null) return;
		fc.changeCouleur(c);
		setChanged();
		notifyObservers();
	}
	
	public void construit(FigureColoree fc) {
		figureEnCours = fc;
		fc.changeCouleur(lastCoul);
		setChanged();
		notifyObservers();
	}
	
	public void ajoute(FigureColoree fc) {
		lfc.add(fc);
		modeleChange();
	}
	
}
