package x590.util;

import java.util.Collection;
import java.util.function.BiPredicate;

import x590.util.function.ObjObjIntPredicate;

public final class CollectionUtil {
	
	private CollectionUtil() {}
	
	
	/** @see #collectionsEquals(Collection, Collection, ObjObjIntPredicate) */
	public static <T> boolean collectionsEquals(Collection<? extends T> collection1, Collection<? extends T> collection2, BiPredicate<? super T, ? super T> predicate) {
		return collectionsEquals(collection1, collection2, (v1, v2, index) -> predicate.test(v1, v2));
	}
	
	/**
	 * Проверяет, что две коллекции содержат одинаковые элементы
	 * @param collection1 первая коллекция
	 * @param collection2 вторая коллекция
	 * @param predicate предикат для сравнения элементов
	 */
	public static <T> boolean collectionsEquals(Collection<? extends T> collection1, Collection<? extends T> collection2, ObjObjIntPredicate<? super T, ? super T> predicate) {
		if (collection1.size() != collection2.size()) {
			return false;
		}
		
		return IteratorUtil.iteratorsEquals(collection1.iterator(), collection2.iterator(), predicate);
	}
}
