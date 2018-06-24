package com.github.i24x.spring.ioc.bean;


public class ClassLoaderTest {
	public static void main(String[] args) throws Exception {
		ClassLoader l1 = new AppClassLoader();
		Class<?> c1 = l1.loadClass("com.github.i24x.spring.ioc.bean.Boo");
		System.out.println(c1.hashCode());
		Object newInstance = c1.newInstance();
		newInstance = null;
		c1 = null;
		l1 = null;
		System.gc();
//		TimeUnit.SECONDS.sleep(4);
		ClassLoader l2 = new AppClassLoader();
		Class<?> c2 = l2.loadClass("com.github.i24x.spring.ioc.bean.Boo");
		System.out.println(c2.hashCode());
	}
}
