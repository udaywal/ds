package tree;

class Node {
    int data;
    Node left;
    Node right;
    Node(int value) {
        this.data = value;
        this.left = this.right = null;
    }
}

class Tree {
    Node root;
    Tree() {
        this.root = null;
    }
}

public class BinaryTreeCode {

    public static void main(String[] args) {

        Tree tree = new Tree();

        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        
    }
    
}
