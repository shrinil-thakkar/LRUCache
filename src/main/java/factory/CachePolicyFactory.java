package factory;

import entity.Cache;
import entity.CacheType;
import entity.DefaultCache;
import entity.LRUCache;
import exception.NoCacheManagerFoundException;
import manager.CacheManager;
import manager.DefaultCacheManager;
import manager.LRUCacheManager;

public class CachePolicyFactory {

    public static CacheManager getCacheManger(Cache cache) throws NoCacheManagerFoundException {
        if (cache.getCacheType() == CacheType.LRU)
            return new LRUCacheManager((LRUCache) cache);
        else if (cache.getCacheType() == CacheType.DEFAULT)
            return new DefaultCacheManager((DefaultCache) cache);
        throw new NoCacheManagerFoundException();
    }
}
