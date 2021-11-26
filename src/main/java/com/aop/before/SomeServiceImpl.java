package com.aop.before;

import org.springframework.stereotype.Component;

/**
 * @Description 目标类
 * @Author Coder_Qi
 **/
@Component("someService")
public class SomeServiceImpl implements SomeService {
    @Override
    public void doInsert(String name, Integer age) {
        System.out.println("do insert method...");
    }

    @Override
    public void doUpdate(String name, Integer age) {
        System.out.println("do update method...");
    }

    @Override
    public Student doDelete(String name, Integer id) {
        System.out.println("do delete method...");
        return new Student(id, name);
    }
}
