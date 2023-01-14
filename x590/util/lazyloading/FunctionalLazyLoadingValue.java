package x590.util.lazyloading;

import java.util.function.Function;

import x590.util.annotation.Nonnull;

public class FunctionalLazyLoadingValue<T, R> extends AbstractLazyLoadingValue<Function<T, R>> implements Function<T, R> {
	
	private R value;
	
	public FunctionalLazyLoadingValue(@Nonnull Function<T, R> supplier) {
		super(supplier);
	}
	
	public R get(T t) {
		if(function == null)
			return value;
		
		value = function.apply(t);
		function = null;
		return value;
	}
	
	@Override
	public R apply(T t) {
		return get(t);
	}
	
	public boolean isNull(T t) {
		return get(t) == null;
	}
	
	public boolean isNonNull(T t) {
		return get(t) != null;
	}
	
	public R get() {
		if(function == null)
			return value;
		
		throw new IllegalStateException("Value is not initialized");
	}
}