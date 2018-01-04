/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.validation.validator;

import com.peanut.p2p.validation.annotations.DateFormat;
import com.peanut.utilities.DateTool;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @author 安文涛
 * @version 1.0
 */

public class DateFormatValidator implements
        ConstraintValidator<DateFormat, Date> {
    private Pattern pattern;

    public void initialize(DateFormat dateFormat) {
        this.pattern = Pattern.compile(dateFormat.value());
    }

    public boolean isValid(Date date, ConstraintValidatorContext context) {
        if (date == null) {
            return false;
        }

        if (pattern.matcher(DateTool.getDate(date)).matches()) {
            return true;
        }

        return false;
    }

}
