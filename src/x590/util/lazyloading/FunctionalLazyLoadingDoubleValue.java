package x590.util.lazyloading;

import x590.util.annotation.Nonnull;
import x590.util.function.ObjToDoubleFunction;

public class FunctionalLazyLoadingDoubleValue<T> extends AbstractLazyLoadingValue<ObjToDoubleFunction<T>> implements ObjToDoubleFunction<T> {
	
	private double value;
	
	public FunctionalLazyLoadingDoubleValue(@Nonnull ObjToDoubleFunction<T> supplier) {
		super(supplier);
	}
	
	public double get(T t) {
		if(function == null)
			return value;
		
		value = function.apply(t);
		function = null;
		return value;
	}
	
	@Override
	public double apply(T t) {
		return get(t);
	}
	
	public double getRequired() {
		if(function == null)
			return value;
		
		throw new IllegalStateException("Value is not initialized");
	}
}