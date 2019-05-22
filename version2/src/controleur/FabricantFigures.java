package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import modele.DessinModele;
import modele.FigureColoree;

public class FabricantFigures implements MouseListener {
	
	private DessinModele model;

	public void setModele(DessinModele m) {
		model = m;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

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
		
		model.ajoutePoint(arg0.getX(), arg0.getY());
		System.out.println("mouseClicked ok");		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public FabricantFigures(DessinModele dm) {
		
		this.model=dm;
	}

}
