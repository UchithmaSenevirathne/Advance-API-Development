package org.example;

import org.example.aop.Transaction;
import org.example.beans.TestBean;
import org.example.config.config;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInit {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext();
        ctx.register(config.class);
        ctx.refresh();
        Transaction transaction = (Transaction) ctx.getBean("TransactionBean");
        transaction.startTransaction();
        transaction.endTransaction();
//        ConfigurableBeanFactory beanFactory = ctx.getBeanFactory();
//        boolean isSingletonTestBean = beanFactory.isSingleton("TestBean");
//        System.out.println(testBean);
//        System.out.println("is TestBean singleton ? " + isSingletonTestBean);
//        ctx.close();

//        close eka wenuwata
        ctx.registerShutdownHook();
    }
}
