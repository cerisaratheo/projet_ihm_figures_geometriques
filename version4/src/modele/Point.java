package modele;

public class Point {

	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double distance(Point p) {
		return Math.sqrt(Math.pow((p.rendreX()-this.rendreX()), 2)+Math.pow((p.rendreY()-this.rendreY()), 2));
	}
	
	public int rendreX() {
		return x;
	}
	
	public int rendreY() {
		return y;
	}
	
	public void incrementerX(int dx) {
		this.x += dx;
	}
	
	public void incrementerY(int dy) {
		this.y += dy;
	}
	
	public void modifierX(int x) {
		this.x = x;
	}
	
	public void modifierY(int y) {
		this.y = y;
	}
	
	public void translation(int dx, int dy) {
		this.incrementerX(dx);
		this.incrementerY(dy);
	}
}
