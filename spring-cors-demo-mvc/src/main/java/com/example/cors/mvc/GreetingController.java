package com.example.cors.mvc;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class GreetingController {
    private static final String template = "hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    //@CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("===greeting()===");
        long x = 1; short y = 2;
        float r = 5f;
        Greeting greeting = new Greeting(counter.incrementAndGet(),
                String.format(template, name));
        return greeting;
    }

    @GetMapping("/greeting-javaconfig")
    public Greeting greetingWithJavaconfig(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
