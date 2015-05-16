package com.jvalidation.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.jvalidation.annotations.Validate;
import com.jvalidation.util.AspectUtil;

@Aspect
@Component("validationAspect")
public class ValidationAspect {

	@Pointcut("execution(public * *(..))")
	public void validationPointcut(){}
	
	@Before("validationPointcut")
	public void beforeExecution(JoinPoint joinPoint){
		if(joinPoint.getArgs().length > 0){
			Class<?>[] parameters = AspectUtil.getParameters(joinPoint);
			for (Class<?> parameter : parameters) {
				if(AspectUtil.isAnnotationPresent(parameter, Validate.class)){
					
				}
			}
		}
	}

}
	