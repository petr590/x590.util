package x590.util.function.throwing;

public interface ThrowingConsumer<T, E extends Throwable> {
	void accept(T t) throws E;
}
