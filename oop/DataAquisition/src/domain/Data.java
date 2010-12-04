package domain;

public class Data {
	private	double x;
	private double y;
	private static int count;
	
	public Data(double x, double y) {
		++count;
		this.x = x;
		this.y = y;
	}

	public Data() {
		++count;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public static int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "Data [x=" + x + ", y=" + y + "]";
	}
	
	

}
