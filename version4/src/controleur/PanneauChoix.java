package controleur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import modele.Cercle;
import modele.DessinModele;
import modele.FigureColoree;
import modele.Quadrilatere;
import modele.Rectangle;
import modele.Triangle;
import vue.VueDessin;

public class PanneauChoix extends JPanel {

	private DessinModele dmodele;
	private JRadioButton nouvelleFigure, traceMainLeve, manip;
	private String[] listFig = { "Choisissez une figure", "Quadrilataire", "Triangle", "Rectangle", "cercle"};
	private JComboBox figList; 
	private String[] listCoul = { "Choisissez une couleur", "Bleu", "Rouge", "Vert", "Jaune" };
	private JComboBox coulList;
	private boolean nf, tml, man;
	private VueDessin vdessin;

	public PanneauChoix(DessinModele m, VueDessin vd) {
		vdessin = vd;
		dmodele=m;
		ButtonGroup bg = new ButtonGroup();
		nouvelleFigure = new JRadioButton("Nouvelle Figure");
		traceMainLeve = new JRadioButton("Trace a main levee");
		manip = new JRadioButton("Manipulations");
		bg.add(nouvelleFigure);
		bg.add(traceMainLeve);
		bg.add(manip);
		figList = new JComboBox(listFig);
		figList.setSelectedIndex(0);
		figList.setEnabled(false);
		coulList = new JComboBox(listCoul);
		coulList.setSelectedIndex(0);

		nouvelleFigure.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (nouvelleFigure.isSelected()) {
					for (FigureColoree f: dmodele.getLfc()) {
						f.deSelectionne();
					}
					nf = true;
					tml = false;
					man = false;
					figList.setEnabled(true);
					coulList.setEnabled(true);
					repaint();
					if (!setFigureModele()) return;
				}
			}
		});

		traceMainLeve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (traceMainLeve.isSelected()) {
					for (FigureColoree f: dmodele.getLfc()) {
						f.deSelectionne();
					}
					nf = false;
					tml = true;
					man = false;
					vdessin.passerModeDessin();
					dmodele.setFigureEnCours(null);
					figList.setEnabled(false);
					coulList.setEnabled(true);
					repaint();
				}
			}
		});

		manip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (manip.isSelected()) {
					for (FigureColoree f: dmodele.getLfc()) {
						f.deSelectionne();
					}
					nf = false;
					tml = false;
					man = true;
					dmodele.setFigureEnCours(null);
					vdessin.passerModeManip();
					figList.setEnabled(false);
					coulList.setEnabled(true);
					repaint();
				}
			}
		});

		figList.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				setFigureModele();
			}
		});

		coulList.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if (dmodele==null) return;
				dmodele.changeCoul(dmodele.getFigureEnCours(), determineCouleur(coulList.getSelectedIndex()));
				vdessin.trace(determineCouleur(coulList.getSelectedIndex()));
			}
		});

		setLayout(new BorderLayout());
		JPanel radioBox = new JPanel(); 
		JPanel comboBox = new JPanel();
		radioBox.add(nouvelleFigure);
		radioBox.add(traceMainLeve);
		radioBox.add(manip);
		comboBox.add(figList);
		comboBox.add(coulList);
		add(radioBox, BorderLayout.NORTH);
		add(comboBox, BorderLayout.SOUTH);
	}

	private boolean setFigureModele() {
		if (dmodele==null) return false;
		if (!nf) return false;
		FigureColoree f = creerFigure();
		if (f==null) return false;
		dmodele.construit(f);
		vdessin.passerModeCreation(f);
		return true;
	}
	
	public FigureColoree creerFigure() {
		switch(figList.getSelectedIndex ()) {
		case 1 :
			return new Quadrilatere();
		case 2 :
			return new Triangle();
		case 3 :
			return new Rectangle();
		case 4 :
			return new Cercle();
		default:
			return null;
		}		
	}

	public Color determineCouleur(int i) {
		Color c = null;
		switch(i) {
		case 1 :
			c = Color.BLUE;
			break;
		case 2:
			c = Color.RED;
			break;
		case 3:
			c = Color.GREEN;
			break;
		case 4:
			c = Color.YELLOW;
			break;
		default:
			c = Color.BLACK;
			break;
		}
		return c;
	}

}
