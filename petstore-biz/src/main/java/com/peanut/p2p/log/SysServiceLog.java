package com.peanut.p2p.log;

import java.lang.annotation.*;

/**
 * Created by my on 2015/5/22.
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysServiceLog {
    String description() default "";
}
