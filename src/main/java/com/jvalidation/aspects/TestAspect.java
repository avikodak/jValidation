package com.jvalidation.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component("testAspect")
public class TestAspect {

	@Before("execution(* com.jvalidation.services.AbstractTestService.testService(..))")
	public void test(){
		System.out.println("Before Aspect");
	}
	
	@After("execution(* com.jvalidation.services.AbstractTestService.testService(..))")
	public void testAfter(JoinPoint joinPoint){
		System.out.println("After Aspect : " + joinPoint.getSignature().getName());
	}
	
	@Around("execution(* com.jvalidation.services.AbstractTestService.testService(..))")
	public void testAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Around aspect start");
		long start = System.currentTimeMillis();
		joinPoint.proceed();
		long end = System.currentTimeMillis();
		System.out.println("Execution time : " + (end-start));
		System.out.println("Around aspect end");
	}
}
