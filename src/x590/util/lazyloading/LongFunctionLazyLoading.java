package x590.util.lazyloading;

import x590.util.annotation.Nonnull;
import x590.util.function.ObjToLongFunction;

public class LongFunctionLazyLoading<T> extends AbstractLongLazyLoading<ObjToLongFunction<T>>
		implements ObjToLongFunction<T> {
	
	public LongFunctionLazyLoading(@Nonnull ObjToLongFunction<T> supplier) {
		super(supplier);
	}
	
	@Override
	public long apply(T t) {
		return get(t);
	}
	
	public long get(T t) {
		var function = this.function;
		
		if(function == null)
			return value;
		
		this.function = null;
		return this.value = function.apply(t);
	}
}