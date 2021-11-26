package com.aop.before;

/**
 * @Description DEMO
 * @Author Coder_Qi
 **/
public interface SomeService {

    void doInsert(String name, Integer age);

    void doUpdate(String name, Integer age);

    Student doDelete(String name, Integer id);
}
