package com.epam.lab.response;

import javax.ws.rs.core.Response;

public class ResponseCreator {
    public static Response succses(String version, Object object) {
        Response.ResponseBuilder response = Response.ok();
        response.header("version", version);
        if (object != null) {
            response.entity(object);
        }else {
            response.entity("none");
        }
        return response.build();
    }
}
