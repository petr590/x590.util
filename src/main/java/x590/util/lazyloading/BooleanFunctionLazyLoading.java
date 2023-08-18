package x590.util.lazyloading;

import x590.util.annotation.Nonnull;
import x590.util.function.ToBooleanFunction;

public class BooleanFunctionLazyLoading<T> extends AbstractBooleanLazyLoading<ToBooleanFunction<T>>
		implements ToBooleanFunction<T> {
	
	public BooleanFunctionLazyLoading(@Nonnull ToBooleanFunction<T> supplier) {
		super(supplier);
	}
	
	@Override	
	public boolean applyAsBoolean(T t) {
		return get(t);
	}
	
	public boolean get(T t) {
		var function = this.function;
		
		if (function == null)
			return value;
		
		this.function = null;
		return this.value = function.applyAsBoolean(t);
	}
	
	public boolean isTrue(T t) {
		return get(t);
	}
	
	public boolean isFalse(T t) {
		return get(t) ^ true; // fast invert
	}
}
