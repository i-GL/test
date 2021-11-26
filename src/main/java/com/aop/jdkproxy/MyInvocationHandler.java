package com.aop.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description DEMO
 * @Author Coder_Qi
 **/
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在执行目标类前执行切面类
        // MyAspect.doLog();

        // 传入目标类 proxy
        Object res = method.invoke(target, args);

        // 执行结束后再次执行 切面类
        // MyAspect.doTrans();

        return res;
    }
}
