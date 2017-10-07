package com.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

//②创建TestMethod注解，声明作用于方法并保留到运行时。
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestMethod {
    String value();
}