package com.jvalidation.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class ValidationUtil {

	public static <A extends Annotation> void handleEmailValidation(Object obj,Field field,Class<A> annotation) throws IllegalArgumentException, IllegalAccessException{
		Object value = field.get(obj);
		if(value == null || value.toString().equalsIgnoreCase("")){
			throw new RuntimeException(field.getName() +" email cannot be empty");
		}
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if(!value.toString().matches(EMAIL_REGEX)){
			throw new RuntimeException(field.getName() + " does not contain a valid email address");
		}
	}

	public static <A extends Annotation> void handleEmptyValidation(Object obj,Field field,Class<A> annotation) throws IllegalArgumentException, IllegalAccessException{
		Object value = field.get(obj);
		if(value != null){
			throw new RuntimeException(field.getName() + " should be empty");
		}
	}

	public static <A extends Annotation> void handleMobileValidation(Object obj,Field field,Class<A> annotation) throws IllegalArgumentException, IllegalAccessException{
		Object value = field.get(obj);
		if(value == null || value.toString().equalsIgnoreCase("")){
			throw new RuntimeException(field.getName() +" mobile number cannot be empty");
		}
		Pattern pattern = Pattern.compile("\\d{3}-\\d{7}");
		if (!pattern.matcher(value.toString()).matches()) {
			throw new RuntimeException(field.getName() + " contains invalid mobile number");
		}
	}

	public static <A extends Annotation> void handleNotEmptyValidation(Object obj,Field field,Class<A> annotation) throws IllegalArgumentException, IllegalAccessException{
		Object value = field.get(obj);
		if(value == null || value.toString().equalsIgnoreCase("")){
			throw new RuntimeException(field.getName() +" cannot be empty");
		}
	}

	public static <A extends Annotation> void handleNotNullValidation(Object obj,Field field,Class<A> annotation) throws IllegalArgumentException, IllegalAccessException{
		Object value = field.get(obj);
		if(value == null){
			throw new RuntimeException(field.getName() +" cannot be null");
		}
	}

	public static <A extends Annotation> void handleNullValidation(Object obj,Field field,Class<A> annotation) throws IllegalArgumentException, IllegalAccessException{
		Object value = field.get(obj);
		if(value != null){
			throw new RuntimeException(field.getName() + " should be null");
		}
	}

	public static <A extends Annotation> void handleRangeValidation(Object obj,Field field,Class<A> annotation) throws IllegalArgumentException, IllegalAccessException{
		Object value = field.get(obj);
		if(value == null){
			throw new RuntimeException(field.getName() +" cannot be null");
		}
	}

	public static <A extends Annotation> void handleRegexValidation(Object obj,Field field,Class<A> annotation){

	}

	public static <A extends Annotation> void handleMinValidation(Object obj,Field field,Class<A> annotation){

	}

	public static <A extends Annotation> void handleMaxValidation(Object obj,Field field,Class<A> annotation){
		//Max maxAnnotation = (Max)field.getAnnotation(Max.class);
	}
}
