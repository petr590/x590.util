package x590.util.function.throwing;

public interface ThrowingBiConsumer<T, U, E extends Throwable> {
	void accept(T t, U u) throws E;
}
