package x590.util.lazyloading;

import x590.util.annotation.Nonnull;

import java.util.function.ToLongFunction;

public class LongFunctionLazyLoading<T> extends AbstractLongLazyLoading<ToLongFunction<T>>
		implements ToLongFunction<T> {
	
	public LongFunctionLazyLoading(@Nonnull ToLongFunction<T> supplier) {
		super(supplier);
	}
	
	@Override
	public long applyAsLong(T t) {
		return get(t);
	}
	
	public long get(T t) {
		var function = this.function;
		
		if (function == null)
			return value;
		
		this.function = null;
		return this.value = function.applyAsLong(t);
	}
}