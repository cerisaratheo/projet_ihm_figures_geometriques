package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

import controleur.FabricantFigures;
import controleur.PanneauChoix;
import modele.DessinModele;
import vue.VueDessin;

public class Fenetre {
	
	private static JPanel principal;

	public static void main(String[] args) {
		DessinModele mod = new DessinModele();

		JFrame fenetre = new JFrame("Figures Géométriques");
		fenetre.setDefaultCloseOperation(fenetre.EXIT_ON_CLOSE);
		fenetre.setPreferredSize(new Dimension(1000, 700));
		PanneauChoix pc = new PanneauChoix(mod);
		principal = new JPanel();
		fenetre.add(pc, BorderLayout.NORTH);
		fenetre.add(principal, BorderLayout.CENTER);
		FabricantFigures controleur = new FabricantFigures(mod);
		VueDessin vd = new VueDessin();
		fenetre.add(vd);
		vd.addMouseListener(controleur);
		vd.requestFocus();
		mod.addObserver(vd);
		fenetre.pack();
		fenetre.setVisible(true);
	}
}
