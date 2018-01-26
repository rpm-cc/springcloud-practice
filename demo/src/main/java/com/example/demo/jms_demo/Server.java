package com.example.demo.jms_demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Server {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        while (true) {
            String context = "hello " + new Date();
            System.out.println("Sender : " + context);
            this.rabbitTemplate.convertAndSend("hello", context);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
