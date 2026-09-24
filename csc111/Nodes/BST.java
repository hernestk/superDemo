package Nodes;
public class BST {
    private BTNode<String> root;

    public BST() {
        root = null;
    }

    public void insert(BTNode<String> node, String element) {
		if(root == null) {
	   	root = new BTNode<>(element);
		} else {
			insert(root, element);
    	}
	}

    // has to be a recursive method to check for parent nodes
    // if a parent node, call the method to check until child nodes
    public boolean contains(String element) {
		int comparision = element.compareTo(node.data);
		if(comparision == 0) {
			return true;
		} else if(comparision < 0) {
			if(node.left == null) {
				
			}
		}
        return false;
    }

    private boolean contains(BTNode<String> node, String element) {
	int comparison = element.compareTo(root.data);
	if(comparison == 0) {
	   return true;
	} else if(comparison < 0) {
		if(node.left != null) {
			// TODO: recursive case) if node.left isn't null, return contains(node.left)
			return contains(node.left);
		}
		
		// TODO: if node.left is null, return false
	} else {
	   // TODO: same as left, but for the right side
	}
}
    public void inorder() {
		inorder(root);
    }

    private void inorder(BTNode<String> node) {
		if(node != null) {
        	inorder(node.left);
        	System.out.println(node.data);
	    	inorder(node.right);
		}
    }

    

    public void postorder() {

    }
}
