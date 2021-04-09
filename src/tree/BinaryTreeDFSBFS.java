package tree;

import java.util.*;

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

    // Method to print the tree in pre-order traversal
    void preOrderDFS(Node node) {
        if (node == null)
            return;

        // visit the parent node (parent of left & right children)
        System.out.print(node.data + " ");

        // recursively go to left subtree
        preOrderDFS(node.left);

        // recursively go to right subtree
        preOrderDFS(node.right);
    }

    // Method to print the tree in in-order traversal
    void inOrderDFS(Node node) {
        if (node == null)
            return;

        // recursively go to left subtree
        inOrderDFS(node.left);

        // visit the parent node (parent of left & right children)
        System.out.print(node.data + " ");

        // recursively go to right subtree
        inOrderDFS(node.right);
    }

    // Method to print the tree in post-order traversal
    void postOrderDFS(Node node) {
        if (node == null)
            return;

        // recursively go to left subtree
        postOrderDFS(node.left);

        // recursively go to right subtree
        postOrderDFS(node.right);

        // visit the parent node (parent of left & right children)
        System.out.print(node.data + " ");
    }

    int findHeight(Node node) {
		if (node == null)
            return 0;
        else {
			int lh = findHeight(node.left);
			int rh = findHeight(node.right);
			if (lh > rh)
				return (lh + 1);
			else
				return (rh + 1);
        }
	}

    /* Through BFS (level traversal) */
    void traverseBFS(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.peek();
            System.out.print(temp.data + " ");
            // enqueue left child into queue
            if (temp.left != null)
                queue.add(temp.left);
            // enqueue right child into queue
            if (temp.right != null)
                queue.add(temp.right);
        }
    }

}

public class BinaryTreeDFSBFS {

    public static void main(String[] args) {

        Tree tree = new Tree();

        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("\nPre-order traversal : ");
        tree.preOrderDFS(tree.root);

        System.out.println("\nIn-order traversal : ");
        tree.inOrderDFS(tree.root);

        System.out.println("\nPost-order traversal : ");
        tree.postOrderDFS(tree.root);
        
        System.out.println("\nHeight of binary tree : " + tree.findHeight(tree.root));;
        
    }
    
}
