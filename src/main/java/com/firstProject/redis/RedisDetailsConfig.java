package com.firstProject.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("redis")
public class RedisDetailsConfig {
    private String host;
    private Integer port;
    private Long ttl;

    public RedisDetailsConfig(){}

    public RedisDetailsConfig(String host, Integer port, Long ttl) {
        this.host = host;
        this.port = port;
        this.ttl = ttl;
    }

    public String getHost() {
        return host;
    }

    public Integer getPort() {
        return port;
    }

    public Long getTtl() {
        return ttl;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setTtl(Long ttl) {
        this.ttl = ttl;
    }
}
