package com.lk.java.guava.ratelimit.api;

import java.lang.annotation.*;
/**
 * 在接口中添加该注解，实现接口的限流
 * @author liukun
 *
 */
@Inherited
@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimitAspect {

}
