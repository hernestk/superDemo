package Nodes;
public class NodeTest {
    public static void main(String[] args) {
        Node<Integer> n = new Node<>(1, null);
        n = new Node<>(2, n);
	    System.out.println("Data: " + n.data + " Next: " + n.next.data);
	    n = new Node<>(3, n);
	    System.out.println("Data: " + n.data + " Next: " + n.next.data);
    }
}
