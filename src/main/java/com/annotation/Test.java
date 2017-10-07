package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//@TestMethod向某个方法注入一个字符串。
//①创建Test注解，声明作用于类并保留到运行时，默认值为default。

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
    String value() default "default";
}