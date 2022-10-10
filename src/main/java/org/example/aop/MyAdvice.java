package org.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * aop通知的5中方式
 * 1.Before 方法执行前
 * 2.After  方法执行完后
 * 3.Around 环绕，注意返回值和ProceedingJoinPoint执行，不然原始方法不会被执行
 * 4.AfterReturning 方法正常返回后
 * 5.AfterThrowing 方法抛出异常后
 */
@Component
@Aspect
public class MyAdvice {
//    @Pointcut("execution(void org.example.dao.BookDao.save())")
//    @Pointcut("execution(* org.example.*.*Dao.find*(..))") // dao层的查询方法
//    @Pointcut("execution(* *..*(..))") // 任意方法
    @Pointcut("execution(* org.example.*.*Dao.*(..))") // dao层的任意方法
    private void pt() {}

    @Pointcut("execution(* org.example.*.*Dao.*(..))")
    private void aroundPt() {}

//    @Before("pt()")
    public void method(JoinPoint joinPoint) {
        System.out.println("before time:" + System.currentTimeMillis());
    }

//    @After("pt()")
    public void afterMethod() {
        System.out.println("method after...");
    }

    @Around("aroundPt()")
    public Object methodAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("methodAround before---");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("methodAround after---");
        return result;
    }
}
