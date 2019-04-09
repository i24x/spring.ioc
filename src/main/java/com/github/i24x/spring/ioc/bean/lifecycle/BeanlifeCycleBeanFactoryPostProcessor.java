package com.github.i24x.spring.ioc.bean.lifecycle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Service;
@Service
public class BoolifeCycleBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	protected final Log logger = LogFactory.getLog(getClass());
    public BoolifeCycleBeanFactoryPostProcessor() {
        logger.info("BeanFactoryPostProcessor()初始化....");
    }

    /**
     * BeanFactoryPostProcessor
     * 可通过该方法对beanFactory进行设置属性
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        logger.info("1======设置属性  BeanFactoryPostProcessor.postProcessBeanFactory");
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("BoolifeCycle");
        beanDefinition.getPropertyValues().addPropertyValue("age", "200000");
    }
}