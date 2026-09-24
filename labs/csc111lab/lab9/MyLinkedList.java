// CSC111L - Lab 9
// Hernest Koroli
package lab9;

public class MyLinkedList {
	private Node head;
	private Node tail;
	private int size;

	public MyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void add(String value) {
	    Node newNode = new Node(value);
	
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
	
	public void insertAtFront(String value) {
		//TODO create a new Node using the string passed in
		Node newNode = new Node(value);
	    // set the new Node's next variable equal to the class variable head
		newNode.next = head;
	    // set the head equal to the new Node you created
	    head = newNode;
	    // if the tail is equal to null, set the tail
	    //		equal to the new Node you created
		if(tail == null) {
			tail = newNode;
		}
    
		size++;
	}
	
	public String get(int index) {
		//TODO create a new Node called 
		//		temp and set it equal to head
		Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
    
		return temp.data;
    }
		
	public int size() {
        return size;
	}
}