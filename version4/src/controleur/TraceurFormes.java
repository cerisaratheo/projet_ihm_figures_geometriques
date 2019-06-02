package controleur;

import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class TraceurFormes extends JPanel implements MouseListener, MouseMotionListener{

	private int last_x, last_y;
	private Color couleurTrait = Color.black;
	private Graphics g;
	private ArrayList<Trait> tableauTraits = new ArrayList<Trait>();

	public TraceurFormes(Graphics p_g) {
		g=p_g;
	}

	/**
	 * methode pour definir la couleur d'un trait
	 * @param c couleur du trait
	 */
	public void setColor(Color c) {
		couleurTrait=c;
	}

	/**
	 * @return le tableau de traits contenant tous les traits deja effectues
	 */
	public ArrayList<Trait> getTableauTraits() {
		return tableauTraits;
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		if (SwingUtilities.isLeftMouseButton(arg0)) {
			g.setColor(couleurTrait);
			g.drawLine(last_x, last_y, arg0.getX(), arg0.getY());
			Trait t = new Trait(last_x, arg0.getX(),last_y, arg0.getY(), couleurTrait);
			tableauTraits.add(t);
			last_x = arg0.getX();
			last_y = arg0.getY();
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		last_x = arg0.getX();
		last_y = arg0.getY();
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

}
