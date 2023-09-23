# LRUCache
In-memory LRU Cache implementation using OOPs principles and suitable Design Patterns.

# Problem Statement:
We have to do low-level design for a Cache system. The cache that we will design will have to support the following operations:
- Put: This will allow the user to put a value against a key in the cache.
- Get: This will allow the user to get the previously saved value using a key.
- Eviction: The cache should also support the removal of some keys in case the cache is full, and we try to add a new key value.
- PrintCache: Prints the size, least recently used key, and most recently used key.
- FlushAll: Cleans up the cache.

# Expectations
The code should be functionally correct.
The code should be modular and readable. Clean and professional level code.
Code should be extensible and scalable. This means it should be able to accommodate new requirements with minimal changes.
The code should have a good OOP design.

# Design Patterns used:
1. Strategy Design Pattern
2. Factory Design Pattern

# Wrote the code following SOLID principles which could be easily extensible.

# Implementations of cache storage policy:
1. HashMap based
2. HashMap + Doubly Linked List based

# Implementations of cache eviction policy:
1. Least Recently Used (LRU)
   - There is an option to pass the limit while creating the cache. The cache will maintain the order of the keys accessed using the Doubly Linked List and evict the LRU element when the capacity is full.
  
# Test Case Demo

```
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
```

# Output

```
*** Inside class manager.LRUCacheManager set: key: 1, value = 2 ***
*** Inside class manager.LRUCacheManager set: key: Hello, value = bye ***
*** Inside class manager.LRUCacheManager printCache ***
Cache size: 2
Cache Map: {1=algorithm.DoublyLinkedListNode@23fc625e, Hello=algorithm.DoublyLinkedListNode@3f99bd52}
Cache head: 1
Cache tail: Hello

*** Inside class manager.LRUCacheManager get: key: 1 ***
Getting for key '1', value: 2
*** Inside class manager.LRUCacheManager printCache ***
Cache size: 2
Cache Map: {1=algorithm.DoublyLinkedListNode@23fc625e, Hello=algorithm.DoublyLinkedListNode@3f99bd52}
Cache head: Hello
Cache tail: 1

*** Inside class manager.LRUCacheManager set: key: 3, value = 4 ***
*** Inside class manager.LRUCacheManager printCache ***
Cache size: 3
Cache Map: {1=algorithm.DoublyLinkedListNode@23fc625e, 3=algorithm.DoublyLinkedListNode@31befd9f, Hello=algorithm.DoublyLinkedListNode@3f99bd52}
Cache head: Hello
Cache tail: 3

*** Inside class manager.LRUCacheManager set: key: Good, value = boy ***
Evicting key, value: Hello, bye
*** Inside class manager.LRUCacheManager printCache ***
Cache size: 3
Cache Map: {1=algorithm.DoublyLinkedListNode@23fc625e, 3=algorithm.DoublyLinkedListNode@31befd9f, Good=algorithm.DoublyLinkedListNode@1c20c684}
Cache head: 1
Cache tail: Good

*** Inside class manager.LRUCacheManager get: key: Hello ***
GET operation: Key Hello not present in the LRUCache
*** Inside class manager.LRUCacheManager get: key: 1 ***
Getting for key '1', value: 2
*** Inside class manager.LRUCacheManager printCache ***
Cache size: 3
Cache Map: {1=algorithm.DoublyLinkedListNode@23fc625e, 3=algorithm.DoublyLinkedListNode@31befd9f, Good=algorithm.DoublyLinkedListNode@1c20c684}
Cache head: 3
Cache tail: 1

*** Inside class manager.LRUCacheManager flushAll ***
*** Inside class manager.LRUCacheManager printCache ***
Cache size: 0
Cache Map: {}
Cache head: null
Cache tail: null

*** Inside class manager.DefaultCacheManager set: key: 1, value = 2 ***
*** Inside class manager.DefaultCacheManager set: key: Hello, value = Bye ***
*** Inside class manager.DefaultCacheManager get: key: 1 ***
Getting for key '1', value: 2
*** Inside class manager.DefaultCacheManager printCache ***
{1=2, Hello=Bye}
```

Took the problem statement from [here](https://github.com/anomaly2104/cache-low-level-system-design/blob/master/problem-statement.md).
