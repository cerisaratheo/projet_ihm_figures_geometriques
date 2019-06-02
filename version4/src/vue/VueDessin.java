package vue;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;

import javax.swing.JPanel;

import controleur.FabricantFigures;
import controleur.ManipulateurFormes;
import controleur.TraceurFormes;
import controleur.Trait;
import modele.DessinModele;
import modele.FigureColoree;

public class VueDessin extends JPanel implements Observer{
	
	private ArrayList<FigureColoree> lfc;
	private ManipulateurFormes mf = null;
	private FabricantFigures ff = null;
	private TraceurFormes tf;
	
	/**
	 * construit la vue et initialise la liste de figures
	 */
	public VueDessin() {
		lfc = new ArrayList<FigureColoree>();
	}
	
	/**
	 * methode qui met a jour les modifcations de la figure
	 */
	public void update(Observable obs, Object obj) {
		DessinModele dessin = ((DessinModele)obs);
		lfc = dessin.getLfc();
		repaint();
		this.requestFocus();
		if (mf==null) mf = new ManipulateurFormes(dessin, this);
		if (ff==null) ff = new FabricantFigures(dessin);
	}
	
	/**
	 * methode qui affiche les elements graphiques
	 */
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		for (FigureColoree c : lfc) {
			c.affiche(g);
		}
		if (tf != null) {
			for (Trait t: tf.getTableauTraits()) {
				g.setColor(t.getCouleur());
				g.drawLine(t.getDebx(),t.getDeby(),t.getFinx(),t.getFiny());
			}
		}
	}
	
	/**
	 * methode qui chage la couleur d'un trait 
	 * @param c
	 */
	public void trace(Color c) {
		if (tf != null) tf.setColor(c);
	}

	/**
	 * methode qui change le mode en mode dessin (trace a main levee)
	 */
	public void passerModeDessin() {
		{
			MouseListener[] tmp = this.getMouseListeners();
			for (MouseListener m: tmp) this.removeMouseListener(m);
		}
		{
			MouseMotionListener[] tmp = this.getMouseMotionListeners();
			for (MouseMotionListener m: tmp) this.removeMouseMotionListener(m);
		}
		Graphics g = this.getGraphics();
		if (tf == null) tf = new TraceurFormes(g);
		this.addMouseListener(tf);
		this.addMouseMotionListener(tf);
		this.repaint();
	}

	/**
	 * methode qui change le mode en mode manipulation
	 */
	public void passerModeManip() {
		{
			MouseListener[] tmp = this.getMouseListeners();
			for (MouseListener m: tmp) this.removeMouseListener(m);
		}
		{
			MouseMotionListener[] tmp = this.getMouseMotionListeners();
			for (MouseMotionListener m: tmp) this.removeMouseMotionListener(m);
		}
		this.addMouseListener(mf);
		this.addMouseMotionListener(mf);
		this.repaint();
	}
	
	/**
	 * methode qui change le mode en mode creation de figure
	 * @param f
	 */
	public void passerModeCreation(FigureColoree f) {
		{
			MouseListener[] tmp = this.getMouseListeners();
			for (MouseListener m: tmp) this.removeMouseListener(m);
		}
		{
			MouseMotionListener[] tmp = this.getMouseMotionListeners();
			for (MouseMotionListener m: tmp) this.removeMouseMotionListener(m);
		}
		ff.debutCreation(f);
		this.addMouseListener(ff);
		this.revalidate();
	}

}
