package com.haulmont.client;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import static com.haulmont.client.ClientApplication.QUEUE_NAME;

@Component
public class Listener {

    //Uncomment for receiving
    //@JmsListener(destination = QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.printf("Received: %s", message);
    }
}
