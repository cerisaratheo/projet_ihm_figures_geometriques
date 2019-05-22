package vue;

import java.awt.*;
import java.util.*;

import javax.swing.JPanel;

import modele.DessinModele;
import modele.FigureColoree;

public class VueDessin extends JPanel implements Observer{
	
	private ArrayList<FigureColoree> lfc;

	public VueDessin() {
		lfc = new ArrayList<FigureColoree>();
	}
	
	public void update(Observable obs, Object obj) {
		DessinModele dm = ((DessinModele)obs);
		lfc = dm.getLfc();
		repaint();
		this.requestFocus();
		System.out.println("update");
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		for (FigureColoree c : lfc) {
			c.affiche(g);
		}
	}
}
