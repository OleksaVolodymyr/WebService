package com.epam.lab.factory;

import com.epam.lab.restClient.RESTClient;
import com.epam.lab.soapClient.service.CopterRemoteControllerImpService;

public class ClientSelector {
    private static CopterRemoteController client;

    public static CopterRemoteController getClient(ClientType clientType) {
        switch (clientType) {
            case REST_CLIENT:
                client = new RESTClient();
                break;
            case SOAP_CLIENT:
                client = new CopterRemoteControllerImpService().getCopterRemoteControllerImpPort();
                break;
        }
        return client;
    }
}
