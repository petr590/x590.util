package x590.util.lazyloading;

import x590.util.annotation.Nonnull;
import x590.util.function.ObjToIntFunction;

public class IntFunctionLazyLoading<T> extends AbstractIntLazyLoading<ObjToIntFunction<T>>
		implements ObjToIntFunction<T> {
	
	public IntFunctionLazyLoading(@Nonnull ObjToIntFunction<T> supplier) {
		super(supplier);
	}
	
	@Override
	public int apply(T t) {
		return get(t);
	}
	
	public int get(T t) {
		var function = this.function;
		
		if (function == null)
			return value;
		
		this.function = null;
		return this.value = function.apply(t);
	}
}
