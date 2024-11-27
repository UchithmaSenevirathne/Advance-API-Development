package org.example.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class Logs {
    @After("execution(public void startTransaction())")
    public void  logsForStartTransaction(){
        System.out.println("transaction started");
    }
    @Before("execution(public void endTransaction())")
    public void logsForEndTransaction(){
        System.out.println("transaction end");
    }
}
