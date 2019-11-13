
public class Plot {
	private int x, y, width, depth;
	
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	public Plot(Plot p) {
		x = p.x;
		y = p.y;
		width = p.width;
		depth = p.depth;
	}
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public boolean overlaps(Plot p) {
		boolean output;
		if (x > p.getX() && x < p.getDepth() && y > p.getY() && y < p.getWidth()) {
			output = false;
		}
		else {
			output = true;;
		}
		return output;
	}
	public boolean encompasses(Plot p) {
		boolean output;
		if (width <= p.getWidth() && (depth <= p.getDepth())) {
			output = true;
		}
		else {
			output = false;
		}
		return output;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return y;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getWidth() {
		return width;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getDepth() {
		return depth;
	}
	public String toString() {
		String output = "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
		return output;
	}
}
