package org.example.config;

import org.example.aop.Logs;
import org.example.aop.Transaction;
import org.example.beans.Customer;
import org.example.beans.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {Transaction.class, Logs.class})
public class config {
//    @Bean
//    public Order order(){
//        return new Order();
//    }
}
