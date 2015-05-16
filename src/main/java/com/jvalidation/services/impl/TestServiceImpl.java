package com.jvalidation.services.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.jvalidation.services.AbstractTestService;

@Service("testService")
public class TestServiceImpl implements AbstractTestService{

	public void testService() throws Exception {
		System.out.println("This is a test service");
		Thread.sleep(100);
	}

	public static void main(String[] args) throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AbstractTestService obj = (AbstractTestService)context.getBean("testService");
		obj.testService();
	}
}
