package controleur;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import modele.DessinModele;
import vue.VueDessin;

public class PanneauChoix extends JPanel{
	
	private DessinModele dmodele;
	private VueDessin vdessin;
	private JRadioButton nouvelleFigure, traceMainLeve, manip;
	
	

	public JRadioButton getNouvelleFigure() {
		return nouvelleFigure;
	}

	public void setNouvelleFigure(JRadioButton nouvelleFigure) {
		this.nouvelleFigure = nouvelleFigure;
	}

	public JRadioButton getTraceMainLeve() {
		return traceMainLeve;
	}

	public void setTraceMainLeve(JRadioButton traceMainLeve) {
		this.traceMainLeve = traceMainLeve;
	}

	public JRadioButton getManip() {
		return manip;
	}

	public void setManip(JRadioButton manip) {
		this.manip = manip;
	}

	public PanneauChoix(VueDessin vd) {
		ButtonGroup bg = new ButtonGroup();
		nouvelleFigure = new JRadioButton("Nouvelle Figure");
		traceMainLeve = new JRadioButton("Trace a main levee");
		manip = new JRadioButton("Manipulations");
		bg.add(nouvelleFigure);
		bg.add(traceMainLeve);
		bg.add(manip);
		vdessin = vd;
	}
	
	public Color determineCouleur(int i) {
		Color c = null;
		return c;
	}
	
}
