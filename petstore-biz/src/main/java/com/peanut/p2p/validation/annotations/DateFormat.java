/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.validation.annotations;

import com.peanut.p2p.validation.validator.DateFormatValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 安文涛
 * @version 1.0
 */

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateFormatValidator.class)
public @interface DateFormat {
    String message() default "date.illegal";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value() default "(19|20)\\d{2}-(0?\\d|1[012])-(0?\\d|[12]\\d|3[0,1])";
}
