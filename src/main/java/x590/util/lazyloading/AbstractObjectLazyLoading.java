package x590.util.lazyloading;

import x590.util.annotation.Nonnull;

class AbstractObjectLazyLoading<T, S> extends AbstractLazyLoading<S> {
	
	protected T value;
	
	protected AbstractObjectLazyLoading(@Nonnull S function) {
		super(function);
	}
	
	public T getRequired() {
		if (function == null)
			return value;
		
		throw new IllegalStateException("Value is not initialized");
	}
}
