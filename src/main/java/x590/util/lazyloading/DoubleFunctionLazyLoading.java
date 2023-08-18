package x590.util.lazyloading;

import x590.util.annotation.Nonnull;

import java.util.function.ToDoubleFunction;

public class DoubleFunctionLazyLoading<T> extends AbstractDoubleLazyLoading<ToDoubleFunction<T>>
		implements ToDoubleFunction<T> {
	
	public DoubleFunctionLazyLoading(@Nonnull ToDoubleFunction<T> supplier) {
		super(supplier);
	}
	
	@Override
	public double applyAsDouble(T t) {
		return get(t);
	}
	
	public double get(T t) {
		var function = this.function;
		
		if (function == null)
			return value;
		
		this.function = null;
		return this.value = function.applyAsDouble(t);
	}
}
