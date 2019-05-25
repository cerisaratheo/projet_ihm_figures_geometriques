package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import modele.DessinModele;
import modele.FigureColoree;

public class ManipulateurFormes implements MouseListener, MouseMotionListener{

	private int last_x, last_y, indice, nbf, sel;
	private boolean trans;
	private ArrayList<FigureColoree> lfc;
	private DessinModele dm;
	
	public ManipulateurFormes(DessinModele dm) {
		
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
		// TODO Auto-generated method stub
		
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
		return lfc.size();
	}
	
	public FigureColoree figureSelection() {
		
	}
	
	public void selectionProchaineFigure() {
		
	}
}
