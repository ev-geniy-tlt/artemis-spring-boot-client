package com.haulmont.client;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import static com.haulmont.client.ClientApplication.QUEUE_NAME;

@Component
public class Sender {

    private final JmsTemplate jmsTemplate;

    public Sender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(String message) {
        jmsTemplate.convertAndSend(QUEUE_NAME, message);
    }
}
