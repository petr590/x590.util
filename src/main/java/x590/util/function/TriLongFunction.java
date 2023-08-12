package x590.util.function;

@FunctionalInterface
public interface TriLongFunction<R> {
	R apply(long x, long y, long z);
}