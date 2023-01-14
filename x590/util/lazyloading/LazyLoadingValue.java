package x590.util.lazyloading;

import java.util.function.Supplier;

import x590.util.annotation.Nonnull;

public class LazyLoadingValue<T> extends AbstractLazyLoadingValue<Supplier<T>> implements Supplier<T> {
	
	private T value;
	
	public LazyLoadingValue(@Nonnull Supplier<T> supplier) {
		super(supplier);
	}
	
	@Override	
	public T get() {
		if(function == null)
			return value;
		
		value = function.get();
		function = null;
		return value;
	}
}