package x590.util.function;

import java.util.function.Predicate;

@FunctionalInterface
public interface ToBooleanFunction<T> extends Predicate<T> {
	boolean applyAsBoolean(T t);

	@Override
	default boolean test(T t) {
		return applyAsBoolean(t);
	}
}