package com.bswen.app10.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestRedisService {
    @Autowired
    private RedisService redisService;

    @Test
    public void testGetAndSet() {
        redisService.set("hello","world");
        Assertions.assertEquals(redisService.get("hello"),"world");
    }
}
