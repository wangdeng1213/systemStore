package com.peanut.p2p.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by ln on 2015/6/16.
 */
public class Property {
    private String name;

    private String value;

    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlAttribute(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
