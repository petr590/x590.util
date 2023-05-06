package x590.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Consumer;
import java.util.function.Function;

import x590.util.annotation.Nullable;

public class Util {
	
	private Util() {}
	
	
	/**
	 * Вызывает переданную функцию для переданного аргумента.
	 * Удобно при инициализации коллекций и мап.
	 * @param value - агрумент, для которого вызывается функция maker
	 * @param maker - вызывается для value
	 */
	public static <T> T make(T value, Consumer<? super T> maker) {
		maker.accept(value);
		return value;
	}
	
	public static <T> ArrayList<T> makeArrayList(Consumer<? super ArrayList<T>> maker) {
		return make(new ArrayList<>(), maker);
	}
	
	public static <K, V> HashMap<K, V> makeHashMap(Consumer<? super HashMap<K, V>> maker) {
		return make(new HashMap<>(), maker);
	}
	
	public static <T> HashSet<T> makeHashSet(Consumer<? super HashSet<T>> maker) {
		return make(new HashSet<>(), maker);
	}

	
	public static <T> ArrayList<T> makeArrayList(int size, Consumer<? super ArrayList<T>> maker) {
		return make(new ArrayList<>(size), maker);
	}
	
	public static <K, V> HashMap<K, V> makeHashMap(int size, Consumer<? super HashMap<K, V>> maker) {
		return make(new HashMap<>(size), maker);
	}
	
	public static <T> HashSet<T> makeHashSet(int size, Consumer<? super HashSet<T>> maker) {
		return make(new HashSet<>(size), maker);
	}
	
	
	/** Добавляет элемент в коллекцию и возвращает его.
	 * Удобно использовать в лямбдах, где важна краткость кода */
	public static <E> E addAndGetBack(Collection<? super E> collection, E element) {
		collection.add(element);
		return element;
	}
	
	/** Применяет функцию {@code getter} для объекта {@code object}, если он не {@literal null},
	 * иначе возвращает {@literal null}. */
	public static <T, U> @Nullable U getIfNonNull(@Nullable T object, Function<? super T, ? extends U> getter) {
		return object != null ? getter.apply(object) : null;
	}
	
	/** Применяет функцию {@code getter} для объекта {@code object}, если он не {@literal null},
	 * иначе возвращает {@code defaultValue}. */
	public static <T, U> U getIfNonNull(@Nullable T object, Function<? super T, ? extends U> getter, U defaultValue) {
		return object != null ? getter.apply(object) : defaultValue;
	}
}
