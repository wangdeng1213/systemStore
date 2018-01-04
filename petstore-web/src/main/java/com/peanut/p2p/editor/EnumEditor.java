/**
 * Copyright (c) com.peanut
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.peanut.p2p.editor;

import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyEditorSupport;

/**
 * @author 安文涛
 * @version 1.0
 */

@SuppressWarnings("unchecked")
public class EnumEditor extends PropertyEditorSupport {
    @SuppressWarnings("rawtypes")
    private Class<? extends Enum> clazz;

    @SuppressWarnings("rawtypes")
    public EnumEditor(Class<? extends Enum> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public String getAsText() {
        return getValue() == null ? "" : getValue().toString();
    }

    @Override
    public void setAsText(String value) throws IllegalArgumentException {
        if (StringUtils.isNotEmpty(value)) {
            setValue(Enum.valueOf(clazz, value));
        }
    }
}
