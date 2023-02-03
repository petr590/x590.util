package x590.util.lazyloading;

import x590.util.annotation.Nonnull;
import x590.util.function.ObjToBooleanFunction;

public class FunctionalLazyLoadingBooleanValue<T> extends AbstractLazyLoadingValue<ObjToBooleanFunction<T>> implements ObjToBooleanFunction<T> {
	
	private boolean value;
	
	public FunctionalLazyLoadingBooleanValue(@Nonnull ObjToBooleanFunction<T> supplier) {
		super(supplier);
	}
	
	public boolean get(T t) {
		if(function == null)
			return value;
		
		value = function.apply(t);
		function = null;
		return value;
	}
	
	@Override	
	public boolean apply(T t) {
		return get(t);
	}
	
	public boolean getRequired() {
		if(function == null)
			return value;
		
		throw new IllegalStateException("Value is not initialized");
	}
}