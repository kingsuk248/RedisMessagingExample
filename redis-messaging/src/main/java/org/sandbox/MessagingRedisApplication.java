package org.sandbox;

import org.sandbox.receiver.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
public class MessagingRedisApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessagingRedisApplication.class);

    public static void main(String[] args) throws InterruptedException {

        ApplicationContext ctx = SpringApplication.run(MessagingRedisApplication.class, args);

        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
        Receiver receiver = ctx.getBean(Receiver.class);

        while (receiver.getCount() == 0) {

            LOGGER.info("Sending messages...");
            int n = 10;
            while (n > 0) {
                template.convertAndSend("chat", "Hello from Redis! <msg:> " + (10 - n + 1));
                Thread.sleep(500L);
                n--;
            }
        }

        System.exit(0);
    }
}
