package vue;

import java.awt.*;
import java.util.*;

import javax.swing.JPanel;

import modele.DessinModele;

public class VueDessin extends JPanel implements Observer{
	
	private DessinModele dessin;

	public VueDessin() {
		
		dessin = new DessinModele();
	}
	
	public void update(Observable obs, Object obj) {
		
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
	}
}
