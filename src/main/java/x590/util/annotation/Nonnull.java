package x590.util.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Аннотация-маркер, как и {@link Nullable}.
 * Означает, что поле, возвращаемое значение или параметр
 * метода не должен быть равен {@code null}.
 */
@Target({ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.SOURCE)
@Documented
@Inherited
public @interface Nonnull {}