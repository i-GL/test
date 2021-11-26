package com.aop.before;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description 测试类
 * @Author Coder_Qi
 **/
public class App {
    @Test
    public void test001() {
        String config = "before.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SomeService proxy = (SomeService) ac.getBean("someService");
        //System.out.println(proxy.getClass().getName());
        proxy.doInsert("zhangsan", 29);
        System.out.println("=======================");
        proxy.doUpdate("lisi", 23);
        System.out.println("=======================");
    }

    @Test
    public void test002() {
        String config = "before.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SomeService proxy = (SomeService) ac.getBean("someService");
        Student student = proxy.doDelete("zhangsan", 234);
        System.out.println("test002获取到的结果 = " + student);
    }

    @Test
    public void test003() {
        String config = "before.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SomeService proxy = (SomeService) ac.getBean("someService");
        Student student = proxy.doDelete("zhangsan", 234);
        System.out.println("结果 = " + student);

    }

    @Test
    public void test004() {
        String config = "before.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student proxy = (Student) ac.getBean("student");
        // 没有接口的类默认使用的是 cglib 动态代理
        // 有接口的默认使用 jdk 动态代理
        System.out.println("proxy type -> " + proxy.getClass().getSimpleName());
        System.out.println(proxy.toString());
    }
}
