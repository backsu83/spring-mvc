package com.example.springmvc.dao.api.base;

import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@org.springframework.stereotype.Component
public @interface ApiClient {
    String value() default "";
}
