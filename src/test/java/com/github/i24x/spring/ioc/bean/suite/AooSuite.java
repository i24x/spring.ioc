package com.github.i24x.spring.ioc.bean.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.github.i24x.spring.ioc.bean.AooTest;
import com.github.i24x.spring.ioc.bean.Aoo2Test;
/**
 * Junit Test Suite
 * @author i24x
 *聚合测试
 */
@RunWith(Suite.class)
@SuiteClasses({ AooTest.class, Aoo2Test.class })
public class AooSuite {

}
