package cn.rpm.goods.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReceiverDelegate {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverDelegate.class);
    public void receiveMessage(String message) {
        LOGGER.info("Received <" + message + ">");
    }
}