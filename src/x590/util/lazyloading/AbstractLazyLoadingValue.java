package x590.util.lazyloading;

import java.util.Objects;

import x590.util.annotation.Nonnull;
import x590.util.annotation.Nullable;

/**
 * Выполняет функцию только один раз по требованию,
 * после этого кеширует значение в поле {@link #value}.
 * Поле должно быть объявлено в дочернем классе, так как
 * его тип зависит от реализации.
 * 
 * Тип {@code S} должен быть любым функциональным интерфейсом
 */
class AbstractLazyLoadingValue<S> {
	
	/**
	 * Если {@code supplier} равен {@literal null},
	 * это значит, что поле {@link #value} инициализировано
	 */
	@Nullable
	protected S function;
	
	protected AbstractLazyLoadingValue(@Nonnull S function) {
		this.function = Objects.requireNonNull(function);
	}
}