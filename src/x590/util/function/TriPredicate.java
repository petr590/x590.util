package x590.util.function;

@FunctionalInterface
public interface TriPredicate<T, U, V> {

	boolean test(T value1, U value2, V value3);
}
