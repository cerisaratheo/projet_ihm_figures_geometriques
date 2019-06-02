package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

import controleur.FabricantFigures;
import controleur.ManipulateurFormes;
import controleur.PanneauChoix;
import modele.DessinModele;
import vue.VueDessin;

/**
 * classe contenant le main
 */
public class Fenetre {
	
	private static JPanel principal;

	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {
		DessinModele mod = new DessinModele();

		JFrame fenetre = new JFrame("Figures Géométriques");
		fenetre.setDefaultCloseOperation(fenetre.EXIT_ON_CLOSE);
		fenetre.setPreferredSize(new Dimension(1000, 700));
		VueDessin vd = new VueDessin();
		PanneauChoix pc = new PanneauChoix(mod, vd);
		principal = new JPanel();
		fenetre.add(pc, BorderLayout.NORTH);
		fenetre.add(principal, BorderLayout.CENTER);
		fenetre.add(vd);
		mod.addObserver(vd);
		mod.modeleChange();
		fenetre.pack();
		fenetre.setVisible(true);
	}
}
