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
		for (FigureColoree f: lfc) {
			f.deSelectionne();
		}
		last_x = arg0.getX();
		last_y = arg0.getY();
		nbf = lfc.size();
		System.out.println("manipmoise "+nbf);
		for (int i=0; i<nbf; i++) {
			if (lfc.get(i).estDedans(last_x, last_y)) {
				trans = true;
				v_dm.setFigureEnCours(lfc.get(i));
				lfc.get(i).selectionne();
				sel = i;
				v_dm.modeleChange();
				return;
			}
		}
		v_dm.modeleChange();		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		System.out.println("trans");
		FigureColoree fc = v_dm.getFigureEnCours();
		fc.translation(arg0.getX()-last_x, arg0.getY()-last_y);
		last_x=arg0.getX();
		last_y=arg0.getY();
		v_dm.modeleChange();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public int nbFigures() {
		return nbf;
	}
	
	public void selectionProchaineFigure() {
		
	}
}
