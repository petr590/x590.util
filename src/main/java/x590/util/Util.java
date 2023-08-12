package x590.util;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;

import x590.util.annotation.Nullable;

public final class Util {
	
	private Util() {}
	
	
	/**
	 * Вызывает переданную функцию для переданного аргумента.
	 * Удобно при инициализации коллекций и мап.
	 * @param value аргумент, для которого вызывается функция maker
	 * @param maker вызывается для value
	 */
	public static <T> T make(T value, Consumer<? super T> maker) {
		maker.accept(value);
		return value;
	}
	
	/** @return {@code new ArrayList<T>()} после применения функции maker
	 * @see #make(Object, Consumer) */
	public static <T> ArrayList<T> makeArrayList(Consumer<? super ArrayList<T>> maker) {
		return make(new ArrayList<>(), maker);
	}
	
	/** @return {@code new HashMap<T>()} после применения функции maker
	 * @see #make(Object, Consumer) */
	public static <K, V> HashMap<K, V> makeHashMap(Consumer<? super HashMap<K, V>> maker) {
		return make(new HashMap<>(), maker);
	}
	
	/** @return {@code new HashSet<T>()} после применения функции maker
	 * @see #make(Object, Consumer) */
	public static <T> HashSet<T> makeHashSet(Consumer<? super HashSet<T>> maker) {
		return make(new HashSet<>(), maker);
	}

	
	/** @return {@code new ArrayList<T>(initialCapacity)} после применения функции maker
	 * @see #make(Object, Consumer) */
	public static <T> ArrayList<T> makeArrayList(int initialCapacity, Consumer<? super ArrayList<T>> maker) {
		return make(new ArrayList<>(initialCapacity), maker);
	}
	
	/** @return {@code new HashMap<T>(initialCapacity)} после применения функции maker
	 * @see #make(Object, Consumer) */
	public static <K, V> HashMap<K, V> makeHashMap(int initialCapacity, Consumer<? super HashMap<K, V>> maker) {
		return make(new HashMap<>(initialCapacity), maker);
	}
	
	/** @return {@code new HashSet<T>(initialCapacity)} после применения функции maker
	 * @see #make(Object, Consumer) */
	public static <T> HashSet<T> makeHashSet(int initialCapacity, Consumer<? super HashSet<T>> maker) {
		return make(new HashSet<>(initialCapacity), maker);
	}
	
	
	/** Добавляет элемент в коллекцию и возвращает его.
	 * Удобно использовать в лямбдах, где важна краткость кода */
	public static <E> E addAndGetBack(Collection<? super E> collection, E element) {
		collection.add(element);
		return element;
	}
	
	/** Применяет функцию {@code getter} для объекта {@code object}, если он не {@code null},
	 * иначе возвращает {@code null}. */
	public static <T, U> @Nullable U getIfNonNull(@Nullable T object, Function<? super T, ? extends U> getter) {
		return object != null ? getter.apply(object) : null;
	}
	
	/** Применяет функцию {@code getter} для объекта {@code object}, если он не {@code null},
	 * иначе возвращает {@code defaultValue}. */
	public static <T, U> U getIfNonNull(@Nullable T object, Function<? super T, ? extends U> getter, U defaultValue) {
		return object != null ? getter.apply(object) : defaultValue;
	}


	/** @return Случайный элемент из списка, выбранный с помощью {@link ThreadLocalRandom#nextInt(int, int)} */
	public static <T> T getRandomByThreadLocalRandom(List<? extends T> values) {
		return values.get(ThreadLocalRandom.current().nextInt(0, values.size()));
	}
}
