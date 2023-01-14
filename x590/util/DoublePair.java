package x590.util;

public class DoublePair {
	
	private double value1, value2;
	
	public DoublePair(double value1, double value2) {
		this.value1 = value1;
		this.value2 = value2;
	}
	
	public static DoublePair of(double value1, double value2) {
		return new DoublePair(value1, value2);
	}
	
	public double value1() {
		return value1;
	}
	
	public double value2() {
		return value2;
	}
	
	public void value1(double value1) {
		this.value1 = value1;
	}
	
	public void value2(double value2) {
		this.value2 = value2;
	}
	
	@Override
	public String toString() {
		return "{" + value1 + ", " + value2 + "}";
	}
}