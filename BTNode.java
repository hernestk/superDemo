public class BTNode<E> {
	E data;
	BTNode<E> left, right;

	BTNode() {

	}

	BTNode(E d) {
		data = d;
	}

	BTNode(E d, BTNode<E> l, BTNode<E> r) {
		data = d;
		left = l;
		right = r;
	}
}
