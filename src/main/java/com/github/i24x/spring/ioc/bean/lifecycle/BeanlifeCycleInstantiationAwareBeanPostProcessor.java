package com.github.i24x.spring.ioc.bean.lifecycle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Service;

import java.beans.PropertyDescriptor;
import java.util.Arrays;

/**
 * 一般情况下，当我们需要实现InstantiationAwareBeanPostProcessor接口时，
 * 是通过继承Spring框架中InstantiationAwareBeanPostProcessor接口实现类
 * InstantiationAwareBeanPostProcessorAdapter这个适配器类来简化我们实现接口的工作
 */
@Service
public class BeanlifeCycleInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
	protected final Log logger = LogFactory.getLog(getClass());

    public Object postProcessBeforeInstantiation(Class<?> aClass, String s) throws BeansException {
        System.out.println("2.InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation实例化bean之前调用,即调用bean类构造函数之前调用 " + aClass.getName());
        /*try {
            return Class.forName(""+aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        return null;//其实我不是很明白这里返回值得作用,之后可能会去深入理解
    }

    public boolean postProcessAfterInstantiation(Object o, String s) throws BeansException {
        System.out.println("4.InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation(Object o, String s)返回boolean,bean实例化后调用,并且返回false则不会注入属性");
        return true;
    }

    public PropertyValues postProcessPropertyValues(PropertyValues propertyValues, PropertyDescriptor[] propertyDescriptors, Object o, String s) throws BeansException {
        System.out.println("5.InstantiationAwareBeanPostProcessor.postProcessPropertyValues(PropertyValues propertyValues, PropertyDescriptor[] propertyDescriptors, Object o, String s) ,在属性注入之前调用...... beanName = " + s + " 属性名集合 : " + Arrays.toString(propertyValues.getPropertyValues()));
        //System.out.println("message = " + ((BeanlifeCycle)o).getMessage()); 这里可以看到message还是null
        return propertyValues;//这里要返回propertyValues,否则属性无法注入
    }

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("9.InstantiationAwareBeanPostProcessor.postProcessBeforeInitialization((Object o, String s)");
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("13.InstantiationAwareBeanPostProcessor.postProcessAfterInitialization(Object o, String s)");
        return o;
    }
}