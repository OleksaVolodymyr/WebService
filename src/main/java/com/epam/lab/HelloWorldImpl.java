
package com.epam.lab;

import javax.jws.WebService;

@WebService(endpointInterface = "com.epam.lab.SoapGenerate.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

