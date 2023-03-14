package x590.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

public final class ArrayUtil {
	
	private ArrayUtil() {}
	
	/** {@code array} конвертируется в {@link Iterator}
	 * @see Util#forEachExcludingLast(Iterator, Consumer, Consumer) */
	public static <T> void forEachExcludingLast(T[] array, Consumer<? super T> eachFunc, Consumer<? super T> eachExcludingLastFunc) {
		LoopUtil.forEachExcludingLast(Arrays.stream(array).iterator(), eachFunc, eachExcludingLastFunc);
	}
	
	/** {@code array} конвертируется в {@link Iterator}
	 * @see Util#forEachExcludingLast(Iterator, Consumer, Consumer, int) */
	public static <T> void forEachExcludingLast(T[] array, Consumer<? super T> eachFunc, Consumer<? super T> eachExcludingLastFunc, int startIndex) {
		LoopUtil.forEachExcludingLast(Arrays.stream(array).iterator(), eachFunc, eachExcludingLastFunc, startIndex);
	}
	
	/** {@code array} конвертируется в {@link Iterator}
	 * @see Util#forEachExcludingLast(Iterator, ObjIntConsumer, Consumer) */
	public static <T> void forEachExcludingLast(T[] array, ObjIntConsumer<? super T> eachFunc, Consumer<? super T> eachExcludingLastFunc) {
		LoopUtil.forEachExcludingLast(Arrays.stream(array).iterator(), eachFunc, eachExcludingLastFunc);
	}
	
	/** {@code array} конвертируется в {@link Iterator}
	 * @see Util#forEachExcludingLast(Iterator, ObjIntConsumer, Consumer, int) */
	public static <T> void forEachExcludingLast(T[] array, ObjIntConsumer<? super T> eachFunc, Consumer<? super T> eachExcludingLastFunc, int startIndex) {
		LoopUtil.forEachExcludingLast(Arrays.stream(array).iterator(), eachFunc, eachExcludingLastFunc, startIndex);
	}
	
	/** {@code array} конвертируется в {@link Iterator}
	 * @see Util#forEachExcludingLast(Iterator, ObjIntConsumer, Consumer, int, int) */
	public static <T> void forEachExcludingLast(T[] array, ObjIntConsumer<? super T> eachFunc, Consumer<? super T> eachExcludingLastFunc, int startIndex, int startCountIndex) {
		LoopUtil.forEachExcludingLast(Arrays.stream(array).iterator(), eachFunc, eachExcludingLastFunc, startIndex, startCountIndex);
	}
	
	
	public static <T> void forEach(T[] array, Consumer<T> func) {
		for(T t : array) {
			func.accept(t);
		}
	}
}
