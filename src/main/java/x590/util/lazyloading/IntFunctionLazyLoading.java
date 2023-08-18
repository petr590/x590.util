package x590.util.lazyloading;

import x590.util.annotation.Nonnull;

import java.util.function.ToIntFunction;

public class IntFunctionLazyLoading<T> extends AbstractIntLazyLoading<ToIntFunction<T>>
		implements ToIntFunction<T> {
	
	public IntFunctionLazyLoading(@Nonnull ToIntFunction<T> supplier) {
		super(supplier);
	}
	
	@Override
	public int applyAsInt(T t) {
		return get(t);
	}
	
	public int get(T t) {
		var function = this.function;
		
		if (function == null)
			return value;
		
		this.function = null;
		return this.value = function.applyAsInt(t);
	}
}
