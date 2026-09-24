import Nodes.Node;

public class LinkedList<E> {
    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }



    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void insert(int index, E element) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        if(index == 0) {
            head = new Node<>(element, head);
        }
    }

    public void removeAt(int index, E element) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        if(index == 0) {
            
        }
    }
}
