package x590.util;

public final class IntegerUtil {
	
	private IntegerUtil() {}
	
	
	/** Просто чтобы не вызывать кажный раз метод {@link Integer#valueOf(int)} */
	public static final Integer
			ZERO = 0,
			ONE = 1;
	
	private static char hexChar(int num) {
		num &= 0xF;
		return (char)((num > 9 ? 'A' - 10 : '0') + num);
	}
	
	
	/** Делает то же, что и метод {@link Integer#toHexString()}. Нужен для однородности кода. */
	public static String hex(int num) {
		return Integer.toHexString(num);
	}
	
	/** Приводит число к hex строке длиной 1 символ. Если число не вмещается в этот дапазон, обрезает его. */
	public static String hex1(int num) {
		return Character.toString(hexChar(num));
	}
	
	/** Приводит число к hex строке длиной 2 символа. Если число не вмещается в этот дапазон, обрезает его. */
	public static String hex2(int num) {
		return String.valueOf(new char[] { hexChar(num >>> 4), hexChar(num) });
	}
	
	/** Приводит число к hex строке длиной 4 символа. Если число не вмещается в этот дапазон, обрезает его. */
	public static String hex4(int num) {
		return String.valueOf(new char[] { hexChar(num >>> 12), hexChar(num >>> 8), hexChar(num >>> 4), hexChar(num) });
	}
	
	/** Приводит число к hex строке длиной 8 символов. */
	public static String hex8(int num) {
		return String.valueOf(new char[] {
				hexChar(num >>> 28), hexChar(num >>> 24), hexChar(num >>> 20), hexChar(num >>> 16),
				hexChar(num >>> 12), hexChar(num >>> 8), hexChar(num >>> 4), hexChar(num) });
	}
	
	
	/** Делает то же самое, что и {@link #hex(int)}, но прибавляет "0x" */
	public static String hexWithPrefix(int num) {
		return "0x" + Integer.toHexString(num);
	}
	
	/** Делает то же самое, что и {@link #hex1(int)}, но прибавляет "0x" */
	public static String hex1WithPrefix(int num) {
		return "0x" + hex1(num);
	}
	
	/** Делает то же самое, что и {@link #hex2(int)}, но прибавляет "0x" */
	public static String hex2WithPrefix(int num) {
		return "0x" + hex2(num);
	}
	
	/** Делает то же самое, что и {@link #hex4(int)}, но прибавляет "0x" */
	public static String hex4WithPrefix(int num) {
		return "0x" + hex4(num);
	}
	
	/** Делает то же самое, что и {@link #hex8(int)}, но прибавляет "0x" */
	public static String hex8WithPrefix(int num) {
		return "0x" + hex8(num);
	}
	
	
	public static boolean isPowerOfTwo(int num) {
		return (num & (num - 1)) == 0;
	}
}