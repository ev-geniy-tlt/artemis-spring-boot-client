package com.haulmont.client;

import org.apache.activemq.artemis.utils.RandomUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ClientApplication {

    public static final String QUEUE_NAME = "crm-users";

    public static void main(String[] args) throws InterruptedException {
        final ConfigurableApplicationContext context = SpringApplication.run(ClientApplication.class);
        Sender sender = context.getBean(Sender.class);
        for (int i = 0; i < 10000; i++) {
            System.out.printf("Sending message %s\n", i);
            sender.send(String.format("artemis%s", RandomUtil.randomInt()));
            Thread.sleep(10000);
        }
        context.close();
    }
}
