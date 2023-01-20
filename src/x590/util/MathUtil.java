package x590.util;

public class MathUtil {
	
	private MathUtil() {}
	
	
	public static double greatestCommonDivisor(double x, double y) {
		if(x <= 0 || y <= 0)
			throw new IllegalArgumentException("x = " + x + ", y = " + y);
		
		while(x != 0 && y != 0){
			if(x > y)
				x %= y;
			else
				y %= x;
		}

		return x + y;
	}
	
	
	public static int greatestCommonDivisor(int x, int y) {
		if(x <= 0 || y <= 0)
			throw new IllegalArgumentException("x = " + x + ", y = " + y);
		
		while(x != 0 && y != 0){
			if(x > y)
				x %= y;
			else
				y %= x;
		}

		return x + y;
	}
	
	
	public static boolean isIntegral(double x) {
		return (long)x == x;
	}
	
	
	public static boolean isEven(double x) {
		return x % 2 == 0;
	}
}