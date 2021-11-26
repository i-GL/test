package com.aop.jdkproxy.service.impl;

import com.aop.jdkproxy.service.SomeService;

/**
 * @Description 目标类
 * @Author Coder_Qi
 **/
public class SomeServiceImpl implements SomeService {
    @Override
    public void doInsert() {
        System.out.println("do insert");
    }

    @Override
    public void doUpdate() {
        System.out.println("do update");
    }

    @Override
    public void doDelete() {
        System.out.println("do delete");
    }
}
