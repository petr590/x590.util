package x590.util.lazyloading;

import java.util.function.LongSupplier;

import x590.util.annotation.Nonnull;

public class LazyLoadingLongValue extends AbstractLazyLoadingValue<LongSupplier> implements LongSupplier {
	
	private long value;
	
	public LazyLoadingLongValue(@Nonnull LongSupplier supplier) {
		super(supplier);
	}
	
	@Override	
	public long getAsLong() {
		if(function == null)
			return value;
		
		value = function.getAsLong();
		function = null;
		return value;
	}
}