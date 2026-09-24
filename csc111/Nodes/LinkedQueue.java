package Nodes;
import java.util.NoSuchElementException;

public class LinkedQueue<E> {
    private final int DEFAULT_SIZE = 10;
    E[] data;
    private Node<E> front, back;
    private int size;
    
    @SuppressWarnings("unchecked")
    public LinkedQueue() {
        data = (E[]) new Object[DEFAULT_SIZE];
        front = null;
        back = null;
    }

    public void enqueue(E element) {
        if(isEmpty()) {
            back = new Node<>(element);
            front = back;
        }

        size++;
    }

    public E dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        E element = front.data;
        front = front.next;

        size--;
        return element;
    }

    public int size() {
        return size;
    }

    public E peek() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        return front.data;
    }

    public void printQueue() {
        Node n = front;
        while(n != null) {
            System.out.println(n.data + " ");
            n = n.next;
        }
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
}
