package com.epam.lab.restService.service;


import javax.ws.rs.core.Response;

public interface CopterRemoteController {

    public Response moveUp();

    public Response moveDown();

    public Response moveForward();

    public Response moveBack();

    public Response stop();

    public Response getCurrentPosition();
}
