package x590.util;

import static x590.util.FPUtil.*;

public final class FloatUtil {

	private FloatUtil() {}


	public static float parseFloat(String str, int radix) throws NumberFormatException {
		validateParsing(str, radix);

		int length = str.length();

		if(length == 0) {
			throw numberFormatException(str, radix);
		}

		char firstChar = str.charAt(0);
		int i = firstChar == '-' || firstChar == '+' ? 1 : 0;

		if(length <= i) {
			throw numberFormatException(str, radix);
		}

		float sign = firstChar == '-' ? -1F : 1F;
		float result = 0;
		float exponent = 1;

		char exponentSeparator = getExponentSeparator(radix);

		for(boolean hasPoint = false; i < length; i++) {
			char ch = str.charAt(i);

			if(ch == '.') {
				if(hasPoint) {
					throw numberFormatException(str, radix);
				}

				hasPoint = true;

			} else if(Character.toLowerCase(ch) == exponentSeparator) {
				try {
					return result * MathUtil.pow(radix, Integer.parseInt(str.substring(i + 1))) * sign;
				} catch(NumberFormatException ex) {
					throw (NumberFormatException) numberFormatException(str, radix).initCause(ex);
				}

			} else {
				int digit = Character.digit(ch, radix);

				if(digit == -1) {
					throw numberFormatException(str, radix);
				}

				if(hasPoint) {
					exponent /= radix;
					result += exponent * digit;
				} else {
					result = result * radix + digit;
				}
			}
		}

		return result * sign;
	}

	public static float parseFloat(String str, int radix, boolean sign) {
		float num = parseFloat(str, radix);
		return sign ? -num : num;
	}
}
