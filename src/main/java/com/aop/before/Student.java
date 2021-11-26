package com.aop.before;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description DEMO
 * @Author Coder_Qi
 **/
@Component
public class Student {
    @Value("23")
    private Integer id;
    @Value("xiaoming")
    private String name;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
    }

    public void setName(String name) {
        this.name = name;
    }
}
