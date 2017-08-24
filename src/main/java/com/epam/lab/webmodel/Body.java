package com.epam.lab.webmodel;

import com.epam.lab.model.Copter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
public class Body implements Serializable {

    @XmlElement
    private String message;

    @XmlElementRef(type = Copter.class,name = "copter")
    private Object object;

    public Body() {

    }

    public Body(String message) {
        this.message = message;
    }

    public Body(String message, Object object) {
        this.message = message;
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
