package x590.util;

public final class FPUtil {

	private FPUtil() {}

	public static final int
			MIN_RADIX = 2,
			MAX_RADIX = 35;


	public static NumberFormatException numberFormatException(String str, int radix) {
		return new NumberFormatException("For input string: \"" + str + "\"" +
				(radix == 10 ? "" : " under radix " + radix));
	}

	static void validateParsing(String str, int radix) {
		if (str == null) {
			throw new NumberFormatException("Cannot parse null string");
		}

		if (radix < MIN_RADIX) {
			throw new NumberFormatException("radix " + radix + " less than FPUtil.MIN_RADIX");
		}

		if (radix > MAX_RADIX) {
			throw new NumberFormatException("radix " + radix + " greater than FPUtil.MAX_RADIX");
		}
	}

	public static char getExponentSeparator(int radix) {
		return radix <= 14 ? 'e' : radix <= 26 ? 'p' : 'z';
	}

	public static String getExponentSeparatorString(int radix) {
		return radix <= 14 ? "e" : radix <= 26 ? "p" : "z";
	}
}
