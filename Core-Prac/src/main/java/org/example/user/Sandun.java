package org.example.user;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.dep.GoodGirl;
import org.example.dep.Wow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Sandun {

//    @Autowired
    @Qualifier("long hair")
//    @Wow
    private final GoodGirl goodGirl;
    @Autowired
    @Wow
    public Sandun(GoodGirl goodGirl){
        this.goodGirl = goodGirl;
    }
    @PostConstruct
    public void init(){
        goodGirl.love();
    }
}
