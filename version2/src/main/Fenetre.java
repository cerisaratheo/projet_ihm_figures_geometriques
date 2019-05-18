package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

import controleur.PanneauChoix;
import vue.VueDessin;

public class Fenetre {
	
	private static JPanel principal, choix;
	private static VueDessin vdessin;

	public static void main(String[] args) {

		JFrame fenetre = new JFrame("Figures Géométriques");
		fenetre.setDefaultCloseOperation(fenetre.EXIT_ON_CLOSE);
		fenetre.setPreferredSize(new Dimension(1000, 700));
		PanneauChoix pc = new PanneauChoix();
		principal = new JPanel();
		choix = new JPanel();
		choix.setLayout(new BorderLayout());
		JPanel radioBox = new JPanel(); 
		JPanel comboBox = new JPanel();
		radioBox.add(pc.getNouvelleFigure());
		radioBox.add(pc.getTraceMainLeve());
		radioBox.add(pc.getManip());
		comboBox.add(pc.getFigList());
		comboBox.add(pc.getCoulList());
		choix.add(radioBox, BorderLayout.NORTH);
		choix.add(comboBox, BorderLayout.SOUTH);
		fenetre.add(choix, BorderLayout.NORTH);
		fenetre.add(principal, BorderLayout.CENTER);
		fenetre.pack();
		fenetre.setVisible(true);
	}
}
