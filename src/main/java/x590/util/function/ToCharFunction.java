package x590.util.function;

import java.util.function.ToIntFunction;

@FunctionalInterface
public interface ToCharFunction<T> extends ToIntFunction<T> {
	char applyAsChar(T t);

	@Override
	default int applyAsInt(T value) {
		return applyAsChar(value);
	}
}