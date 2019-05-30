package modele;

public class Rectangle extends Quadrilatere {
	private boolean init=false;
	
	public Rectangle() {
		super();
	}
	
	@Override
	public FigureColoree recree() {
		FigureColoree fc = new Rectangle();
		fc.couleur = this.couleur;
		return fc;
	}

	@Override
	public int nbClics() {
		return 2;
	}
	
	@Override
	public void modifierPoints(Point[] tab_pts) {
		if (!init) {
		int x0=tab_pts[0].rendreX();
		int y0=tab_pts[0].rendreY();
		int x1=tab_pts[1].rendreX();
		int y1=tab_pts[1].rendreY();
		tab_mem[0] = new Point(x0, y0);
		tab_mem[1] = new Point(x1, y0);
		tab_mem[2] = new Point(x1, y1);
		tab_mem[3] = new Point(x0, y1);
		p.reset();
		p.addPoint(x0,y0);
		p.addPoint(x1,y0);
		p.addPoint(x1,y1);
		p.addPoint(x0,y1);
		init=true;
		} else super.modifierPoints(tab_pts);
	}
	
	public void transfomation(int dx, int dy, int indice) {
		tab_mem[indice].modifierX(dx);
		tab_mem[indice].modifierY(dy);
	}

}
