package x590.util.lazyloading;

import x590.util.annotation.Nonnull;
import x590.util.function.ObjToLongFunction;

public class FunctionalLazyLoadingLongValue<T> extends AbstractLazyLoadingValue<ObjToLongFunction<T>> implements ObjToLongFunction<T> {
	
	private long value;
	
	public FunctionalLazyLoadingLongValue(@Nonnull ObjToLongFunction<T> supplier) {
		super(supplier);
	}
	
	public long get(T t) {
		if(function == null)
			return value;
		
		value = function.apply(t);
		function = null;
		return value;
	}
	
	@Override
	public long apply(T t) {
		return get(t);
	}
	
	public long getRequired() {
		if(function == null)
			return value;
		
		throw new IllegalStateException("Value is not initialized");
	}
}