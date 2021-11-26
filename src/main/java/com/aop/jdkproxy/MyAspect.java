package com.aop.jdkproxy;

import java.util.Date;

/**
 * @Description DEMO
 * @Author Coder_Qi
 **/
public class MyAspect {
    public void doLog() {
        System.out.println("执行前now time:" + new Date());
    }

    public void doTrans() {
        System.out.println("执行后 事务 commit");
    }
}
