package com.app11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App11Application {

    private final static Logger logger = LoggerFactory.getLogger(App11Application.class);


    public static void main(String[] args) {
        SpringApplication.run(App11Application.class, args);
    }


}
