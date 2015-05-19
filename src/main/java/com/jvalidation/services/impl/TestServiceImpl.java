package com.jvalidation.services.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.jvalidation.services.AbstractTestService;
import com.jvalidation.vos.TestInputVO;

@Service("testService")
public class TestServiceImpl implements AbstractTestService{

	public void testService(String test) throws Exception {
		System.out.println("This is a test service");
		Thread.sleep(100);
	}

	public void testAnnotation(TestInputVO testInputVO) throws Exception{
		//System.out.println("This is a input vo test");
	}
	
	public Integer testServiceReturn() throws Exception{
		return 100;
	}
	
	public void name() throws Exception{
		throw new Exception("Fuck you");
	}
	
	public static void main(String[] args) throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AbstractTestService obj = (AbstractTestService)context.getBean("testService");
		TestInputVO test = new TestInputVO("asud");
		obj.testAnnotation(test);
		//obj.testService("test");
		//obj.testServiceReturn();
		//obj.name();
	}
}
