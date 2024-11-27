package org.example.dep;

import org.springframework.stereotype.Component;

@Component
public class Ruwini implements GoodGirl {
    @Override
    public void love(){
        System.out.println("ruwani");
    }
}
