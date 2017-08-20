package com.epam.lab.webmodel;

import com.epam.lab.model.Copter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;

@XmlAccessorType(XmlAccessType.FIELD)
public class Response {

    @XmlElement
    private String message;

    @XmlElementRef(type = Copter.class)
    private Object object;

    public Response() {

    }

    public Response(String message) {
        this.message = message;
    }

    public Response(String message, Object object) {
        this.message = message;
        this.object = object;
    }

    public static Response succes(String message) {
        return new Response(message);
    }

    public static Response succes(String message, Object object) {
        return new Response(message, object);
    }

    public static Response fail(String message) {
        return new Response(message);
    }

    public static Response fail(String message, Object object) {
        return new Response(message, object);
    }
}
