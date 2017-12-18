package com.org.fsc.util;

import java.lang.reflect.Field;

public class ReflectHelper {
	
	/**
	 *获取需要反射的    变量或方法    通过类名 加   变量或方法名
	 * fsc
	 * 20172017年11月21日2017年11月21日
	 * @param object
	 * @param fileName
	 * @return
	 * 2017年11月21日
	 * 上午9:25:01
	 * @throws NoSuchFieldException 
	 * @throws SecurityException 
	 */
	public static Field getFieldByFieldName(Object object,String fileName) throws SecurityException, NoSuchFieldException {
			//反射该object类并通过fileName得到该field
		for (Class<?> superClass = object.getClass();
				superClass != Object.class;
				superClass = superClass.getSuperclass()) {
					try {
						return superClass.getDeclaredField(fileName);
					} catch (NoSuchFieldException e) {
					}
				}
		return null;
	}
	
	/**
	 *获取反射类中变量值
	 * fsc
	 * 20172017年11月21日2017年11月21日
	 * @param object
	 * @param fieldName
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * 2017年11月21日
	 * 上午11:07:52
	 */
	public static Object getFieldValue(Object object,String fieldName) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
		Field field=getFieldByFieldName(object,fieldName);
		Object value = null;
		if(field!=null) {
			if(field.isAccessible()) {
					value=field.get(object);
			}else {
				field.setAccessible(true);
				value=field.get(object);
			}
			return value;
		}
		return null;
	}
	
	/**
	 *设置反射类中变量值
	 * fsc
	 * 20172017年11月21日2017年11月21日
	 * @param object
	 * @param fieldName
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * 2017年11月21日
	 * 上午11:08:21
	 */
	public static void setFieldValue(Object object,String fieldName,String value) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Field field=getFieldByFieldName(object,fieldName);
		if(field.isAccessible()) {
			field.set(object, value);
		}else {
			field.setAccessible(true);
			field.set(object, value);
		}
	}

}
