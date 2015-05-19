package com.jvalidation.vos;

import com.jvalidation.annotations.NotEmpty;
import com.jvalidation.annotations.NotNull;
import com.jvalidation.annotations.Validate;

@Validate
public class TestInputVO {

	@NotNull
	public String id;
	private String name;
	
	
	public TestInputVO() {
		super();
	}

	public TestInputVO(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotEmpty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
