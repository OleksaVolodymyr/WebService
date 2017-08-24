package com.epam.lab.webmodel;


import javax.ws.rs.core.Response;

public class ResponseCreator {
    public static Response success(Object object) {
        Response.ResponseBuilder response = Response.ok();
        if (object != null) {
            response.entity(object);
        } else {
            response.entity("none");
        }
        return response.build();
    }

    public static Response error(int status, String message) {
        Response.ResponseBuilder response = Response.status(status);
        response.entity(message);
        return response.build();
    }
}
