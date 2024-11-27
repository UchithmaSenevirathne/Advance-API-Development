package org.example.dep;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("long hair")
@Wow
public class Shehara implements GoodGirl{
    @Override
    public void love() {
        System.out.println("shehara");
    }
}
