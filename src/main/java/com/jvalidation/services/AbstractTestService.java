package com.jvalidation.services;

import com.jvalidation.vos.TestInputVO;

public interface AbstractTestService {

	public void testService(String test) throws Exception;
	public Integer testServiceReturn() throws Exception;
	public void testAnnotation(TestInputVO testInputVO) throws Exception;
	public void name() throws Exception;
}
