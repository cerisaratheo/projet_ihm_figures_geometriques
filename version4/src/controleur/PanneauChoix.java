package controleur;

import java.util.ArrayList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import modele.Cercle;
import modele.DessinModele;
import modele.Ellipse;
import modele.FigureColoree;
import modele.Quadrilatere;
import modele.Rectangle;
import modele.Triangle;
import vue.VueDessin;

/**
 * classe servant a choisir parmis les differents modes disponibles (creation de figures, trace a main levee ou manipulation) 
 */
public class PanneauChoix extends JPanel {

	private DessinModele dmodele;
	private JRadioButton nouvelleFigure, traceMainLeve, manip;
	private String[] listFig = { "Choisissez une figure", "Quadrilataire", "Triangle", "Rectangle", "cercle", "ellipse"};
	private JComboBox figList; 
	private String[] listCoul = { "Choisissez une couleur", "Bleu", "Rouge", "Vert", "Jaune" };
	private JComboBox coulList;
	private boolean nf, tml, man;
	private VueDessin vdessin;
        private JButton up = new JButton("up");
        private JButton down = new JButton("down");
        private JButton del = new JButton("del");
	
	/**
	 * cree les boutons et gere l'action des boutons et des menus deroulants
	 * @param m modele associe
	 * @param vd vue associee
	 */
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
                                       up.setEnabled(false);
                                       down.setEnabled(false);
                                       del.setEnabled(false);
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
                                       up.setEnabled(false);
                                       down.setEnabled(false);
                                       del.setEnabled(false);
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
                                       up.setEnabled(true);
                                       down.setEnabled(true);
                                       del.setEnabled(true);
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

               up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            FigureColoree ff = dmodele.getFigureEnCours();
                            ArrayList<FigureColoree> lfc = dmodele.getLfc();
                            for (int i=0;i<lfc.size();i++) {
                                FigureColoree f = lfc.get(i);
                                if (f==ff) {
                                    if (i<lfc.size()-1) {
                                        lfc.remove(i);
                                        lfc.add(i+1,f);
                                    }
                                    break;
                                }
                            }
                            dmodele.modeleChange();
                        }
               });
               down.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            FigureColoree ff = dmodele.getFigureEnCours();
                            ArrayList<FigureColoree> lfc = dmodele.getLfc();
                            for (int i=0;i<lfc.size();i++) {
                                FigureColoree f = lfc.get(i);
                                if (f==ff) {
                                    if (i>0) {
                                        lfc.remove(i);
                                        lfc.add(i-1,f);
                                    }
                                    break;
                                }
                            }
                            dmodele.modeleChange();
                        }
               });
               del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            FigureColoree ff = dmodele.getFigureEnCours();
                            ArrayList<FigureColoree> lfc = dmodele.getLfc();
                            lfc.remove(ff);
                            dmodele.modeleChange();
                        }
               });
               up.setEnabled(false);
               down.setEnabled(false);
               del.setEnabled(false);

		setLayout(new BorderLayout());
		JPanel radioBox = new JPanel(); 
		JPanel comboBox = new JPanel();
		radioBox.add(nouvelleFigure);
		radioBox.add(traceMainLeve);
		radioBox.add(manip);
		comboBox.add(figList);
		comboBox.add(coulList);
		comboBox.add(up);
		comboBox.add(down);
		comboBox.add(del);
		add(radioBox, BorderLayout.NORTH);
		add(comboBox, BorderLayout.SOUTH);
	}

	/**
	 * @return un booleen qui vaut true si 
	 */
	private boolean setFigureModele() {
		if (dmodele==null) return false;
		if (!nf) return false;
		FigureColoree f = creerFigure();
		if (f==null) return false;
		dmodele.construit(f);
		vdessin.passerModeCreation(f);
		return true;
	}
	
	/**
	 * methode pour creer une nouvelle figure
	 * @return la nouvelle figure
	 */
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
		case 5 :
			return new Ellipse();
		default:
			return null;
		}		
	}

	/**
	 * methode pour changer de couleur
	 * @param i indice d'une couleur dans le menu deroulant
	 * @return la couleur correspondante a l'indice
	 */
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
