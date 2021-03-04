package com.bswen.app10.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.redis.role")
public class RoleRedisProperty extends RedisProperty {
}
