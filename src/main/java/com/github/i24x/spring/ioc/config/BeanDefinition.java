package com.github.i24x.spring.ioc.config;

import com.github.i24x.spring.ioc.bean.Aoo;

//@Configuration
public class BeanDefinition {
//	@Bean(name = "Aoo")
	public Aoo initAoo() {
		return new Aoo();
	}
}
