package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import modele.DessinModele;
import modele.FigureColoree;

public class ManipulateurFormes implements MouseListener, MouseMotionListener{

	private int last_x, last_y, indice, nbf, sel=-1;
	private boolean trans = false;
	private ArrayList<FigureColoree> lfc;
	private DessinModele v_dm;
	
	public ManipulateurFormes(DessinModele p_dm) {
		v_dm = p_dm;
		lfc = p_dm.getLfc();
		nbf = lfc.size();
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
		for (int i=0; i<nbf; i++) {
			if (lfc.get(i).estDedans(last_x, last_y)) {
				trans = true;
				v_dm.setFigureEnCours(lfc.get(i));
				sel = i;
				return;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public int nbFigures() {
		return nbf;
	}
	
	public FigureColoree figureSelection() {
		return v_dm.getFigureEnCours();
	}
	
	public void selectionProchaineFigure() {
		
	}
}
