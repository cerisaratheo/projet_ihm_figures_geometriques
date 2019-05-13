package controleur;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import modele.DessinModele;
import vue.VueDessin;

public class PanneauChoix extends JPanel{
	
	private DessinModele dmodele;
	private VueDessin vdessin;

	PanneauChoix(VueDessin vd) {
		
		vdessin = vd;
	}
	
	public Color determineCouleur(int i) {
		Color c = null;
		return c;
	}
}
