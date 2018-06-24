package com.github.i24x.spring.ioc.bean;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.i24x.spring.ioc.SpringGenericTestCase;

public class AooTest extends SpringGenericTestCase {
	@Autowired
	private Aoo aoo;
	@Test
	public void Aoo_sendMsg() {
		aoo.sendMsg("OK");
	}
}
