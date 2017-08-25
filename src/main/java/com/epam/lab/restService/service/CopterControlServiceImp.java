package com.epam.lab.restService.service;

import com.epam.lab.dao.CopterDAO;
import com.epam.lab.restService.webmodel.Body;
import com.epam.lab.restService.webmodel.Message;
import com.epam.lab.restService.webmodel.ResponseCreator;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/CopterControlServiceImp")
public class CopterControlServiceImp implements CopterRemoteController {
    private static final Logger LOG = Logger.getLogger(CopterControlServiceImp.class);
    private CopterDAO copterDAO;

    public CopterControlServiceImp() {
        LOG.info("Create new copter");
        copterDAO = new CopterDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/moveUp")
    public Response moveUp() {
        if (copterDAO.moveUp() != null) {
            LOG.info(Message.MOVE_UP_MESSAGE + copterDAO.getCopter());
            return ResponseCreator.success(new Body(Message.MOVE_UP_MESSAGE, copterDAO.getCopter()));
        }
        LOG.error(String.format(Message.MAX_HEIGHT_OUT_MESSAGE, copterDAO.getCopter().getHeight()));
        return ResponseCreator
                .error(200, new Body(String.format(Message.MAX_HEIGHT_OUT_MESSAGE, copterDAO.getCopter().getHeight())));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/moveDown")
    public Response moveDown() {
        if (copterDAO.moveDown() != null) {
            LOG.info(Message.MOVE_DOWN_MESSAGE + copterDAO.getCopter());
            return ResponseCreator.success(new Body(Message.MOVE_DOWN_MESSAGE, copterDAO.getCopter()));
        }
        LOG.error(String.format(Message.MAX_HEIGHT_OUT_MESSAGE, copterDAO.getCopter().getHeight()));
        return ResponseCreator
                .error(200, new Body(String.format(Message.MIN_HEIGHT_OUT_MESSAGE, copterDAO.getCopter().getHeight())));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/moveForward")
    public Response moveForward() {
        if (copterDAO.moveForward() != null) {
            LOG.info(Message.MOVE_FORWARD_MESSAGE + copterDAO.getCopter());
            return ResponseCreator.success(new Body(Message.MOVE_FORWARD_MESSAGE, copterDAO.getCopter()));
        }
        LOG.error(String.format(Message.MAX_DISTANCE_OUT_MESSAGE, copterDAO.getCopter().getDistance()));
        return ResponseCreator.error(200, new Body(String
                .format(Message.MAX_DISTANCE_OUT_MESSAGE, copterDAO.getCopter().getDistance())));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/moveBack")
    public Response moveBack() {
        if (copterDAO.moveBack() != null) {
            LOG.info(Message.MOVE_BACK_MESSAGE + copterDAO.getCopter());
            return ResponseCreator.success(new Body(Message.MOVE_BACK_MESSAGE, copterDAO.getCopter()));
        }
        LOG.error(String.format(Message.MAX_DISTANCE_OUT_MESSAGE, copterDAO.getCopter().getDistance()));
        return ResponseCreator.error(200, new Body(String
                .format(Message.MAX_DISTANCE_OUT_MESSAGE, copterDAO.getCopter().getDistance())));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stop")
    public Response stop() {
        LOG.info(Message.HOVERING_MESSAGE + copterDAO.getCopter());
        return ResponseCreator.success(new Body(Message.HOVERING_MESSAGE, copterDAO.getCopter()));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getCurrentPosition")
    public Response getCurrentPosition() {
        if (copterDAO.getCopter() != null) {
            LOG.info(Message.COPTER_POSITION_MESSAGE + copterDAO.getCopter());
            return ResponseCreator.success(new Body(Message.COPTER_POSITION_MESSAGE, copterDAO.getCopter()));
        }
        LOG.error(Message.COPTER_NOTEXSIST_MESSAGE);
        return ResponseCreator.error(200, new Body(Message.COPTER_NOTEXSIST_MESSAGE));
    }


}

