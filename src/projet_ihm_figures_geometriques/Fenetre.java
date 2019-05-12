package projet_ihm_figures_geometriques;

import java.awt.Dimension;

import javax.swing.*;

public class Fenetre {
	
	JPanel principal, choix;
	VueDessin vdessin;
	
	public Fenetre(String str, int i, int j) {
		
		JFrame jf = new JFrame(str);
		jf.setPreferredSize(new Dimension(i,j));
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		principal = new JPanel();
		choix = new JPanel();
		jf.pack();
		jf.setVisible(true);
	}

	public static void main(String[] args) {

		Fenetre f = new Fenetre("figures geometriques", 700, 700);

	}
}
