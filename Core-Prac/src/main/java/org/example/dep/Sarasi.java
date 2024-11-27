package org.example.dep;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("long hair")
public class Sarasi implements GoodGirl{
    @Override
    public void love() {
        System.out.println("sarasi");
    }
}
