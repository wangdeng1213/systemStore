/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.editor;

import com.peanut.utilities.DateTool;
import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * @author 安文涛
 * @version 1.0
 */

public class DateEditor extends PropertyEditorSupport {
    private static final String DEFAULT_DATE_MATTER = "yyyy-MM-dd HH:mm:ss";

    private String dateMatter;

    public DateEditor() {
        super();
    }

    public DateEditor(String dateMatter) {
        super();
        this.dateMatter = dateMatter;
    }

    @Override
    public String getAsText() {
        return getValue() == null ? "" : DateTool.getDate((Date) getValue(),
                getDateMatter());
    }

    @Override
    public void setAsText(String dateStr) throws IllegalArgumentException {
        if (!StringUtils.isEmpty(dateStr)) {
            setValue(DateTool.getDate(dateStr, getDateMatter()));
        }
    }

    public String getDateMatter() {
        return StringUtils.isBlank(dateMatter) ? DEFAULT_DATE_MATTER
                : dateMatter;
    }

    public void setDateMatter(String dateMatter) {
        this.dateMatter = dateMatter;
    }
}