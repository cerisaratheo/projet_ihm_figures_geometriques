package modele;

import java.util.*;
import java.awt.*;

/**
 * classe principale du modele
 */
public class DessinModele extends Observable {
	
	private ArrayList<FigureColoree> lfc = new ArrayList<FigureColoree>();
	private FigureColoree figureEnCours;
	private Color lastCoul = Color.BLACK;

	/**
	 * Constructeur vide
	 */
	public DessinModele() {
	}
	
	/**
	 * methode qui met a jour la vue
	 */
	public void modeleChange() {
		setChanged();
		notifyObservers();
	}
	
	/**
	 * getter de FigureColoree
	 * @return la figure en cours
	 */
	public FigureColoree getFigureEnCours() {
		return figureEnCours;
	}
	
	/**
	 * setter de FigureEnCours
	 * @param fc
	 */
	public void setFigureEnCours(FigureColoree fc) {
		figureEnCours = fc;
	}
	
	/**
	 * getter de la liste de figures en cours
	 * @return la liste des figures en cours
	 */
	public ArrayList<FigureColoree> getLfc() {
		return this.lfc;
	}
	
	/**
	 * setter de la liste de figures en cours
	 * @param p_lfc
	 */
	public void setLfc(ArrayList<FigureColoree> p_lfc) {
		lfc=p_lfc;
	}
	
	/**
	 * methode qui permet de changer la couleur de la FigureColoree
	 * @param fc figure a modifier
	 * @param c nouvelle couleur
	 */
	public void changeCoul(FigureColoree fc, Color c) {
		lastCoul = c;
		if (fc == null) return;
		fc.changeCouleur(c);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * methode qui construit la FigureColoree
	 * @param fc
	 */
	public void construit(FigureColoree fc) {
		figureEnCours = fc;
		fc.changeCouleur(lastCoul);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * methode qui a ajoute une FigureColoree a la liste des figures en cours et met a jour la vue
	 * @param fc
	 */
	public void ajoute(FigureColoree fc) {
		lfc.add(fc);
		modeleChange();
	}
	
}
