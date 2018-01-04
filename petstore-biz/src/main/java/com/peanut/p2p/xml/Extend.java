package com.peanut.p2p.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by ln on 2015/6/16.
 */
public class Extend {
    private Property property;

    @XmlElement(name = "property")
    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
