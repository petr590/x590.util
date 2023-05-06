package x590.util.lazyloading;

import java.util.function.Supplier;

import x590.util.annotation.Nonnull;

public class ObjectSupplierLazyLoading<T> extends AbstractObjectLazyLoading<T, Supplier<T>> implements Supplier<T> {
	
	public ObjectSupplierLazyLoading(@Nonnull Supplier<T> supplier) {
		super(supplier);
	}
	
	@Override
	public T get() {
		var function = this.function;
		
		if(function == null)
			return value;
		
		this.function = null;
		return this.value = function.get();
	}
	
	public boolean isNullValue() {
		return get() == null;
	}
	
	public boolean isNonNullValue() {
		return get() != null;
	}
}
