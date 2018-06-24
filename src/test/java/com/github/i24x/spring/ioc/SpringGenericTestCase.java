package com.github.i24x.spring.ioc;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
比代码中写main 方法测试的好处：
1.可以书写一系列的 测试方法，对项目所有的 接口或者方法进行单元测试。 
2.启动后，自动化测试，并判断执行结果, 不需要人为的干预。 
3.只需要查看最后结果，就知道整个项目的方法接口是否通畅。。
4.每个单元测试用例相对独立， 由Junit启动，自动调用，不需要添加额外的调用语句。
5.添加，删除，屏蔽测试方法，不影响其他的测试方法。 开源框架都对JUnit有相应的支持。

而main 方法不一样。 
对多个方法调用。 需要添加打印或者输出语句。 
添加了新的测试方法。 需要在main方法添加方法调用。 
不能形成整体的测试结果。
需要对打印或者输出结果进行人为的判断。

FAQ:
1.先手动编译项目，然后启动测试
2.Junit测试常用注解
	@RunWith
	@ContextConfiguration
	@Before
	@BeforeClass
	@After
	@AfterClass
	@Test
	@Ignore
3.myeclispe使用junit插件创建测试用例
	Junit Test Case
	Junit Test Suite
	Maven test
	
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml" })
public abstract class SpringGenericTestCase {
}
