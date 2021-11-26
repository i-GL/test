package com.aop.jdkproxy;

import com.aop.jdkproxy.service.SomeService;
import com.aop.jdkproxy.service.impl.SomeServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description DEMO
 * @Author Coder_Qi
 **/
public class MyProxyFactor {
    public static SomeService getSomeService() {
        // 确定目标类
        final SomeService someService = new SomeServiceImpl();

        // 确定 切面类 必须使用final修饰
        final MyAspect myAspect = new MyAspect();

        return (SomeService) Proxy.newProxyInstance(someService.getClass().getClassLoader(),
                someService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 执行前执行 切面类
                        myAspect.doLog();
                        Object obj = method.invoke(someService, args);
                        // 执行结束后再次执行 切面类
                        myAspect.doTrans();
                        return obj;
                    }
                });
    }
}
