package com.wolflowhereu.spring3.service;

import com.wolflowhereu.spring3.annotation.SecurityValid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by jxdyf09 on 15-8-27.
 */
@Service
public class AnnotationService {

    private static final Logger logger = LoggerFactory.getLogger(AnnotationService.class);


    public void sayHello() {
        logger.info("this is sayHello method!");
    }

    @SecurityValid
    public void inAnnotation(){
        logger.info("I am safe method!");
    }
}
