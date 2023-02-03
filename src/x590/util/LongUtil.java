package x590.util;

public final class LongUtil {
	
	private LongUtil() {}
	
	
	/** Просто чтобы не вызывать кажный раз метод {@link Long#valueOf(long)} */
	public static final Long
			ZERO = 0L,
			ONE = 1L;
	
	private static char hexChar(long num) {
		num &= 0xF;
		return (char)((num > 9 ? 'A' - 10 : '0') + num);
	}
	
	
	/** Делает то же, что и метод {@link Long#toHexString()}. Нужен для однородности кода. */
	public static String hex(long num) {
		return Long.toHexString(num);
	}
	
	/** Приводит число к hex строке длиной 1 символ. Если число не вмещается в этот дапазон, обрезает его. */
	public static String hex1(long num) {
		return Character.toString(hexChar(num));
	}
	
	/** Приводит число к hex строке длиной 2 символа. Если число не вмещается в этот дапазон, обрезает его. */
	public static String hex2(long num) {
		return String.valueOf(new char[] { hexChar(num >>> 4), hexChar(num) });
	}
	
	/** Приводит число к hex строке длиной 4 символа. Если число не вмещается в этот дапазон, обрезает его. */
	public static String hex4(long num) {
		return String.valueOf(new char[] { hexChar(num >>> 12), hexChar(num >>> 8), hexChar(num >>> 4), hexChar(num) });
	}
	
	/** Приводит число к hex строке длиной 8 символов. */
	public static String hex8(long num) {
		return String.valueOf(new char[] {
				hexChar(num >>> 28), hexChar(num >>> 24), hexChar(num >>> 20), hexChar(num >>> 16),
				hexChar(num >>> 12), hexChar(num >>> 8), hexChar(num >>> 4), hexChar(num) });
	}
	
	/** Приводит число к hex строке длиной 16 символов. */
	public static String hex16(long num) {
		return String.valueOf(new char[] {
				hexChar(num >>> 60), hexChar(num >>> 56), hexChar(num >>> 52), hexChar(num >>> 48),
				hexChar(num >>> 44), hexChar(num >>> 40), hexChar(num >>> 36), hexChar(num >>> 32),
				hexChar(num >>> 28), hexChar(num >>> 24), hexChar(num >>> 20), hexChar(num >>> 16),
				hexChar(num >>> 12), hexChar(num >>> 8), hexChar(num >>> 4), hexChar(num) });
	}
	
	
	/** Делает то же самое, что и {@link #hex(long)}, но прибавляет "0x" */
	public static String hexWithPrefix(long num) {
		return "0x" + Long.toHexString(num);
	}
	
	/** Делает то же самое, что и {@link #hex1(long)}, но прибавляет "0x" */
	public static String hex1WithPrefix(long num) {
		return "0x" + hex1(num);
	}
	
	/** Делает то же самое, что и {@link #hex2(long)}, но прибавляет "0x" */
	public static String hex2WithPrefix(long num) {
		return "0x" + hex2(num);
	}
	
	/** Делает то же самое, что и {@link #hex4(long)}, но прибавляет "0x" */
	public static String hex4WithPrefix(long num) {
		return "0x" + hex4(num);
	}
	
	/** Делает то же самое, что и {@link #hex8(long)}, но прибавляет "0x" */
	public static String hex8WithPrefix(long num) {
		return "0x" + hex8(num);
	}
	
	/** Делает то же самое, что и {@link #hex16(long)}, но прибавляет "0x" */
	public static String hex16WithPrefix(long num) {
		return "0x" + hex16(num);
	}
	
	
	public static boolean isPowerOfTwo(long num) {
		return (num & (num - 1)) == 0;
	}
}