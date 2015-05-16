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

	@Pointcut("execution(public * *(..))")
	public void validationPointcut(){}
	
	@Before("validationPointcut")
	public void beforeExecution(JoinPoint joinPoint){
		if(joinPoint.getArgs().length > 0){
			performValidation(joinPoint);
		}
	}

	private void performValidation(JoinPoint joinPoint) {
		Class<?>[] parameters = AspectUtil.getParameters(joinPoint);
		for (Class<?> parameter : parameters) {
			if(AspectUtil.isAnnotationPresent(parameter, Validate.class)){
				Field[] fields = parameter.getFields();
				for (Field field : fields) {
					for (Annotation annotation : field.getAnnotations()) {
						if(annotation.getClass() == NotNull.class){
							ValidationUtil.handleNotNullValidation(field, annotation);
						}
						if(annotation.getClass() == Null.class){
							ValidationUtil.handleNullValidation(field, annotation);
						}
						if(annotation.getClass() == Empty.class){
							ValidationUtil.handleEmptyValidation(field, annotation);
						}
						if(annotation.getClass() == NotEmpty.class){
							ValidationUtil.handleNotEmptyValidation(field, annotation);
						}
						if(annotation.getClass() == Range.class){
							ValidationUtil.handleRangeValidation(field, annotation);
						}
						if(annotation.getClass() == Email.class){
							ValidationUtil.handleEmailValidation(field, annotation);
						}
						if(annotation.getClass() == Mobile.class){
							ValidationUtil.handleMobileValidation(field, annotation);
						}
						if(annotation.getClass() == Regex.class){
							ValidationUtil.handleRegexValidation(field, annotation);
						}
					}
				}
			}
		}
	}
	
}
	