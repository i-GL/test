package com.aop.jdkproxy;

import com.aop.jdkproxy.service.SomeService;
import org.junit.Test;

/**
 * @Description DEMO
 * @Author Coder_Qi
 **/
public class MyTest {

    // 使用 JDK 动态代理创建代理对象
    @Test
    public void test001() {
/*
        // 方式1
        // 确定目标类
        SomeService target = new SomeServiceImpl();

        // 创建 myInvocationHandler 对象
        InvocationHandler handler = new MyInvocationHandler(target);

        // 使用 Proxy 创建代理
        SomeService someService =
                (SomeService) Proxy.newProxyInstance
                        (target.getClass().getClassLoader(),
                                target.getClass().getInterfaces(), handler);
        // 执行目标方法
        someService.doInsert();*/

        // 方式二
        SomeService someService = (SomeService) new MyProxyFactor();
        someService.doInsert();
        System.out.println("==================");
        System.out.println("begin");
        someService.doUpdate();
    }
}
