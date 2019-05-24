package controleur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import modele.DessinModele;
import modele.FigureColoree;
import modele.Quadrilatere;
import modele.Rectangle;
import modele.Triangle;
import vue.VueDessin;

public class PanneauChoix extends JPanel {

	private DessinModele dmodele;
	private JRadioButton nouvelleFigure, traceMainLeve, manip;
	private String[] listFig = { "Choisissez une figure", "Quadrilataire", "Triangle", "Rectangle"};
	private JComboBox figList; 
	private String[] listCoul = { "Choisissez une couleur", "Bleu", "Rouge", "Vert", "Jaune" };
	private JComboBox coulList;
	private boolean nf, tml, man;

	public PanneauChoix(DessinModele m) {
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
		coulList = new JComboBox(listCoul);
		coulList.setSelectedIndex(0);

		nouvelleFigure.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (nouvelleFigure.isSelected()) {
					nf = true;
					tml = false;
					man = false;
					System.out.println("nouvelle figure : " +nf);
					System.out.println("trace main levee : " +tml);
					System.out.println("manip : " + man);
				}
			}
		});

		traceMainLeve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (traceMainLeve.isSelected()) {
					nf = false;
					tml = true;
					man = false;
					System.out.println("nouvelle figure : " +nf);
					System.out.println("trace main levee : " +tml);
					System.out.println("manip : " + man);
				}
			}
		});

		manip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (manip.isSelected()) {
					nf = false;
					tml = false;
					man = true;
					System.out.println("nouvelle figure : " + nf);
					System.out.println("trace main levee : " + tml);
					System.out.println("manip : " + man);
				}
			}
		});

		figList.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if (dmodele==null) return;
<<<<<<< HEAD
				switch(figList.getSelectedIndex ()) {
				case 1 :
					dmodele.construit(new Quadrilatere());
					break;
				case 2 :
					dmodele.construit(new Triangle());
					break;
				case 3 :
					dmodele.construit(new Rectangle());
					break;
				default:
					break;
				}
=======
				dmodele.construit(creerFigure());
>>>>>>> 235ec506c4a02480bd4058d9b18ef684172221e7
			}
		});

		coulList.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if (dmodele==null) return;
				dmodele.changeCoul(dmodele.getFigureEnCours(), determineCouleur(coulList.getSelectedIndex()));
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

	public FigureColoree creerFigure() {
		switch(figList.getSelectedIndex ()) {
		case 1 :
			return new Quadrilatere();
		case 2 :
			return new Triangle();
		case 3 :
			return new Cercle();
		case 4 :
			return new Rectangle();
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
