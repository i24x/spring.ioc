package com.github.i24x.spring.ioc.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * 默认为小写
 * @author i24x
 */
//@Service("Aoo")
public class Aoo {
	
	public String aoo;
	@Value("${spring.profiles.active}")
	private String address;

	public Aoo(String aoo, String address) {
		super();
		this.aoo = aoo;
		this.address = address;
	}
	
	public Aoo() {
		super();
	}

	public String getAoo() {
		return aoo;
	}
	public void sendMsg(String msg){
		System.out.println(msg);
	}
	public void setAoo(String aoo) {
		this.aoo = aoo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
