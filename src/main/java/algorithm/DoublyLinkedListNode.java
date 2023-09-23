package algorithm;


public class DoublyLinkedListNode {

    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;
    public Object element;

    public DoublyLinkedListNode(Object value, DoublyLinkedListNode prev, DoublyLinkedListNode next){
        element=value;
        this.next=next;
        this.prev=prev;
    }
}
