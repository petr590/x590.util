package x590.util.function.throwing;

public interface ThrowingFunction<T, R, E extends Throwable> {
	R accept(T t) throws E;
}
