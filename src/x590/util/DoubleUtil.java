package x590.util;

import static x590.util.FPUtil.*;

public final class DoubleUtil {

	private DoubleUtil() {}


	public static double parseDouble(String str, int radix) throws NumberFormatException {
		validateParsing(str, radix);

		int length = str.length();

		if (length == 0) {
			throw numberFormatException(str, radix);
		}

		char firstChar = str.charAt(0);
		int i = firstChar == '-' || firstChar == '+' ? 1 : 0;

		if (length <= i) {
			throw numberFormatException(str, radix);
		}

		double sign = firstChar == '-' ? -1D : 1D;
		double result = 0;
		double exponent = 1;

		char exponentSeparator = getExponentSeparator(radix);

		for (boolean hasPoint = false; i < length; i++) {
			char ch = str.charAt(i);

			if (ch == '.') {
				if (hasPoint) {
					throw numberFormatException(str, radix);
				}

				hasPoint = true;

			} else if (Character.toLowerCase(ch) == exponentSeparator) {
				try {
					return result * Math.pow(radix, Integer.parseInt(str.substring(i + 1))) * sign;
				} catch(NumberFormatException ex) {
					throw (NumberFormatException) numberFormatException(str, radix).initCause(ex);
				}

			} else {
				int digit = Character.digit(ch, radix);

				if (digit == -1) {
					throw numberFormatException(str, radix);
				}

				if (hasPoint) {
					exponent /= radix;
					result += exponent * digit;
				} else {
					result = result * radix + digit;
				}
			}
		}

		return result * sign;
	}

	public static double parseDouble(String str, int radix, boolean sign) {
		double num = parseDouble(str, radix);
		return sign ? -num : num;
	}
}
