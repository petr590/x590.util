package x590.util.lazyloading;

import java.util.function.DoubleSupplier;

import x590.util.annotation.Nonnull;

public class LazyLoadingDoubleValue extends AbstractLazyLoadingValue<DoubleSupplier> implements DoubleSupplier {
	
	private double value;
	
	public LazyLoadingDoubleValue(@Nonnull DoubleSupplier supplier) {
		super(supplier);
	}
	
	@Override	
	public double getAsDouble() {
		if(function == null)
			return value;
		
		value = function.getAsDouble();
		function = null;
		return value;
	}
}