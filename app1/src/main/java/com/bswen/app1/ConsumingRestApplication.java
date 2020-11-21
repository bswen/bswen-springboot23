package com.bswen.app1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class ConsumingRestApplication {
    private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(ConsumingRestApplication.class,args);
    }
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Greeting greeting =
                    restTemplate.getForObject("http://localhost:8080/greeting",
                            Greeting.class);
            log.info("got rest call result {}",greeting);
        };
    }
}
