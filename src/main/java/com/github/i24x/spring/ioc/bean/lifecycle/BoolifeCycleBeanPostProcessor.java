package com.github.i24x.spring.ioc.bean.lifecycle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;
@Service
public class BoolifeCycleBeanPostProcessor implements BeanPostProcessor {
	protected final Log logger = LogFactory.getLog(getClass());
    public BoolifeCycleBeanPostProcessor(){
        logger.info("BeanPostProcessor()初始化....");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("2======初始化前处理  BeanPostProcessor.postProcessBeforeInitialization方法，这里可对"+beanName+"的属性进行更改" +
        		""+bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("2======初始化后处理  BeanPostProcessor.postProcessAfterInitialization方法，这里可对"+beanName+"的属性进行更改" +
        		""+bean);
        return bean;
    }
}