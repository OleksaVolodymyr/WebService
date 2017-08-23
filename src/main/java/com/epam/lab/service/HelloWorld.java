package com.epam.lab.service;

import com.epam.lab.model.Copter;
import com.epam.lab.response.ResponseCreator;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/CopterControlService")
public class HelloWorld {
    private CopterDAO copterDAO = new CopterDAO();
    @Context
    private HttpHeaders requestHeaders;

    private String getHeaderVersion() {
        return requestHeaders.getRequestHeader("version").get(0);
    }

    @GET
    @Produces("application/json")
    @Path("/moveUp")
    public Response moveUp() {
        if(copterDAO.moveUp()!=null) {
            return ResponseCreator.succses("test", copterDAO.getCopter());
        }
        return Response.status(404).entity("fail").build();
    }
    @GET
    @Produces("application/json")
    @Path("/moveDown")
    public Response moveDown() {
        if(copterDAO.moveDown()!=null) {
            return ResponseCreator.succses("test", copterDAO.getCopter());
        }
        return Response.status(404).entity("fail").build();
    }


}

