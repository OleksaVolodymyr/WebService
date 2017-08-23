package com.epam.lab;

import com.epam.lab.service.CopterRemoteController;
import com.epam.lab.service.CopterRemoteControllerImpService;

public class AppTest {

    public static void main(String[] args) {
        CopterRemoteControllerImpService service1 = new CopterRemoteControllerImpService();
        CopterRemoteController client = service1.getCopterRemoteControllerImpPort();
        System.out.println(client.getCurrentPosition());
        System.out.println(client.moveForward());
        //System.out.println(client.moveBack());
        System.out.println(client.moveForward());
        System.out.println(client.moveForward());
        System.out.println(client.moveForward());
        System.out.println(client.moveForward());
        System.out.println(client.moveForward());
        System.out.println(client.moveForward());
       // System.out.println(client.moveBack());
        //System.out.println(client.getCurrentPosition());
    }
}
