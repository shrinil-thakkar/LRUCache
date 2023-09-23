package manager;

import algorithm.DoublyLinkedList;
import algorithm.DoublyLinkedListNode;
import entity.LRUCache;
import exception.KeyNotFoundException;

import java.util.HashMap;


public class LRUCacheManager implements CacheManager{

    LRUCache lruCache;
    HashMap<Object, DoublyLinkedListNode> cacheMap;
    HashMap<DoublyLinkedListNode, Object> reverseCacheMap;
    DoublyLinkedList doublyLinkedList;

    public LRUCacheManager(LRUCache lruCache){
        this.lruCache = lruCache;
        doublyLinkedList = new DoublyLinkedList();
    }

    private void getCacheAttributes(){
        cacheMap = lruCache.getCacheMap();
        reverseCacheMap = lruCache.getReverseCacheMap();
        doublyLinkedList = lruCache.getDoublyLinkedList();
    }

    private void setCacheAttributes(){
        lruCache.setCacheMap(cacheMap);
        lruCache.setReverseCacheMap(reverseCacheMap);
        lruCache.setDoublyLinkedList(doublyLinkedList);
    }

    @Override
    public void set(Object key, Object value) {
        DoublyLinkedListNode linkedListNode;
        getCacheAttributes();

        if (cacheMap.containsKey(key)) {
            linkedListNode = cacheMap.get(key);
            linkedListNode.element = value;
            doublyLinkedList.removeNode(linkedListNode);
        }
        else {
            if(cacheMap.size() == lruCache.getCacheLimit()) {
                evictHead();
            }
            linkedListNode = new DoublyLinkedListNode(value, null, null);
        }
        doublyLinkedList.addNodeAtLast(linkedListNode);
        cacheMap.put(key, linkedListNode);
        reverseCacheMap.put(linkedListNode, key);
        setCacheAttributes();
    }

    @Override
    public Object get(Object key) throws KeyNotFoundException {
        getCacheAttributes();

        if (!cacheMap.containsKey(key))
            throw new KeyNotFoundException("GET operation: Key "+ key + " not present in the LRUCache");

        DoublyLinkedListNode linkedListNode = cacheMap.get(key);
        doublyLinkedList.removeNode(linkedListNode);
        doublyLinkedList.addNodeAtLast(linkedListNode);
        setCacheAttributes();
        return linkedListNode.element;
    }

    @Override
    public void flushAll() {
        getCacheAttributes();
        cacheMap.clear();
        reverseCacheMap.clear();
        doublyLinkedList.head = null;
        doublyLinkedList.tail = null;
        setCacheAttributes();
    }

    public void evictHead(){
        Object key = reverseCacheMap.get(doublyLinkedList.head);
        System.out.println("Evicting key, value: " + key + ", " + doublyLinkedList.head.element);
        cacheMap.remove(key);
        reverseCacheMap.remove(doublyLinkedList.head);
        doublyLinkedList.evictHead();
    }

    public void printCache(){
        System.out.println("Cache size: " + cacheMap.size());
        System.out.println("Cache Map: " + cacheMap.toString());
        System.out.println("Cache head: " + reverseCacheMap.get(doublyLinkedList.head));
        System.out.println("Cache tail: " + reverseCacheMap.get(doublyLinkedList.tail));
        System.out.println();
    }

}

