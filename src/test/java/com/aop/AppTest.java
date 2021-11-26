package com.aop;

import com.aop.jdkproxy.MyProxyFactor;
import com.aop.jdkproxy.service.SomeService;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test01() {
        // 从代理工厂中获取加工后的对象
        SomeService someService = MyProxyFactor.getSomeService();
        someService.doInsert();
        System.out.println("============================");
        someService.doUpdate();
        System.out.println("============================");
        someService.doDelete();
    }
}
