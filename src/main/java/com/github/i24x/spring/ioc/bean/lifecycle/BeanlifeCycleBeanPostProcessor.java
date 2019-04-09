package com.github.i24x.spring.ioc.bean.lifecycle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;
@Service
public class BeanlifeCycleBeanPostProcessor implements BeanPostProcessor {
	protected final Log logger = LogFactory.getLog(getClass());

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("8.BeanPostProcessor.postProcessBeforeInitialization(Object o, String s), bean = " + o.getClass());
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("12.BeanPostProcessor.postProcessAfterInitialization(Object o, String s), bean = " + o.getClass());
        return o;
    }
}