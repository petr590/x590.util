package x590.util;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ReflectUtil {
	
	private ReflectUtil() {}
	
	
	/** {@code highClass} по умолчанию {@code Object.class}.
	 * @see #objectsEquals(Object, Object, Class) */
	public static <T> boolean objectsEquals(T obj1, T obj2) {
		return objectsEquals(obj1, obj2, Object.class);
	}
	
	
	/** Этот метод предназначен, чтобы не писать для каждого класса метод equals,
	 * если этих классов много. Он сравнивает объекты одинаковых классов через рефлексию
	 * и возвращает {@literal true} только если все их поля равны.
	 * @param obj1 - объект для сравнения с obj2
	 * @param obj2 - объект для сравнения с obj1
	 * @param highClass - До какого класса сравнивать (включительно) */
	public static <T> boolean objectsEquals(T obj1, T obj2, Class<? extends T> highClass) {
		if(obj1 == obj2) {
			return true;
		}
		
		if(obj1 == null || obj2 == null) {
			return false;
		}
		
		Class<?> clazz = obj1.getClass();
		
		if(!highClass.isAssignableFrom(clazz) || obj2.getClass() != clazz) {
			return false;
		}
		
		try {
			return objectsEquals0(obj1, obj2, clazz, highClass);
		} catch(IllegalArgumentException | IllegalAccessException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	
	private static boolean objectsEquals0(Object obj1, Object obj2, Class<?> clazz, Class<?> highClass) throws IllegalArgumentException, IllegalAccessException {
		for(Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			
			if(!fieldsEquals(field, obj1, obj2)) {
				return false;
			}
		}
		
		return clazz == highClass ? true : objectsEquals0(obj1, obj2, clazz.getSuperclass(), highClass);
	}
	
	
	private static boolean fieldsEquals(Field field, Object obj1, Object obj2) throws IllegalArgumentException, IllegalAccessException {
		Class<?> fieldType = field.getType();
		
		if(fieldType.isPrimitive()) {
			if(fieldType == int.class) return field.getInt(obj1) == field.getInt(obj2);
			if(fieldType == long.class) return field.getLong(obj1) == field.getLong(obj2);
			if(fieldType == float.class) return field.getFloat(obj1) == field.getFloat(obj2);
			if(fieldType == double.class) return field.getDouble(obj1) == field.getDouble(obj2);
			if(fieldType == boolean.class) return field.getBoolean(obj1) == field.getBoolean(obj2);
			if(fieldType == byte.class) return field.getByte(obj1) == field.getByte(obj2);
			if(fieldType == char.class) return field.getChar(obj1) == field.getChar(obj2);
			if(fieldType == short.class) return field.getShort(obj1) == field.getShort(obj2);
		}
		
		Object value1 = field.get(obj1),
				value2 = field.get(obj2);
		
		if(value1 == value2)
			return true;
		
		if(value1 == null || value2 == null)
			return false;
		
		if(fieldType.isArray()) {
			Class<?> componentType = fieldType.componentType();
			if(componentType.isPrimitive()) {
				if(componentType == byte.class) return Arrays.equals((byte[])value1, (byte[])value2);
				if(componentType == char.class) return Arrays.equals((char[])value1, (char[])value2);
				if(componentType == int.class) return Arrays.equals((int[])value1, (int[])value2);
				if(componentType == long.class) return Arrays.equals((long[])value1, (long[])value2);
				if(componentType == float.class) return Arrays.equals((float[])value1, (float[])value2);
				if(componentType == double.class) return Arrays.equals((double[])value1, (double[])value2);
				if(componentType == short.class) return Arrays.equals((short[])value1, (short[])value2);
				if(componentType == boolean.class) return Arrays.equals((boolean[])value1, (boolean[])value2);
			}
			
			return Arrays.deepEquals((Object[])value1, (Object[])value2);
		}
		
		return value1.equals(value2);
	}
}