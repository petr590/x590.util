package x590.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Показывает, что массив должен быть отсортирован.
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
public @interface Sorted {

	public Order order() default Order.ASCENDING;

	public enum Order {
		ASCENDING, DESCENDING
	}
}