package com.epam.lab.service;

import com.epam.lab.dao.CopterDAO;
import com.epam.lab.webmodel.Message;
import com.epam.lab.webmodel.Response;
import org.apache.log4j.Logger;

import javax.jws.WebService;

@WebService(endpointInterface = "com.epam.lab.service.CopterRemoteController")
public class CopterRemoteControllerImp implements CopterRemoteController {
    private static final Logger LOG = Logger.getLogger(CopterRemoteControllerImp.class);
    private CopterDAO copterDAO;

    public CopterRemoteControllerImp() {
        copterDAO = new CopterDAO();
    }

    @Override
    public Response moveUp() {
        if (copterDAO.moveUp() != null) {
            return Response.succes(Message.COPTER_POSITION_MESSAGE, copterDAO.getCopter());
        }
        return Response.fail(String.format(Message.MAX_HEIGHT_OUT_MESSAGE, copterDAO.getCopter().getHeight()));
    }

    @Override
    public Response moveDown() {
        if (copterDAO.moveDown() != null) {
            return Response.succes(Message.COPTER_POSITION_MESSAGE, copterDAO.getCopter());
        }
        return Response.fail(String.format(Message.MIN_HEIGHT_OUT_MESSAGE, copterDAO.getCopter().getHeight()));
    }

    @Override
    public Response moveForward() {
        if (copterDAO.moveForward() != null) {
            return Response.succes(Message.COPTER_POSITION_MESSAGE, copterDAO.getCopter());
        }
        return Response.fail(String.format(Message.MAX_DISTANCE_OUT_MESSAGE, copterDAO.getCopter().getDistance()));
    }

    @Override
    public Response moveBack() {
        if (copterDAO.moveBack() != null) {
            return Response.succes(Message.COPTER_POSITION_MESSAGE, copterDAO.getCopter());
        }
        return Response.fail(String.format(Message.MAX_DISTANCE_OUT_MESSAGE, copterDAO.getCopter().getDistance()));
    }

    @Override
    public Response stop() {
        return Response.succes(Message.HOVERING_MESSAGE, copterDAO.getCopter());
    }
}
