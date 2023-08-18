package x590.util.function;

@FunctionalInterface
public interface TriCharFunction<R> {
	R apply(char x, char y, char z);
}