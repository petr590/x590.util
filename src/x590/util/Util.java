package x590.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

public class Util {
	
	private Util() {}
	
	
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
		return "0x" + hex4(num);
	}
	
	
	/** {@code iterable} конвертируется в {@link Iterator}
	 * @see #forEachExcludingLast(Iterator, Consumer, Consumer) */
	public static <T> void forEachExcludingLast(Iterable<T> iterable, Consumer<? super T> eachFunc, Consumer<? super T> eachExcludingLastFunc) {
		forEachExcludingLast(iterable.iterator(), eachFunc, eachExcludingLastFunc, 0);
	}

	/** {@code iterable} конвертируется в {@link Iterator}
	 * @see #forEachExcludingLast(Iterator, Consumer, Consumer, int) */
	public static <T> void forEachExcludingLast(Iterable<T> iterable, Consumer<? super T> eachFunc, Consumer<? super T> eachExcludingLastFunc, int startIndex) {
		forEachExcludingLast(iterable.iterator(), eachFunc, eachExcludingLastFunc, startIndex);
	}
	
	/** {@code startIndex} по умолчанию равен 0.
	 * @see #forEachExcludingLast(Iterator, Consumer, Consumer, int) */
	public static <T> void forEachExcludingLast(Iterator<T> iterator, Consumer<? super T> eachFunc, Consumer<? super T> eachExcludingLastFunc) {
		forEachExcludingLast(iterator, eachFunc, eachExcludingLastFunc, 0);
	}
	
	/**
	 * Выполняет функцию для всех элементов, кроме последнего.
	 * 
	 * @param iterator - итератор, из которого будут браться элементы.
	 * Если элементов в итераторе будет меньше, ничего не произойдёт (ошибки не будет).
	 * @param eachFunc - функция, которая будет выполнена для каждого элемента. Принимает элемент и индекс.
	 * @param eachExcludingLastFunc - функция, которая будет выполнена для каждого элемента, кроме последнего.
	 * @param startIndex - сколько элементов пропустить с начала итератора.
	 */
	public static <T> void forEachExcludingLast(Iterator<T> iterator, Consumer<? super T> eachFunc, Consumer<? super T> eachExcludingLastFunc, int startIndex) {
		
		for(; startIndex > 0 && iterator.hasNext(); iterator.next(), --startIndex);
		
		if(iterator.hasNext()) {
			while(true) {
				T value = iterator.next();
				eachFunc.accept(value);
				
				if(iterator.hasNext())
					eachExcludingLastFunc.accept(value);
				else
					break;
			}
		}
	}
	
	/** {@code iterable} конвертируется в {@link Iterator}
	 * @see #forEachExcludingLast(Iterator, ObjIntConsumer, Consumer) */
	public static <T> void forEachExcludingLast(Iterable<T> iterable, ObjIntConsumer<? super T> eachFunc, Consumer<? super T> eachExcludingLastFunc) {
		forEachExcludingLast(iterable.iterator(), eachFunc, eachExcludingLastFunc);
	}
	
	/** {@code iterable} конвертируется в {@link Iterator}
	 * @see #forEachExcludingLast(Iterator, ObjIntConsumer, Consumer, int) */
	public static <T> void forEachExcludingLast(Iterable<T> iterable, ObjIntConsumer<? super T> eachFunc, Consumer<? super T> eachExcludingLastFunc, int startIndex) {
		forEachExcludingLast(iterable.iterator(), eachFunc, eachExcludingLastFunc, startIndex);
	}
	
	/** {@code iterable} конвертируется в {@link Iterator}
	 * @see #forEachExcludingLast(Iterator, ObjIntConsumer, Consumer, int, int) */
	public static <T> void forEachExcludingLast(Iterable<T> iterable, ObjIntConsumer<? super T> eachFunc, Consumer<? super T> eachExcludingLastFunc, int startIndex, int startCountIndex) {
		forEachExcludingLast(iterable.iterator(), eachFunc, eachExcludingLastFunc, startIndex, startCountIndex);
	}
	
	
	/** {@code startIndex} по умолчанию 0.
	 * @see #forEachExcludingLast(Iterator, ObjIntConsumer, Consumer, int) */
	public static <T> void forEachExcludingLast(Iterator<T> iterator, ObjIntConsumer<? super T> eachFunc, Consumer<? super T> eachExcludingLastFunc) {
		forEachExcludingLast(iterator, eachFunc, eachExcludingLastFunc, 0, 0);
	}
	
	/** {@code startCountIndex} по умолчанию равен {@code startIndex}.
	 * @see #forEachExcludingLast(Iterator, ObjIntConsumer, Consumer, int, int) */
	public static <T> void forEachExcludingLast(Iterator<T> iterator, ObjIntConsumer<? super T> eachFunc, Consumer<? super T> eachExcludingLastFunc, int startIndex) {
		forEachExcludingLast(iterator, eachFunc, eachExcludingLastFunc, startIndex, startIndex);
	}
	
	/**
	 * Выполняет функцию для всех элементов, кроме последнего.
	 * 
	 * @param <T> - тип элементов итератора.
	 * 
	 * @param iterator - итератор, из которого будут браться элементы.
	 * Если элементов в итераторе будет меньше, ничего не произойдёт (ошибки не будет).
	 * 
	 * @param eachFunc - функция, которая будет выполнена для каждого элемента. Принимает элемент и индекс.
	 * @param eachExcludingLastFunc - функция, которая будет выполнена для каждого элемента, кроме последнего.
	 * 
	 * @param startIndex - сколько элементов пропустить с начала итератора.
	 * @param startCountIndex - индекс, с которого будет вестись отсчёт.
	 */
	public static <T> void forEachExcludingLast(Iterator<T> iterator, ObjIntConsumer<? super T> eachFunc, Consumer<? super T> eachExcludingLastFunc, int startIndex, int startCountIndex) {
		
		for(; startIndex > 0 && iterator.hasNext(); iterator.next(), --startIndex);
		
		if(iterator.hasNext()) {
			int i = startCountIndex;
			
			while(true) {
				T value = iterator.next();
				eachFunc.accept(value, i);
				
				if(iterator.hasNext())
					eachExcludingLastFunc.accept(value);
				else
					break;
				
				i++;
			}
		}
	}
	
	
	public static <T> boolean iteratorsEquals(Iterator<T> iter1, Iterator<T> iter2, BiPredicate<T, T> predicate) {
		while(iter1.hasNext() && iter2.hasNext()) {
			var v1 = iter1.next();
			var v2 = iter2.next();
			
			if(!predicate.test(v1, v2)) {
				return false;
			}
		}
		
		return iter1.hasNext() == iter2.hasNext();
	}
	
	public static <T> boolean collectionsEquals(Collection<T> collection1, Collection<T> collection2, BiPredicate<T, T> predicate) {
		if(collection1.size() != collection2.size()) {
			return false;
		}
		
		return iteratorsEquals(collection1.iterator(), collection2.iterator(), predicate);
	}
}