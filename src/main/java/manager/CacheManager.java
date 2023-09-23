package manager;

import exception.KeyNotFoundException;

public interface CacheManager {
    void set(Object key, Object value);
    Object get(Object key) throws KeyNotFoundException;
    void flushAll();
    void printCache();
}
