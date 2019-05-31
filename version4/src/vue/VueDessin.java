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

	public VueDessin() {
		lfc = new ArrayList<FigureColoree>();
	}
	
	public void update(Observable obs, Object obj) {
		DessinModele dessin = ((DessinModele)obs);
		lfc = dessin.getLfc();
		repaint();
		this.requestFocus();
		if (mf==null) mf = new ManipulateurFormes(dessin, this);
		if (ff==null) ff = new FabricantFigures(dessin);
	}
	
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
	
	public void trace(Color c) {
		if (tf != null) tf.setColor(c);
	}

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
