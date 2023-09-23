package entity;

import algorithm.DoublyLinkedList;
import algorithm.DoublyLinkedListNode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class LRUCache extends Cache{

    HashMap<Object, DoublyLinkedListNode> cacheMap;
    DoublyLinkedList doublyLinkedList;
    HashMap<DoublyLinkedListNode, Object> reverseCacheMap;

    public LRUCache(int limit){
        super(limit);
        cacheMap = new HashMap<>();
        doublyLinkedList = new DoublyLinkedList();
        reverseCacheMap = new HashMap<>();
        cacheType = CacheType.LRU;
    }
}
