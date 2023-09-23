package service;

import entity.Cache;
import exception.KeyNotFoundException;
import factory.CachePolicyFactory;
import manager.CacheManager;

public class CacheService {

    CacheManager cacheManager;

    public CacheService(Cache cache) throws Exception{
        cacheManager = CachePolicyFactory.getCacheManger(cache);
    }

    public void set(Object key, Object value) {
        System.out.println("*** Inside " + cacheManager.getClass() + " set: key: " + key + ", value = " + value + " ***");
        cacheManager.set(key, value);
    }

    public Object get(Object key) {
        System.out.println("*** Inside " + cacheManager.getClass() + " get: key: " + key + " ***");
        try {
            return cacheManager.get(key);
        }
        catch (KeyNotFoundException ke){
            System.out.println(ke.getMessage());
            return null;
        }
    }

    public void flushAll() {
        System.out.println("*** Inside " + cacheManager.getClass() + " flushAll ***");
        cacheManager.flushAll();
    }

    public void printCache() {
        System.out.println("*** Inside " + cacheManager.getClass() + " printCache ***");
        cacheManager.printCache();
    }
}
