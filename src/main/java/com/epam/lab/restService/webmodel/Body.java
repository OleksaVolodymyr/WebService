package com.epam.lab.restService.webmodel;

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
    private Object copter;

    public Body() {

    }

    public Body(String message) {
        this.message = message;
    }

    public Body(String message, Object object) {
        this.message = message;
        this.copter = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getCopter() {
        return copter;
    }

    public void setCopter(Object copter) {
        this.copter = copter;
    }
}
