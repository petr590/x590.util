package x590.util.lazyloading;

import x590.util.annotation.Nonnull;
import x590.util.function.ObjToDoubleFunction;

public class DoubleFunctionLazyLoading<T> extends AbstractDoubleLazyLoading<ObjToDoubleFunction<T>>
		implements ObjToDoubleFunction<T> {
	
	public DoubleFunctionLazyLoading(@Nonnull ObjToDoubleFunction<T> supplier) {
		super(supplier);
	}
	
	@Override
	public double apply(T t) {
		return get(t);
	}
	
	public double get(T t) {
		var function = this.function;
		
		if(function == null)
			return value;
		
		this.function = null;
		return this.value = function.apply(t);
	}
}
