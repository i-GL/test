package com.aop.before;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description 切面类 一个普通的类，定义了需要额外添加的功能的代码
 * 要求：
 *      方法要public
 *      方法没有返回值
 *      方法的参数不是自定义的
 * 使用：直接在切面类上面添加
 *
 * @Author Coder_Qi
 **/
@Aspect
@Component("myAspect")
public class MyAspect {

    /**
     * @Before: 前置通知注解，在目标方法之前执行且不影响目标方法
     *      属性：value 切入点表达式
     *      位置：直接在切面方法上添加
     */
    @Before("execution(* *..SomeServiceImpl.do(..))")
    public void myBefore(JoinPoint jp) {
        System.out.println("开始运行时间通知：" + new Date());
        System.out.println("方法：" + jp.getSignature());
        System.out.println("方法名：" + jp.getSignature().getName());
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            System.out.println(arg.getClass().getSimpleName() + ":" + arg);
        }
    }

    /**
     * @Description 后置通知，如果结果是引用类型，可以修改最后返回的值
     * returning 的值 需要和切面方法中的形参一致
     *
     * @Params [res]
     * @Return void
     */
    @AfterReturning(value = "execution(* *..SomeServiceImpl.do(..))",
            returning = "res")
    public void myAfterReturning(JoinPoint jp, Object res) {
        System.out.println("方法的签名：" + jp.getSignature());
        System.out.println("后置时间通知：" + new Date());
        System.out.println("初次获取到目标方法的结果 = " + res);
        Student student = (Student) res;
        if (null != student) {
            student.setName("lisi");
            student.setId(345);
        }
        System.out.println("myAspect update result = " + student);
        System.out.println("=============");
    }

    @Around(value = "myPointcut()")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        System.out.println("环绕通知开始：" + new Date());
        Object[] args = pjp.getArgs();
        String name = "";
        // 设立目标方法执行的条件
        if (args != null) {
            name = (String) args[0];
        }
        if ("zhangsan".equals(name)) {
            result = pjp.proceed();
        }

        System.out.println("环绕通知结束：事务提交。。。");

        return result;
    }

    @Pointcut(value = "execution(* *..SomeServiceImpl.do*(..))")
    public void myPointcut() {}


    /**
     * @Description 最后通知，不管有没有异常都执行
     * @Params []
     * @Return void
     */
    @After("execution(* *..SomeServiceImpl.ex(..))")
    public void myAfter() {
        System.out.println("最后时间通知：" + new Date());
    }

    @Before(value = "execution(* *..Student.*(..))")
    public void getStudent() {
        System.out.println("前置通知时间：" + new Date());
    }
}
