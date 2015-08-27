package com.wolflowhereu.spring3.annotation;

import java.lang.annotation.*;

/**
 * Created by jxdyf09 on 15-6-13.
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SecurityValid {
    boolean throwException() default true;
    SafeLevel safeLevel() default SafeLevel.PUBLIC;
}
