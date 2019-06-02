package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import modele.DessinModele;
import modele.FigureColoree;
import vue.VueDessin;

/**
 * classe servant a manipuler des figures
 */
public class ManipulateurFormes implements MouseListener, MouseMotionListener{

	private int last_x, last_y, indice, nbf, figureSel=-1;
	private boolean trans = false;
	private ArrayList<FigureColoree> lfc;
	private DessinModele model;
	private int carreSelectionne = -1;
	private VueDessin vd;

	public ManipulateurFormes(DessinModele p_dm, VueDessin p_vd) {
		model = p_dm;
		vd = p_vd;
		lfc = p_dm.getLfc();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		last_x = arg0.getX();
		last_y = arg0.getY();

		if (figureSel>=0) {
			// il y a une figure selectionnee
			carreSelectionne = lfc.get(figureSel).carreDeSelection(last_x,last_y); 
			if (carreSelectionne >=0 ) {
				model.modeleChange();
				return;
			}
		}
		carreSelectionne=-1;

		for (FigureColoree f: lfc) {
			f.deSelectionne();
		}
		model.setFigureEnCours(null);
		nbf = lfc.size();
		for (int i=nbf-1; i>=0; i--) {
			if (lfc.get(i).estDedans(last_x, last_y)) {
				trans = true;
				model.setFigureEnCours(lfc.get(i));
				lfc.get(i).selectionne();
				figureSel = i;
				model.modeleChange();
				return;
			}
		}
		// clic a cote : deselectionner la figure
		figureSel=-1;
		model.modeleChange();
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		if (figureSel<0) return;
		FigureColoree fc = model.getFigureEnCours();
		if (fc==null) return;
		int dx = arg0.getX();
		int dy = arg0.getY();
		
		if (carreSelectionne >= 0) {
			fc.transformation(dx, dy, carreSelectionne);
		} else {
			dx-=last_x;
			dy-=last_y;
			fc.translation(dx, dy);
		}
		last_x=arg0.getX();
		last_y=arg0.getY();
		model.modeleChange();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return le nombre de figures creees
	 */
	public int nbFigures() {
		return nbf;
	}

}
