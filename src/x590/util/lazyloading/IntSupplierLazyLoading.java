package x590.util.lazyloading;

import java.util.function.IntSupplier;

import x590.util.annotation.Nonnull;

public class IntSupplierLazyLoading extends AbstractIntLazyLoading<IntSupplier> implements IntSupplier {
	
	public IntSupplierLazyLoading(@Nonnull IntSupplier supplier) {
		super(supplier);
	}
	
	@Override	
	public int getAsInt() {
		var function = this.function;
		
		if(function == null)
			return value;
		
		this.function = null;
		return this.value = function.getAsInt();
	}
}