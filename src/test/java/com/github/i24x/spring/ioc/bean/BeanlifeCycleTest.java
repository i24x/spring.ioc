package com.github.i24x.spring.ioc.bean;

import com.github.i24x.spring.ioc.bean.lifecycle.BeanlifeCycle;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BeanlifeCycleTest {

	public static void main(String[] args) throws Exception {
//		ApplicationContext context = new AnnotationConfigApplicationContext(BeanDefinition.class);
//		String[] basePackages = {"com.github.i24x.spring.ioc"};
//		ApplicationContext context = 
//				new AnnotationConfigApplicationContext(basePackages);
//		Aoo aoo = (Aoo) context.getBean("aoo");
		
		/*ApplicationContext*/
		AbstractApplicationContext   xmlcontext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		xmlcontext.registerShutdownHook();
		Aoo aoo = (Aoo) xmlcontext.getBean("Aoo");
		System.out.println(aoo.getAddress());
		xmlcontext.close();


//		//定义BeanDefinition的信息来源，在XmlBeanFactory中作为构造函数的参数传给XmlBeanFactory
//		ClassPathResource resource = new ClassPathResource("applicationContext.xml"); 
//		//创建一个BeanFactory的IoC容器 
//		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//		//创建一个加载BeanDefinition的读取器，通过一个回调配置给BeanFactory 
//		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//		//从信息来源中加载BeanDefinition 
//		reader.loadBeanDefinitions(resource); 
//		Aoo aoo = (Aoo)factory.getBean("Aoo"); 
//		aoo.sendMsg("OK");
//		StudentBean bean = factory.getBean("StudentBean", StudentBean.class);
//		bean.getAge();


//		BeanlifeCycle BoolifeCycle = (BeanlifeCycle)xmlcontext.getBean("BeanlifeCycle");
//		System.out.println(BoolifeCycle.getAge());
//		for(int i=0;i<10;i++){
////			Boo b = new Boo();
////			b = null;
////			Boo c = Boo.getInstance();
////			c = null;
//		}
		//xmlcontext.close();
//		System.in.read();
	}

}
