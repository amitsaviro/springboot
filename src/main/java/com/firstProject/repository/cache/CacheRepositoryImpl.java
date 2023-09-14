package com.firstProject.repository.cache;

import com.firstProject.redis.RedisDetailsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisPooled;

@Repository
public class CacheRepositoryImpl implements CacheRepository {

    @Autowired
    private JedisPooled jedisPooled;

    @Autowired
    private RedisDetailsConfig redisDetailsConfig;

    @Override
    public void createCacheEntity(String key, String value) {
        if(!jedisPooled.exists(key)){
            jedisPooled.setex(key, redisDetailsConfig.getTtl(), value);
        }
    }

    @Override
    public String getCacheEntity(String key) {
        if(jedisPooled.exists(key)){
            return jedisPooled.get(key);
        } else {
            return null;
        }
    }

    @Override
    public void updateCacheEntity(String key, String value) {
        if(jedisPooled.exists(key)){
            jedisPooled.setex(key, redisDetailsConfig.getTtl(), value);
        }
    }

    @Override
    public void removeCacheEntity(String key) {
        if(jedisPooled.exists(key)){
            jedisPooled.del(key);
        }
    }

    @Override
    public Boolean isKeyExists(String key) {
        return jedisPooled.exists(key);
    }
}
