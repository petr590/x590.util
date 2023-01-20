package x590.util.lazyloading;

import java.util.function.IntSupplier;

import x590.util.annotation.Nonnull;

public class LazyLoadingIntValue extends AbstractLazyLoadingValue<IntSupplier> implements IntSupplier {
	
	private int value;
	
	public LazyLoadingIntValue(@Nonnull IntSupplier supplier) {
		super(supplier);
	}
	
	@Override	
	public int getAsInt() {
		if(function == null)
			return value;
		
		value = function.getAsInt();
		function = null;
		return value;
	}
}