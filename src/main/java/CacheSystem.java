import entity.DefaultCache;
import entity.LRUCache;
import service.CacheService;

public class CacheSystem {
    public static void main(String[] args) throws Exception {
        LRUCache lruCache = new LRUCache(3);

        CacheService lruCacheService1 = new CacheService(lruCache);
        lruCacheService1.set(1, 2);
        lruCacheService1.set("Hello", "bye");
        lruCacheService1.printCache();
        // current cache: (1,2) -> ("Hello", "bye")

        Object getObject = lruCacheService1.get(1);
        System.out.println("Getting for key '1', value: " + getObject);
        lruCacheService1.printCache();
        // current cache: ("Hello", "bye") -> (1,2)

        lruCacheService1.set(3, 4);
        lruCacheService1.printCache();
        // current cache: ("Hello", "bye") -> (1,2) -> (3,4)

        lruCacheService1.set("Good", "boy");
        lruCacheService1.printCache();
        // current cache: (1,2) -> (3,4) -> ("Good", "boy")

        lruCacheService1.get("Hello");

        CacheService lruCacheService2 = new CacheService(lruCache);
        getObject = lruCacheService2.get(1);
        System.out.println("Getting for key '1', value: " + getObject);
        lruCacheService2.printCache();
        // current cache: (3,4) -> ("Good", "boy") -> (1,2)

        lruCacheService2.flushAll();
        lruCacheService2.printCache();

        DefaultCache defaultCache = new DefaultCache();
        CacheService lruCacheService3 = new CacheService(defaultCache);
        lruCacheService3.set(1, 2);
        lruCacheService3.set("Hello", "Bye");
        lruCacheService3.get(1);
        System.out.println("Getting for key '1', value: " + getObject);
        lruCacheService3.printCache();
    }
}
