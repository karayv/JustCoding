package my.coding.linkedlist;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Tasks.
 * 
 * Write code to remove duplicates from an unsorted linked list.
 * Implement an algorithm to find the nth to last element of a singly linked list.
 * 
 * @author Andrey Karayvansky
 * 
 * @param <T>
 */
public class UnsortedLinkedList<T> {

    private Node<T> first;
    private Node<T> last;
    private final AtomicInteger size = new AtomicInteger(0);
    
    private class Node<TN> {
        Node<TN> next;
        TN item;
        
        Node<TN> getNext() {
            return next;
        }

        TN getItem() {
            return item;
        }

        void setNext(Node<TN> next) {
            this.next = next;
        }

        void setItem(TN item) {
            this.item = item;
        }
    }

    public void add(T item) {
        Node<T> node = new Node<>();
        node.setItem(item);
        // is empty ?
        if (first == null) {
            first = node;
            last = first;
        } else {
            last.setNext(node);
            last = node;
        }
        size.incrementAndGet();
    }

    public T get(int index) {
        
        Node<T> node = first;
        for (int i = 1; i <= index; i++) {
            if (node == null) {
                break;
            }
            node = node.getNext();
        }
        if (node == null) {
            throw new IndexOutOfBoundsException();
        }
        return node.getItem();
    }

    public void removeDuplicates() {
        if (first == null) {
            return;
        }
        
        Node<T> current = first;
        
        while (current.getNext() != null) {
            Node<T> next = current.getNext();
            Node<T> prev = current;
            
            while (next != null) {
                if (next.getItem() == null && current.getItem() == null) {
                    removeNext(prev);
                } else if (current.getItem() != null && current.getItem().equals(next.getItem())) {
                    removeNext(prev);
                }
                prev = next;
                next = next.getNext();
            }
            current = current.getNext();
        }
    }

    private void removeNext(Node<T> prev) {
        Node<T> node = prev.getNext();
        
        prev.setNext(node.getNext());
        
        node.setItem(null);
        node.setNext(null);
        size.decrementAndGet();
    }

    public T getByReversedIndex(int i) {
        return get(size.get() - i - 1);
    }
}
