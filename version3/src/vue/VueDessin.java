package vue;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;

import javax.swing.JPanel;

import controleur.FabricantFigures;
import controleur.ManipulateurFormes;
import modele.DessinModele;
import modele.FigureColoree;

public class VueDessin extends JPanel implements Observer{
	
	private ArrayList<FigureColoree> lfc;
	private ManipulateurFormes mf = null;
	private FabricantFigures ff = null;

	public VueDessin() {
		lfc = new ArrayList<FigureColoree>();
	}
	
	public void update(Observable obs, Object obj) {
		DessinModele dessin = ((DessinModele)obs);
		lfc = dessin.getLfc();
		repaint();
		this.requestFocus();
		if (mf==null) mf = new ManipulateurFormes(dessin);
		if (ff==null) ff = new FabricantFigures(dessin);
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		for (FigureColoree c : lfc) {
			c.affiche(g);
		}
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
