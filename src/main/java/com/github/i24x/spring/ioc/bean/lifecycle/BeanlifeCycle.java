package com.github.i24x.spring.ioc.bean.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * 测试生命周期的BoolifeCycle
 * @author i24x
 */
@Service("BeanlifeCycle")
public class BeanlifeCycle implements InitializingBean, DisposableBean,
		BeanNameAware, BeanFactoryAware {
	protected final Log logger = LogFactory.getLog(getClass());
	private String name;
	private int age;
	private String beanName;
	// 实现了BeanNameAware接口，Spring可以将BeanName注入该属性中
	public BeanFactory beanFactory;

	// 实现了BeanFactory接口，Spring可将BeanFactory注入该属性中

	public BeanlifeCycle() {
		logger.info("BeanlifeCycle implements InitializingBean, DisposableBean,BeanNameAware, BeanFactoryAware执行构造器....");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		logger.info(this.getClass().getSimpleName()+"."+"setName="+name);
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		logger.info(this.getClass().getSimpleName()+"."+"setAge="+age);
		this.age = age;
	}

	public BeanFactory getBeanFactory(){
		return this.beanFactory;
	}
	
	public String getBeanName() {
		return this.beanName;
	}
	
	/**
	 * 自己编写的初始化方法
	 */
	@PostConstruct
	public void PostInit() {
		logger.info("PostConstruct 初始化后处理");
	}

	/**
	 * 自己编写的销毁方法
	 */
	@PreDestroy
	public void preDestroy() {
		logger.info("PreDestroy 销毁实例前处理");
	}
	
	/**
	 * BeanNameAware接口的方法
	 * @param name
	 */
	@Override
	public void setBeanName(String name) {
		logger.info("BeanlifeCycle.BeanNameAware"+"."+"setBeanName="+name);
		this.beanName = name;
	}
	
	/**
	 * BeanFactoryAware接口的方法
	 * 
	 * @param beanFactory
	 * @throws BeansException
	 */
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		logger.info("BeanlifeCycle.BeanFactoryAware.setBeanFactory");
		this.beanFactory = beanFactory;
	}
	
	/**
	 * InitializingBean接口的方法
	 * @throws Exception
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("BoolifeCycle.InitializingBean.afterPropertiesSet()");
	}

	/**
	 * DisposableBean接口的方法
	 * @throws Exception
	 */
	@Override
	public void destroy() throws Exception {
		logger.info("BoolifeCycle.DisposableBean.destroy() Bean被销毁");
	}
	
	@Override
	public String toString() {
		return "BoolifeCycle [+name=" + name + ", age="
				+ age + ", beanName=" + beanName + "]";
	}
}