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
	private String message;

	public BeanlifeCycle(){
		System.out.println("3.BeanlifeCycle 实例化.......");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void xml_init(){
		//xml开头的表示配置文件配置,这里是bean配置中init-method配置调用
		System.out.println("11.BeanlifeCycle 初始化(init-method)");
	}
	public void xml_destroy(){
		//destroy-method 配置调用
		System.out.println("16.BeanlifeCycle 销毁(destroy-method)");
	}

	public void setBeanName(String s) {
		//属性注入后调用
		System.out.println("6.BeanNameAware.setBeanName(String beanName) 属性注入后调用, 此时beanName = " + s);
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		//setBeanName 后调用
		System.out.println("7.BeanFactoryAware.setBeanFactory(BeanFactory beanFactory) setBeanName后调用");
	}

	public void afterPropertiesSet() throws Exception {
		//processBeforeInitialization(BeanPostProcessor)后调用
		System.out.println("10.InitializingBean.afterPropertiesSet(),processBeforeInitialization之后,配置的xml_init之前调用");
	}

	public void destroy() throws Exception {
		System.out.println("15.DisposableBean.destroy(),在processAfterInitialization之后,配置的xml_destroy之前调用");
	}
}