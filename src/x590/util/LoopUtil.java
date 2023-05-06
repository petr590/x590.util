package x590.util;

import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

public final class LoopUtil {
	
	private LoopUtil() {}
	
	
	public static <T> void forEach(Iterable<T> iterable, Consumer<? super T> eachFunc) {
		iterable.forEach(eachFunc);
	}
	
	public static <T> void forEach(Iterable<T> iterable, ObjIntConsumer<? super T> eachFunc) {
		int i = 0;
		for(Iterator<T> iterator = iterable.iterator(); iterator.hasNext(); i++)
			eachFunc.accept(iterator.next(), i);
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
	 * Если элементов в итераторе будет меньше, чем startIndex, ничего не произойдёт (ошибки не будет).
	 * @param eachFunc - функция, которая будет выполнена для каждого элемента. Принимает элемент и индекс.
	 * @param eachExcludingLastFunc - функция, которая будет выполнена для каждого элемента, кроме последнего.
	 * @param startIndex - сколько элементов пропустить с начала итератора.
	 */
	public static <T> void forEachExcludingLast(Iterator<T> iterator, Consumer<? super T> eachFunc, Consumer<? super T> eachExcludingLastFunc, int startIndex) {
		
		for(; startIndex > 0 && iterator.hasNext(); iterator.next(), startIndex--);
		
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
	 * Если элементов в итераторе будет меньше, чем startIndex, ничего не произойдёт (ошибки не будет).
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
	
	
	/** {@code iterable} конвертируется в {@link Iterator}
	 * @see #forEachPair(Iterator, BiConsumer) */
	public static <T> void forEachPair(Iterable<T> iterable, BiConsumer<? super T, ? super T> eachPairFunc) {
		forEachPair(iterable.iterator(), eachPairFunc, 0);
	}
	
	/** {@code iterable} конвертируется в {@link Iterator}
	 * @see #forEachPair(Iterator, BiConsumer, int) */
	public static <T> void forEachPair(Iterable<T> iterable, BiConsumer<? super T, ? super T> eachPairFunc, int startIndex) {
		forEachPair(iterable.iterator(), eachPairFunc, startIndex);
	}
	
	/** {@code startIndex} по умолчанию равен 0.
	 * @see #forEachPair(Iterator, BiConsumer, int) */
	public static <T> void forEachPair(Iterator<T> iterator, BiConsumer<? super T, ? super T> eachPairFunc) {
		forEachPair(iterator, eachPairFunc, 0);
	}
	
	/**
	 * Выполняет функцию для каждой пары элементов, идущих подряд.
	 * 
	 * @param iterator - итератор, из которого будут браться элементы.
	 * Если элементов в итераторе будет меньше, чем startIndex, ничего не произойдёт (ошибки не будет).
	 * @param eachPairFunc - функция, которая будет выполнена для каждой пары элементов, идущих подряд.
	 * @param startIndex - сколько элементов пропустить с начала итератора.
	 */
	public static <T> void forEachPair(Iterator<T> iterator, BiConsumer<? super T, ? super T> eachPairFunc, int startIndex) {
		
		for(; startIndex > 0 && iterator.hasNext(); iterator.next(), startIndex--);
		
		if(iterator.hasNext()) {
			T value1 = iterator.next();
			
			while(iterator.hasNext()) {
				T value2 = iterator.next();
				eachPairFunc.accept(value1, value2);
				value1 = value2;
			}
		}
	}
	
	
	/** {@code iterable} конвертируется в {@link Iterator}
	 * @see #forEachPair(Iterator, Consumer, BiConsumer) */
	public static <T> void forEachPair(Iterable<T> iterable, Consumer<? super T> eachFunc, BiConsumer<? super T, ? super T> eachPairFunc) {
		forEachPair(iterable.iterator(), eachFunc, eachPairFunc, 0);
	}
	
	/** {@code iterable} конвертируется в {@link Iterator}
	 * @see #forEachPair(Iterator, Consumer, BiConsumer, int) */
	public static <T> void forEachPair(Iterable<T> iterable, Consumer<? super T> eachFunc, BiConsumer<? super T, ? super T> eachPairFunc, int startIndex) {
		forEachPair(iterable.iterator(), eachFunc, eachPairFunc, startIndex);
	}
	
	/** {@code startIndex} по умолчанию равен 0.
	 * @see #forEachPair(Iterator, Consumer, BiConsumer, int) */
	public static <T> void forEachPair(Iterator<T> iterator, Consumer<? super T> eachFunc, BiConsumer<? super T, ? super T> eachPairFunc) {
		forEachPair(iterator, eachFunc, eachPairFunc, 0);
	}
	
	/**
	 * Выполняет функцию для каждой пары элементов, идущих подряд.
	 * 
	 * @param iterator - итератор, из которого будут браться элементы.
	 * Если элементов в итераторе будет меньше, чем startIndex, ничего не произойдёт (ошибки не будет).
	 * @param eachFunc - функция, которая будет выполнена для каждого элемента поочерёдно с eachPairFunc
	 * @param eachPairFunc - функция, которая будет выполнена для каждой пары элементов, идущих подряд.
	 * @param startIndex - сколько элементов пропустить с начала итератора.
	 */
	public static <T> void forEachPair(Iterator<T> iterator, Consumer<? super T> eachFunc, BiConsumer<? super T, ? super T> eachPairFunc, int startIndex) {
		
		for(; startIndex > 0 && iterator.hasNext(); iterator.next(), startIndex--);
		
		if(iterator.hasNext()) {
			T value1 = iterator.next();
			eachFunc.accept(value1);
			
			while(iterator.hasNext()) {
				T value2 = iterator.next();
				eachPairFunc.accept(value1, value2);
				eachFunc.accept(value2);
				value1 = value2;
			}
		}
	}
	
	
	/** {@code iterable} конвертируется в {@link Iterator}
	 * @see #forEachPair(Iterator, ObjIntConsumer, BiConsumer) */
	public static <T> void forEachPair(Iterable<T> iterable, ObjIntConsumer<? super T> eachFunc, BiConsumer<? super T, ? super T> eachPairFunc) {
		forEachPair(iterable.iterator(), eachFunc, eachPairFunc, 0);
	}
	
	/** {@code iterable} конвертируется в {@link Iterator}
	 * @see #forEachPair(Iterator, ObjIntConsumer, BiConsumer, int) */
	public static <T> void forEachPair(Iterable<T> iterable, ObjIntConsumer<? super T> eachFunc, BiConsumer<? super T, ? super T> eachPairFunc, int startIndex) {
		forEachPair(iterable.iterator(), eachFunc, eachPairFunc, startIndex);
	}
	
	/** {@code startIndex} по умолчанию равен 0.
	 * @see #forEachPair(Iterator, ObjIntConsumer, BiConsumer, int) */
	public static <T> void forEachPair(Iterator<T> iterator, ObjIntConsumer<? super T> eachFunc, BiConsumer<? super T, ? super T> eachPairFunc) {
		forEachPair(iterator, eachFunc, eachPairFunc, 0);
	}
	
	/**
	 * Выполняет функцию для каждой пары элементов, идущих подряд.
	 * 
	 * @param iterator - итератор, из которого будут браться элементы.
	 * Если элементов в итераторе будет меньше, чем startIndex, ничего не произойдёт (ошибки не будет).
	 * @param eachFunc - функция, которая будет выполнена для каждого элемента поочерёдно с eachPairFunc
	 * @param eachPairFunc - функция, которая будет выполнена для каждой пары элементов, идущих подряд.
	 * @param startIndex - сколько элементов пропустить с начала итератора.
	 */
	public static <T> void forEachPair(Iterator<T> iterator, ObjIntConsumer<? super T> eachFunc, BiConsumer<? super T, ? super T> eachPairFunc, int startIndex) {
		
		for(; startIndex > 0 && iterator.hasNext(); iterator.next(), startIndex--);
		
		if(iterator.hasNext()) {
			T value1 = iterator.next();
			eachFunc.accept(value1, 0);

			for(int i = 1; iterator.hasNext(); i++) {
				T value2 = iterator.next();
				eachPairFunc.accept(value1, value2);
				eachFunc.accept(value2, i);
				value1 = value2;
			}
		}
	}
}
