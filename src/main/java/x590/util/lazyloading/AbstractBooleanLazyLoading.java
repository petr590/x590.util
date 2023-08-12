package x590.util.lazyloading;

import x590.util.annotation.Nonnull;

class AbstractBooleanLazyLoading<S> extends AbstractLazyLoading<S> {
	
	protected boolean value;
	
	protected AbstractBooleanLazyLoading(@Nonnull S function) {
		super(function);
	}
	
	public boolean getRequired() {
		if (function == null)
			return value;
		
		throw new IllegalStateException("Value is not initialized");
	}
}
