package com.firstProject.repository.cache;

public interface CacheRepository {
    void createCacheEntity(String key, String value);
    public String getCacheEntity(String key);
    public void updateCacheEntity(String key, String value);
    public void removeCacheEntity(String key);
    public Boolean isKeyExists(String key);
}
