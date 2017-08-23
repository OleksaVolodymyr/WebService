package com.epam.lab.service;

import com.epam.lab.model.Copter;
import com.epam.lab.webmodel.Response;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CopterRemoteController {
    @WebMethod
    public Response moveUp();
    @WebMethod
    public Response moveDown();
    @WebMethod
    public Response moveForward();
    @WebMethod
    public Response moveBack();
    @WebMethod
    public Response stop();
    @WebMethod
    public Response getCurrentPosition();
}
