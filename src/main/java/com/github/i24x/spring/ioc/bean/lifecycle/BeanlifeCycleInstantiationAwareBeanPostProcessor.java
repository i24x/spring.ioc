package com.github.i24x.spring.ioc.bean.lifecycle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;

/**
 * 一般情况下，当我们需要实现InstantiationAwareBeanPostProcessor接口时，
 * 是通过继承Spring框架中InstantiationAwareBeanPostProcessor接口实现类
 * InstantiationAwareBeanPostProcessorAdapter这个适配器类来简化我们实现接口的工作
 */
@Service
public class BoolifeCycleInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
	protected final Log logger = LogFactory.getLog(getClass());
    public BoolifeCycleInstantiationAwareBeanPostProcessor() {
        logger.info("InstantiationAwareBeanPostProcessor()初始化....");
    }

    /**
     * 实例化Bean之前调用
    */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        logger.info("3====初始化前处理  InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation:"+beanName);
        return null;
    }

    /**
     * 实例化Bean之后调用
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("3====初始化后处理 InstantiationAwareBeanPostProcessor.postProcessAfterInitialization方法:"+beanName);
        return bean;
    }

    /**
     * 设置某个属性时调用
     */
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, 
    		Object bean, String beanName)
            throws BeansException {
        logger.info("3====设置属性处理  InstantiationAwareBeanPostProcessor.postProcessPropertyValues方法:"+beanName);
        return pvs;
    }
}