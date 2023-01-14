package x590.util.lazyloading;

import java.util.function.BooleanSupplier;

import x590.util.annotation.Nonnull;

public class LazyLoadingBooleanValue extends AbstractLazyLoadingValue<BooleanSupplier> implements BooleanSupplier {
	
	private boolean value;
	
	public LazyLoadingBooleanValue(@Nonnull BooleanSupplier supplier) {
		super(supplier);
	}
	
	@Override	
	public boolean getAsBoolean() {
		if(function == null)
			return value;
		
		value = function.getAsBoolean();
		function = null;
		return value;
	}
}