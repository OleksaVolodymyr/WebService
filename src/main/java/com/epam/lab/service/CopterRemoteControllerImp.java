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
        LOG.info("Create new copter");
        copterDAO = new CopterDAO();
    }

    @Override
    public Response moveUp() {
        if (copterDAO.moveUp() != null) {
            LOG.info(Message.MOVE_UP_MESSAGE+copterDAO.getCopter());
            return Response.succes(Message.MOVE_UP_MESSAGE, copterDAO.getCopter());
        }
        LOG.error(String.format(Message.MAX_HEIGHT_OUT_MESSAGE, copterDAO.getCopter().getHeight()));
        return Response.fail(String.format(Message.MAX_HEIGHT_OUT_MESSAGE, copterDAO.getCopter().getHeight()), copterDAO.getCopter());
    }

    @Override
    public Response moveDown() {
        if (copterDAO.moveDown() != null) {
            LOG.info(Message.MOVE_DOWN_MESSAGE + copterDAO.getCopter());
            return Response.succes(Message.MOVE_DOWN_MESSAGE, copterDAO.getCopter());
        }
        LOG.error(String.format(Message.MIN_HEIGHT_OUT_MESSAGE, copterDAO.getCopter().getHeight()));
        return Response.fail(String.format(Message.MIN_HEIGHT_OUT_MESSAGE, copterDAO.getCopter().getHeight()), copterDAO.getCopter());
    }

    @Override
    public Response moveForward() {
        if (copterDAO.moveForward() != null) {
            LOG.info(Message.MOVE_FORWARD_MESSAGE + copterDAO.getCopter());
            return Response.succes(Message.MOVE_FORWARD_MESSAGE, copterDAO.getCopter());
        }
        LOG.error(String.format(Message.MAX_DISTANCE_OUT_MESSAGE, copterDAO.getCopter().getDistance()));
        return Response.fail(String.format(Message.MAX_DISTANCE_OUT_MESSAGE, copterDAO.getCopter().getDistance()), copterDAO.getCopter());
    }

    @Override
    public Response moveBack() {
        if (copterDAO.moveBack() != null) {
            LOG.info(Message.MOVE_BACK_MESSAGE + copterDAO.getCopter());
            return Response.succes(Message.MOVE_BACK_MESSAGE, copterDAO.getCopter());
        }
        LOG.error(String.format(Message.MAX_DISTANCE_OUT_MESSAGE, copterDAO.getCopter().getDistance()));
        return Response.fail(String.format(Message.MAX_DISTANCE_OUT_MESSAGE, copterDAO.getCopter().getDistance()), copterDAO.getCopter());
    }

    @Override
    public Response stop() {
        LOG.info(Message.HOVERING_MESSAGE + copterDAO.getCopter());
        return Response.succes(Message.HOVERING_MESSAGE, copterDAO.getCopter());
    }

    @Override
    public Response getCurrentPosition() {
        if (copterDAO.getCopter() != null) {
            LOG.info(Message.COPTER_POSITION_MESSAGE + copterDAO.getCopter());
            return Response.succes(Message.COPTER_POSITION_MESSAGE, copterDAO.getCopter());
        }
        LOG.error(Message.COPTER_NOTEXSIST_MESSAGE);
        return Response.fail(Message.COPTER_NOTEXSIST_MESSAGE);
    }
}
