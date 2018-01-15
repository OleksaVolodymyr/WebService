package com.epam.lab.restClient;

import com.epam.lab.factory.CopterRemoteController;
import com.epam.lab.webmodel.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RESTClient implements CopterRemoteController {
    public static final String MOVE_UP_URL = "http://localhost:8080/RemoteControll/CopterControlServiceImp/moveUp";
    public static final String MOVE_DOWN_URL = "http://localhost:8080/RemoteControll/CopterControlServiceImp/moveDown";
    public static final String MOVE_FORWARD_URL = "http://localhost:8080/RemoteControll/CopterControlServiceImp/moveForward";
    public static final String MOVE_BACK_URL = "http://localhost:8080/RemoteControll/CopterControlServiceImp/moveBack";
    public static final String STOP_URL = "http://localhost:8080/RemoteControll/CopterControlServiceImp/stop";
    public static final String GET_POSITION_URL = "http://localhost:8080/RemoteControll/CopterControlServiceImp/getCurrentPosition";


    @Override
    public Response moveBack() {
        ObjectMapper mapper = new ObjectMapper();
        Response response = null;
        try {
            response = mapper.readValue(getJsonFromRequest(MOVE_BACK_URL), Response.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response stop() {
        ObjectMapper mapper = new ObjectMapper();
        Response response = null;
        try {
            response = mapper.readValue(getJsonFromRequest(STOP_URL), Response.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response moveForward() {
        ObjectMapper mapper = new ObjectMapper();
        Response response = null;
        try {
            response = mapper.readValue(getJsonFromRequest(MOVE_FORWARD_URL), Response.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response moveUp() {
        ObjectMapper mapper = new ObjectMapper();
        Response response = null;
        try {
            response = mapper.readValue(getJsonFromRequest(MOVE_UP_URL), Response.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response moveDown() {
        ObjectMapper mapper = new ObjectMapper();
        Response response = null;
        try {
            response = mapper.readValue(getJsonFromRequest(MOVE_DOWN_URL), Response.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response getCurrentPosition() {
        ObjectMapper mapper = new ObjectMapper();
        Response response = null;
        try {
            response = mapper.readValue(getJsonFromRequest(GET_POSITION_URL), Response.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private String getJsonFromRequest(String address) {
        URL url = null;
        StringBuilder response = new StringBuilder();
        try {
            url = new URL(address);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                return null;
            }
            String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }
}
