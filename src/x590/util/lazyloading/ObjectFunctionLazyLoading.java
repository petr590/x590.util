package x590.util.lazyloading;

import java.util.function.Function;

import x590.util.annotation.Nonnull;

public class ObjectFunctionLazyLoading<T, R> extends AbstractObjectLazyLoading<R, Function<T, R>>
		implements Function<T, R> {
	
	private R value;
	
	public ObjectFunctionLazyLoading(@Nonnull Function<T, R> supplier) {
		super(supplier);
	}
	
	@Override
	public R apply(T t) {
		return get(t);
	}
	
	public R get(T t) {
		var function = this.function;
		
		if(function == null)
			return value;
		
		this.function = null;
		return this.value = function.apply(t);
	}
	
	public boolean isNullValue(T t) {
		return get(t) == null;
	}
	
	public boolean isNonNullValue(T t) {
		return get(t) != null;
	}
}
