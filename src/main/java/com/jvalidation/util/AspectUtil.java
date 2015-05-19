package com.jvalidation.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

public class AspectUtil {

	public static Method getMethod(JoinPoint joinPoint) {
		return ((MethodSignature)joinPoint.getSignature()).getMethod();
	}
	
	public static Object[] getParameters(JoinPoint joinPoint){
		return joinPoint.getArgs();
	}
	
	public static <A extends Annotation> Boolean isAnnotationPresent(Class<?> clazz,Class<A> annotationClazz){
		return clazz.getAnnotation(annotationClazz) != null;
	}
}
