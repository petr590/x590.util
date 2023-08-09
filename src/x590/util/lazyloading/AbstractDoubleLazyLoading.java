package x590.util.lazyloading;

import x590.util.annotation.Nonnull;

class AbstractDoubleLazyLoading<S> extends AbstractLazyLoading<S> {
	
	protected double value;
	
	protected AbstractDoubleLazyLoading(@Nonnull S function) {
		super(function);
	}
	
	public double getRequired() {
		if (function == null)
			return value;
		
		throw new IllegalStateException("Value is not initialized");
	}
}
