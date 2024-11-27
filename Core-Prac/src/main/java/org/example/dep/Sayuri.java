package org.example.dep;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Sayuri implements GoodGirl{
    @Override
    public void love() {
        System.out.println("sayuri");
    }
}
