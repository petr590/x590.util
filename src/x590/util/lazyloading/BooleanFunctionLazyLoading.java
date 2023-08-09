package x590.util.lazyloading;

import x590.util.annotation.Nonnull;
import x590.util.function.ObjToBooleanFunction;

public class BooleanFunctionLazyLoading<T> extends AbstractBooleanLazyLoading<ObjToBooleanFunction<T>>
		implements ObjToBooleanFunction<T> {
	
	public BooleanFunctionLazyLoading(@Nonnull ObjToBooleanFunction<T> supplier) {
		super(supplier);
	}
	
	@Override	
	public boolean apply(T t) {
		return get(t);
	}
	
	public boolean get(T t) {
		var function = this.function;
		
		if (function == null)
			return value;
		
		this.function = null;
		return this.value = function.apply(t);
	}
	
	public boolean isTrue(T t) {
		return get(t);
	}
	
	public boolean isFalse(T t) {
		return get(t) ^ true; // fast invert
	}
}
