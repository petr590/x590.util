package x590.util.lazyloading;

import x590.util.annotation.Nonnull;

class AbstractLongLazyLoading<S> extends AbstractLazyLoading<S> {
	
	protected long value;
	
	protected AbstractLongLazyLoading(@Nonnull S function) {
		super(function);
	}
	
	public long getRequired() {
		if(function == null)
			return value;
		
		throw new IllegalStateException("Value is not initialized");
	}
}
