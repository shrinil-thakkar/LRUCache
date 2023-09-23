package manager;

import entity.DefaultCache;
import java.util.HashMap;

public class DefaultCacheManager implements CacheManager{

    DefaultCache defaultCache;

    public DefaultCacheManager(DefaultCache defaultCache){
        this.defaultCache = defaultCache;
    }

    @Override
    public void set(Object key, Object value) {
        HashMap<Object, Object> cacheMap = defaultCache.getCacheMap();
        cacheMap.put(key, value);
        defaultCache.setCacheMap(cacheMap);
    }

    @Override
    public Object get(Object key) {
        return defaultCache.getCacheMap().get(key);
    }

    @Override
    public void flushAll() {
        HashMap<Object, Object> cacheMap = defaultCache.getCacheMap();
        cacheMap.clear();
        defaultCache.setCacheMap(cacheMap);
    }

    @Override
    public void printCache() {
        System.out.println(defaultCache.getCacheMap());
    }
}
