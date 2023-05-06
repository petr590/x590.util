package x590.util.lazyloading;

import java.util.function.DoubleSupplier;

import x590.util.annotation.Nonnull;

public class DoubleSupplierLazyLoading extends AbstractDoubleLazyLoading<DoubleSupplier> implements DoubleSupplier {
	
	public DoubleSupplierLazyLoading(@Nonnull DoubleSupplier supplier) {
		super(supplier);
	}
	
	@Override	
	public double getAsDouble() {
		var function = this.function;
		
		if(function == null)
			return value;
		
		this.function = null;
		return this.value = function.getAsDouble();
	}
}