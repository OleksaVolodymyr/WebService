package com.epam.lab.service;

import com.epam.lab.dao.CopterDAO;
import com.epam.lab.webmodel.Body;
import com.epam.lab.webmodel.Message;
import com.epam.lab.webmodel.ResponseCreator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/CopterControlService")
public class CopterControlService implements CopterRemoteController {
    private CopterDAO copterDAO = new CopterDAO();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/moveUp")
    public Response moveUp() {
        if (copterDAO.moveUp() != null) {
            return ResponseCreator.success(new Body(Message.MOVE_UP_MESSAGE, copterDAO.getCopter()));
        }
        return ResponseCreator.error(200, String.format(Message.MAX_HEIGHT_OUT_MESSAGE, copterDAO.getCopter().getHeight()));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/moveDown")
    public Response moveDown() {
        if (copterDAO.moveDown() != null) {
            return ResponseCreator.success(new Body(Message.MOVE_DOWN_MESSAGE, copterDAO.getCopter()));
        }
        return ResponseCreator.error(200, String.format(Message.MIN_HEIGHT_OUT_MESSAGE, copterDAO.getCopter().getHeight()));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/moveForward")
    public Response moveForward() {
        if (copterDAO.moveForward() != null) {
            return ResponseCreator.success(new Body(Message.MOVE_FORWARD_MESSAGE, copterDAO.getCopter()));
        }
        return ResponseCreator.error(200, String.format(Message.MAX_DISTANCE_OUT_MESSAGE, copterDAO.getCopter().getDistance()));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/moveBack")
    public Response moveBack() {
        if (copterDAO.moveBack() != null) {
            return ResponseCreator.success(new Body(Message.MOVE_BACK_MESSAGE, copterDAO.getCopter()));
        }
        return ResponseCreator.error(200, String.format(Message.MAX_DISTANCE_OUT_MESSAGE, copterDAO.getCopter().getDistance()));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stop")
    public Response stop() {
        return ResponseCreator.success(new Body(Message.HOVERING_MESSAGE, copterDAO.getCopter()));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getCurrentPosition")
    public Response getCurrentPosition() {
        if (copterDAO.getCopter() != null) {
            return ResponseCreator.success(new Body(Message.COPTER_POSITION_MESSAGE, copterDAO.getCopter()));
        }
        return ResponseCreator.error(200, Message.COPTER_NOTEXSIST_MESSAGE);
    }


}

