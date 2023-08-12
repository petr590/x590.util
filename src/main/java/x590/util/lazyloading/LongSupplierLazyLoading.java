package x590.util.lazyloading;

import java.util.function.LongSupplier;

import x590.util.annotation.Nonnull;

public class LongSupplierLazyLoading extends AbstractLongLazyLoading<LongSupplier> implements LongSupplier {
	
	public LongSupplierLazyLoading(@Nonnull LongSupplier supplier) {
		super(supplier);
	}
	
	@Override	
	public long getAsLong() {
		var function = this.function;
		
		if (function == null)
			return value;
		
		this.function = null;
		return this.value = function.getAsLong();
	}
}