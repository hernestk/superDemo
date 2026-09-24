package Nodes;
public class BTNodeTest {
    public static void main(String[] args) {
        BTNode<String> root = makeTree1();
        // BTNode<String> hello = makeTree2();

        printTree(root);
        // printTree(hello);
    }

    static BTNode<String> makeTree1() {
        BTNode<String> root = new BTNode<>("D");

        root.left = new BTNode<>("A");
        root.left.left = new BTNode<>("B");
        root.left.right = new BTNode<>("F");
        root.left.right.left = new BTNode<>("E");

        root.right = new BTNode<>("C");
        root.right.right = new BTNode<>("G");
        return root;
    }

    // static BTNode<String> makeTree2() {
    //     return new BTNode<>(
    //         "D",
    //         new BTNode<>(
    //             "A",
    //             new BTNode<>("B");
    //             new BTNode<>(
    //                 "F",
    //                 new BTNode<>("G"),
    //                 null
    //             )
    //         ),
    //         new BTNode<>(
    //             "C",
    //         )
    //     );
    //     new BTNode<>(
    //         "C",
    //         null,
    //         new BTNode<>("E");
    //     )
    // }

    // prints the strings in alphabetical order using their known positions
    // in the tree picture above (check kohlberg github for that)
    static void printTree(BTNode<String> tree) {
        System.out.println(tree.left.data);
        System.out.println(tree.left.left.data);
        System.out.println(tree.right.data);
        System.out.println(tree.data);
        System.out.println(tree.left.right.left.data);
        System.out.println(tree.left.right.data);
        System.out.println(tree.right.right.data);
    }
}