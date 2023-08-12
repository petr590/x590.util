package x590.util.lazyloading;

import x590.util.annotation.Nonnull;

class AbstractIntLazyLoading<S> extends AbstractLazyLoading<S> {
	
	protected int value;
	
	protected AbstractIntLazyLoading(@Nonnull S function) {
		super(function);
	}
	
	public int getRequired() {
		if (function == null)
			return value;
		
		throw new IllegalStateException("Value is not initialized");
	}
}
