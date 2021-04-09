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

    // Method to convert a given binary tree into its mirror image
	public void mirror(Node node) {
		if (node == null) {
            return;
        } else {
            mirror(node.left);
            mirror(node.right);
            Node temp = node.right;
            node.right = node.left;
            node.left = temp;
        }
	}

    /* Through BFS (level traversal) */
    void traverseBFS(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.peek();
            queue.remove();
            System.out.print(temp.data + " ");
            // enqueue left child into queue
            if (temp.left != null)
                queue.add(temp.left);
            // enqueue right child into queue
            if (temp.right != null)
                queue.add(temp.right);
        }
    }

    /** 
     * You are given a binary tree and are expected to print the spiral order traversal of the tree, 
     * which is equivalent to the level order traversal of the tree in a zig-zag order. 
     * For the tree given below, the spiral order traversal is 1, 2, 3, 7, 6, 5, 4, 8, 9. 
     * */
    void spiralLevelOrderTraversal(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        boolean flag = false;
        while (!queue.isEmpty()) {
            Node temp = queue.peek();
            queue.remove();
            System.out.print(temp.data + " ");
            flag = !flag;
            if (temp.left != null)
                if (flag) {
                    queue.add(temp.left);
                } else {
                    queue.add(temp.right);
                }
            if (temp.right != null)
                if (flag) {
                    queue.add(temp.right);
                } else {
                    queue.add(temp.left);
                }
        }
    }

}

public class BinaryTree {

    public static void main(String[] args) {

        Tree tree = new Tree();

        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        // System.out.println("\nPre-order traversal : ");
        // tree.preOrderDFS(tree.root);

        // System.out.println("\nIn-order traversal : ");
        // tree.inOrderDFS(tree.root);

        // System.out.println("\nPost-order traversal : ");
        // tree.postOrderDFS(tree.root);
        
        // System.out.println("\nHeight of binary tree : " + tree.findHeight(tree.root));
        
        // System.out.println("\nMirror tree : ");
        // tree.mirror(tree.root);
        // tree.preOrderDFS(tree.root);
        
        System.out.println("\nSpiral order traversal : ");
        tree.spiralLevelOrderTraversal(tree.root);
    }
    
}
