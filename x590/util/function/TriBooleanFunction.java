package x590.util.function;

@FunctionalInterface
public interface TriBooleanFunction<R> {
	R apply(boolean x, boolean y, boolean z);
}