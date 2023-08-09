package x590.util;

import java.util.Iterator;
import java.util.function.BiPredicate;

import x590.util.function.ObjObjIntPredicate;

public final class IteratorUtil {
	
	public IteratorUtil() {}
	
	
	/** @see #iteratorsEquals(Iterator, Iterator, ObjObjIntPredicate) */
	public static <T, U> boolean iteratorsEquals(Iterator<? extends T> iter1, Iterator<? extends U> iter2, BiPredicate<? super T, ? super U> predicate) {
		return iteratorsEquals(iter1, iter2, (v1, v2, index) -> predicate.test(v1, v2));
	}
	
	/**
	 * Проверяет, что два итератора содержат одинаковые элементы и количество элементов также одинаково
	 * @param iter1 первый итератор
	 * @param iter2 второй итератор
	 * @param predicate предикат для сравнения элементов
	 */
	public static <T, U> boolean iteratorsEquals(Iterator<? extends T> iter1, Iterator<? extends U> iter2, ObjObjIntPredicate<? super T, ? super U> predicate) {
		for (int index = 0; iter1.hasNext() && iter2.hasNext(); index++) {
			var v1 = iter1.next();
			var v2 = iter2.next();
			
			if (!predicate.test(v1, v2, index)) {
				return false;
			}
		}
		
		return iter1.hasNext() == iter2.hasNext();
	}
}
