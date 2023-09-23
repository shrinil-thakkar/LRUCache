package algorithm;

public class DoublyLinkedList {
    public DoublyLinkedListNode head;
    public DoublyLinkedListNode tail;

    public DoublyLinkedList(){
        head = null;
        tail = null;
    }

    public void evictHead(){
        head = head.next;
        head.prev = null;
    }

    public void removeNode(DoublyLinkedListNode linkedListNode){
        if (head == linkedListNode && tail == linkedListNode) {  // only 1 element
            head = null;
            tail = null;
        }
        else if (head == linkedListNode) {  // at least 2 elements
            head = linkedListNode.next;
            head.prev = null;
        }
        else if (tail == linkedListNode) {  // at least 2 elements
            tail = linkedListNode.prev;
            tail.next = null;
        }
        else {
            linkedListNode.prev.next = linkedListNode.next;
            linkedListNode.next.prev = linkedListNode.prev;
        }
    }

    public void addNodeAtLast(DoublyLinkedListNode linkedListNode) {
        if (tail == null){
            head = tail = linkedListNode;
            return;
        }
        tail.next = linkedListNode;
        linkedListNode.prev = tail;
        linkedListNode.next = null;
        tail = linkedListNode;
    }
}
