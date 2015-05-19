package com.jvalidation.util;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import com.jvalidation.constants.JavaType;



public class JavaTypesUtil {
	
	public Boolean isCommonType(Class<?> clazz){
		if(clazz.isPrimitive()){
			return true;
		}
		return  clazz.equals(Boolean.class) || 
				clazz.equals(Integer.class) ||
				clazz.equals(Character.class) ||
				clazz.equals(Byte.class) ||
				clazz.equals(Short.class) ||
				clazz.equals(Double.class) ||
				clazz.equals(Long.class) ||
				clazz.equals(Float.class);
	}

	public String getCollectionType(Class<?> clazz){
		if(clazz.isArray() || List.class.isInstance(clazz) || Set.class.isInstance(clazz)){
			return JavaType.LIST;
		}else if(Map.class.isInstance(clazz)){
			return JavaType.KEY_VALUE;
		}else if(Stack.class.isInstance(clazz)){
			return JavaType.STACK;
		}else if(Queue.class.isInstance(clazz)){
			return JavaType.QUEUE;
		}
		return null;
	}
	
}
