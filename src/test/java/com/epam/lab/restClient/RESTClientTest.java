package com.epam.lab.restClient;

import com.epam.lab.factory.ClientSelector;
import com.epam.lab.factory.ClientType;
import com.epam.lab.factory.CopterRemoteController;
import com.epam.lab.listener.CustomTestListener;
import com.epam.lab.webmodel.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomTestListener.class)
public class RESTClientTest {
    private static final int CHANGE_DISTANCE = 15;
    private CopterRemoteController restClient;
    private Response res;

    @BeforeClass
    public void setUp() {
        restClient = ClientSelector.getClient(ClientType.REST_CLIENT);
    }

    @BeforeMethod
    public void beforeTest() {
        res = restClient.getCurrentPosition();
    }

    @Test
    public void moveUpTest() {
        Response response = restClient.moveUp();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getCopter());
        Assert.assertEquals(response.getMessage(), "Copter move up");
        Assert.assertEquals(response.getCopter().getHeight(), res.getCopter().getHeight() + CHANGE_DISTANCE);
    }

    @Test
    public void moveForwardTest() {
        Response response = restClient.moveForward();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getCopter());
        Assert.assertEquals(response.getMessage(), "Copter move forward");
        Assert.assertEquals(response.getCopter().getDistance(), res.getCopter().getDistance() + CHANGE_DISTANCE);
    }

    @Test
    public void moveBackTest() {
        Response response = restClient.moveBack();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getCopter());
        Assert.assertEquals(response.getMessage(), "Copter move back");
        Assert.assertEquals(response.getCopter().getDistance(), res.getCopter().getDistance() - CHANGE_DISTANCE);
    }

    @Test
    public void moveDownTest() {
        Response response = restClient.moveDown();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getCopter());
        Assert.assertEquals(response.getMessage(), "Copter move down");
        Assert.assertEquals(response.getCopter().getHeight(), res.getCopter().getHeight() - CHANGE_DISTANCE);
    }

    @Test
    public void stopTest() {
        Response response = restClient.stop();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getCopter());
        Assert.assertEquals(response.getMessage(), "Copter hovering");
        Assert.assertEquals(response.getCopter(), res.getCopter());
    }

    @Test
    public void maxUpRangeTest() {
        while (restClient.moveUp().getCopter() != null) {
        }
        Response responseUP = restClient.moveUp();
        Assert.assertNotNull(responseUP);
        Assert.assertNull(responseUP.getCopter());
        Assert.assertEquals(responseUP.getMessage(), String
                .format("It is impossible to rise above 100, current copter height: %s", restClient.getCurrentPosition()
                        .getCopter().getHeight()));

    }

    @Test
    public void maxDownRangeTest() {
        while (restClient.moveDown().getCopter() != null) {
        }
        Response responseDown = restClient.moveDown();
        Assert.assertNotNull(responseDown);
        Assert.assertNull(responseDown.getCopter());
        Assert.assertEquals(responseDown.getMessage(), String
                .format("It is impossible drop below 0, current copter height: %s", restClient.getCurrentPosition()
                        .getCopter().getHeight()));
    }

    @Test
    public void maxForwardDistanceTest() {
        while (restClient.moveForward().getCopter() != null) {
        }
        Response responseForward = restClient.moveForward();
        Assert.assertNotNull(responseForward);
        Assert.assertNull(responseForward.getCopter());
        Assert.assertEquals(responseForward.getMessage(), String
                .format("It is impossible to distance from the starting point more than 100 meters, current distance %s", restClient
                        .getCurrentPosition().getCopter().getDistance()));

    }

    @Test
    public void maxBackDistanceTest() {
        while (restClient.moveBack().getCopter() != null) {
        }
        Response responseBack = restClient.moveBack();
        Assert.assertNotNull(responseBack);
        Assert.assertNull(responseBack.getCopter());
        Assert.assertEquals(responseBack.getMessage(), String
                .format("It is impossible to distance from the starting point more than 100 meters, current distance %s", restClient
                        .getCurrentPosition().getCopter().getDistance()));
    }
}
