package x590.util.function;

@FunctionalInterface
public interface TriIntFunction<R> {
	R apply(int x, int y, int z);
}