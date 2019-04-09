package com.github.i24x.spring.ioc.bean.lifecycle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Service;
@Service
public class BeanlifeCycleBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	protected final Log logger = LogFactory.getLog(getClass());
    public BeanlifeCycleBeanFactoryPostProcessor() {
        logger.info("初始化....");
    }

    /**
     * BeanFactoryPostProcessor
     * 可通过该方法对beanFactory进行设置属性
     */
    @Override

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //configurableListableBeanFactory.getBeanDefinition("appcontext-service.xml");
        System.out.println("1.BeanFactoryPostProcessor.postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)工厂后处理器, ApplicationContext容器初始化中refresh()中调用");
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("BeanlifeCycle");
        beanDefinition.getPropertyValues().addPropertyValue("message", "message");
    }

}