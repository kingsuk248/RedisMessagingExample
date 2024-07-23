package org.sandbox.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MessageSubscriber {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageSubscriber.class);

    public void onMessage(String message, String channel) {
        LOGGER.info("Received message: " + message + " from channel: " + channel);
        System.out.println("Received message: " + message + " from channel: " + channel);
    }
}
