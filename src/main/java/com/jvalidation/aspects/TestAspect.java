package com.jvalidation.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component("testAspect")
public class TestAspect {

	@Pointcut("execution(public * *(..)),")
	public void publicPointCut() {}
	
	@Before("publicPointCut()")
	public void test(){
		System.out.println("Before Aspect");
	}
	
	@After("publicPointCut()")
	public void testAfter(JoinPoint joinPoint){
		System.out.println("After Aspect : " + joinPoint.getSignature().getName());
	}
	
	@AfterReturning(pointcut="execution(* com.jvalidation.services.AbstractTestService.testServiceReturn(..))",returning= "result")
	public void testReturning(JoinPoint joinPoint,Object result){
		System.out.println("After returning Aspect : " + joinPoint.getSignature().getName());
		System.out.println("Result : "+result);
	}
	
	@AfterThrowing(pointcut = "publicPointCut()",throwing="obj")
	public void testThrowing(JoinPoint joinPoint,Throwable obj){
		System.out.println("After throwing Aspect : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + obj.getMessage());
	}
	
	@Around("publicPointCut()")
	public void testAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Around aspect start");
		long start = System.currentTimeMillis();
		joinPoint.proceed();
		long end = System.currentTimeMillis();
		System.out.println("Execution time : " + (end-start));
		System.out.println("Around aspect end");
	}
}
