package com.bswen.app10.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.redis.user")
public class UserRedisProperty extends RedisProperty {
}
