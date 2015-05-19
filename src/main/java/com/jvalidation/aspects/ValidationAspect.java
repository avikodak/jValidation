package com.jvalidation.aspects;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.jvalidation.annotations.Email;
import com.jvalidation.annotations.Empty;
import com.jvalidation.annotations.Max;
import com.jvalidation.annotations.Min;
import com.jvalidation.annotations.Mobile;
import com.jvalidation.annotations.NotEmpty;
import com.jvalidation.annotations.NotNull;
import com.jvalidation.annotations.Null;
import com.jvalidation.annotations.Range;
import com.jvalidation.annotations.Regex;
import com.jvalidation.annotations.Validate;
import com.jvalidation.util.AspectUtil;
import com.jvalidation.util.ValidationUtil;

@Aspect
@Component("validationAspect")
public class ValidationAspect {

	@Pointcut("execution(* *(..))")
	public void validationPointcut(){}
	
	@Before("validationPointcut()")
	public void beforeExecution(JoinPoint joinPoint) throws Exception{
		if(joinPoint.getArgs().length > 0){
			performValidation(joinPoint);
		}
	}

	private void performValidation(JoinPoint joinPoint) throws Exception{
		Object[] arguments = AspectUtil.getParameters(joinPoint);
		for (Object object : arguments) {
			Class<?> parameter = object.getClass();
			if(AspectUtil.isAnnotationPresent(parameter, Validate.class)){
				Field[] fields = parameter.getDeclaredFields();
				for (Field field : fields) {
					for (Annotation annotation : field.getAnnotations()) {
						if(annotation.annotationType() == NotNull.class){
							ValidationUtil.handleNotNullValidation(object,field, annotation.annotationType());
						}
						if(annotation.annotationType() == Null.class){
							ValidationUtil.handleNullValidation(object,field, annotation.annotationType());
						}
						if(annotation.annotationType() == Empty.class){
							ValidationUtil.handleEmptyValidation(object,field, annotation.annotationType());
						}
						if(annotation.annotationType() == NotEmpty.class){
							ValidationUtil.handleNotEmptyValidation(object,field, annotation.annotationType());
						}
						if(annotation.annotationType() == Range.class){
							ValidationUtil.handleRangeValidation(object,field, annotation.annotationType());
						}
						if(annotation.annotationType() == Email.class){
							ValidationUtil.handleEmailValidation(object,field, annotation.annotationType());
						}
						if(annotation.annotationType() == Mobile.class){
							ValidationUtil.handleMobileValidation(object,field, annotation.annotationType());
						}
						if(annotation.annotationType() == Regex.class){
							ValidationUtil.handleRegexValidation(object,field, annotation.annotationType());
						}
						if(annotation.annotationType() == Min.class){
							ValidationUtil.handleMinValidation(object, field,annotation.annotationType());
						}
						if(annotation.annotationType() == Max.class){
							ValidationUtil.handleMaxValidation(object, field,annotation.annotationType());
						}
					}
				}
			}
		}
	}
	
}
	