package x590.util.lazyloading;

import x590.util.annotation.Nonnull;
import x590.util.function.ObjToIntFunction;

public class FunctionalLazyLoadingIntValue<T> extends AbstractLazyLoadingValue<ObjToIntFunction<T>> implements ObjToIntFunction<T> {
	
	private int value;
	
	public FunctionalLazyLoadingIntValue(@Nonnull ObjToIntFunction<T> supplier) {
		super(supplier);
	}
	
	public int get(T t) {
		if(function == null)
			return value;
		
		value = function.apply(t);
		function = null;
		return value;
	}
	
	@Override
	public int apply(T t) {
		return get(t);
	}
	
	public int getRequired() {
		if(function == null)
			return value;
		
		throw new IllegalStateException("Value is not initialized");
	}
}