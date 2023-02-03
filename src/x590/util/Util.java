package x590.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

public class Util {
	
	private Util() {}
	
	
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