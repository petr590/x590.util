package x590.util.function.throwing;

public interface ThrowingBiFunction<T, U, R, E extends Throwable> {
	R accept(T t, U u) throws E;
}
