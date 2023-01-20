package x590.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Означает, что класс, поле, метод или параметр метода
 * может быть удалён, если не понадобится в дальнейшем.
 * Такие сущности не должны быть частью внешнего API.
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.CLASS)
public @interface RemoveIfNotUsed {}