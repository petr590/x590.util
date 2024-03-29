package x590.util.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация-маркер. Означает, что все поля, возвращаемые значения в классе или пакете
 * и параметры метода не {@code null} по умолчанию.
 */
@Target({ElementType.TYPE, ElementType.PACKAGE})
@Retention(RetentionPolicy.CLASS)
@Documented
@Inherited
public @interface NonnullByDefault {}