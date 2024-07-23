package org.sandbox;

import org.sandbox.service.RedisPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RedisPublisherApplication implements CommandLineRunner {

    @Autowired
    private RedisPublisherService redisPublisherService;

    public static void main(String[] args) {
        SpringApplication.run(RedisPublisherApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String channel = "redis-chat";
        while (true) {
            System.out.print("Enter message: ");
            String message = scanner.nextLine();
            redisPublisherService.publish(channel, message);
            System.out.println("Message published to channel: " + channel);
        }
    }
}
