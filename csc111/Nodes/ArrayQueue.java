package Nodes;
import java.util.NoSuchElementException;

public class ArrayQueue<E> {
    public final int DEFAULT_SIZE = 10;
    public E[] data;
    private int front, back, size;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        data = (E[]) new Object [DEFAULT_SIZE];
        front = 0;
        back = 0;
        size = 0;
    }

    public void printQueue() {
        for (int offset = 0; offset < size; offset++) {
            int i = (front + offset) % data.length;
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
    public void enqueue(E element) {
        if(size == capacity()) {
            throw new IllegalStateException();
        }

        data[back] = element;
        back = (back + 1) % data.length;
        size += 1;
    }

    public E dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        E element = data[front];

        data[front] = null;
        front = (front + 1) % data.length;
        size -= 1;
        return element;
    }

    public E peek() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        return data[front];
    }

    public void clear() {
        // TODO: null every element
        for (int offset = 0; offset < size; offset++) {
            int i = (front + offset) % data.length;
            data[i] = null;
        }
        front = 0;
        back = 0;
        size = 0;
    
    }

    public int capacity() {
        return data.length;
    }

    public int size() {
        return size;
    }

    public void ensureCapacity() {
        if(size == capacity()) {
            E[] newData = (E[]) new Object[size() * 2];
            for (int offset = 0; offset < size; offset++) {
            int oldIndex = (front + offset) % data.length;
            int newIndex = offset;
            data[newIndex] = data[oldIndex];
        }
        data = newData;
        front = 0;
        back = size;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
