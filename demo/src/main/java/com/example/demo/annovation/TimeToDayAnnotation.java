package com.example.demo.annovation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeToDayAnnotation {
    String value() default "";
}
