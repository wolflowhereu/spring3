package com.wolflowhereu.spring3.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by jxdyf09 on 15-8-25.
 */
@Service
public class PropertiesService {
    @Value("${i.say}")
    private String say;
    @Value("${i.say.english}")
    private String sayEnglish;

    public void sayHello(){
        System.out.println("i.say="+say);
        System.out.println("i.say.english="+sayEnglish);
    }
}

