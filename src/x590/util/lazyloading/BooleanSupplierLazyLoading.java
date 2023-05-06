package x590.util.lazyloading;

import java.util.function.BooleanSupplier;

import x590.util.annotation.Nonnull;

public class BooleanSupplierLazyLoading extends AbstractBooleanLazyLoading<BooleanSupplier> implements BooleanSupplier {
	
	private boolean value;
	
	public BooleanSupplierLazyLoading(@Nonnull BooleanSupplier supplier) {
		super(supplier);
	}
	
	@Override	
	public boolean getAsBoolean() {
		var function = this.function;
		
		if(function == null)
			return value;
		
		this.function = null;
		return this.value = function.getAsBoolean();
	}
	
	public boolean isTrue() {
		return getAsBoolean();
	}
	
	public boolean isFalse() {
		return getAsBoolean() ^ true; // fast invert
	}
}
