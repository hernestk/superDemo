// CSC111L - Lab 11
// Hernest Koroli
package lab11;
public class BinaryTree {
	
	//TODO add private variable
	private BinaryTreeNode root;

	//TODO add public constructor 
	public BinaryTree() {
        root = null;
    }
	
	// Insert a new node with given key
	public void insert(int key) {
	    root = insertRec(root, key);
	}
	
	// Recursive method to insert a new key into the tree
	private BinaryTreeNode insertRec(BinaryTreeNode node, int key) {
		
		//TODO If node is equal to null, return a new BinaryTreeNode with argument key 
        if(node == null) {
            return new BinaryTreeNode(key);
        }
 		
		//TODO If key is less than node.key, set node.leftChild equal to 
		//     insertRec(a recursive call) with arguments node.leftChild and key
		//			Else, set node.rightChild equal to insertRec(a recursive call) 
		//      	with arguments node.rightChild and key
        if(key < node.key) {
            node.leftChild = insertRec(node.leftChild, key);
        } else {
            node.rightChild = insertRec(node.rightChild, key);
        }
		
		
	    //TODO return node
        return node;
	}
	
	public void inorderTraversal() {
		System.out.println("Inorder traversal of binary tree:");
	    inorderRec(root);
	    
	}
	
	//recursive method to print the tree in order 
	private void inorderRec(BinaryTreeNode node) {
		
		//TODO If node is not equal to null, do the following
		//		-Call inorderRec with argument node.leftChild
		// 		-Print node.key and a space
		//		-Call inorderRec with argument node.rightChild
        if(node != null) {
            inorderRec(node.leftChild);
            System.out.print(node.key + " ");
            inorderRec(node.rightChild);
        }
		
	}
	 // Method to search for a key in the tree
	 public boolean search(int key) {
	     return searchRec(root, key);
	 }
	
	 // A utility function to search for a key in BST
	 private boolean searchRec(BinaryTreeNode node, int key) {
	     //TODO If node is equal to null, return false
        if(node == null) {
            return false;
        }
		 //TODO If node.key is equal to the key passed in, return true
        if(node.key == key) {
            return true;
        }
		 //TODO If the key is less than node.key, return searchRec(a recursive call) 
		 //     with arguments node.leftChild and key
		 // 		Else, return searchRec(a recursive call) with arguments node.rightChild and key
        if(key < node.key) {
            return searchRec(node.leftChild, key);
        } else {
            return searchRec(node.rightChild, key);
        }
	 }

	public boolean isEmpty() {
	    return root == null;
	}
	
	//Getter for root class variable
	public BinaryTreeNode getRoot() {
		return root;
	}
}
