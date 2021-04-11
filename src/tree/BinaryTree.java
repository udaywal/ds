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

    int findTotalLeaf(Node node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return 1;
        } else {
            int leafOnLeft = findTotalLeaf(node.left);
            int leafOnRight = findTotalLeaf(node.right);
            return (leafOnLeft + leafOnRight);
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

    /**
     * Nodes that do not have sibling.
     * **/
    void getSiblings(Node node) {
        if (node == null) {
            return;
        } else if (node.left == null && node.right != null) {
            System.out.print(node.right.data);
            getSiblings(node.right);
            return;
        } else if (node.left != null && node.right == null) {
            System.out.print(node.left.data);
            getSiblings(node.left);
            return;
        } else {
            getSiblings(node.left);
            getSiblings(node.right);
            return;
        }
    }
    
    /**
     * print the path from the root node of the tree until the leaf nodes..
     * **/
    void printPathToLeaf(Node node, LinkedList<Integer> path) {
        if (node == null) {
            return;
        } else if (node.left == null && node.right == null) {
            for (Integer p:path) {
                System.out.print(p + " ");
            }
            path.remove(path.size() - 1);
            System.out.println("");
            return;
        } else {
            if (node.left != null) {
                path.add(node.left.data);
                printPathToLeaf(node.left, path);
            }
            if (node.right != null) {
                path.add(node.right.data);
                printPathToLeaf(node.right, path);
            }
            return;
        }
    }
    
}

class BST {

    Node root;
    BST() {
        this.root = null;
    }

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

    // Method to search for a node with given key in a BST
    static boolean search(Node node, int key) {
        if (node == null)
            return false;

        if (key == node.data)
            return true;

        if (key < node.data)
            return search(node.left, key);
        else
            return search(node.right, key);
    }

    Node insert(Node node, int key) {
        /* for the leaf node */
        if (node == null) {
            return new Node(key);
        } 
        
        if (key < node.data) {
            node.left = insert(node.left, key);
        } else if (key > node.data) {
            node.right = insert(node.right, key);
        } 
        
        /* after end of one recursion we return the added to the previous node */
        /* after end of the entire recursion we return the root node */
        return node;

        /* In this recursion, we are simply returning the node to update the previous node after insertion of a new node */
    }

    /* lowest common ancestors */
    Node lca (Node node, int range1, int range2) {
        if (node == null) {
            return null;
        }

        if (range1 < node.data && range2 < node.data) {
            node = lca(node.left, range1, range2);
        } else if (range1 > node.data && range2 > node.data) {
            node = lca(node.right, range1, range2);
        }

        return node;
    }

    /***************
    *** PROBLEMS ***
    ***************/

    /**
     * TreeModificationProblem *
     * A binary tree has been given below. 
     * Write a pseudocode to modify the tree consisting of the sum of each node and its children.
     * So if root node = 5 and left and right node has 3, 6 
     * then root node after the modification would be 5+3+6 = 14
     * 
     **/
    int TreeModificationProblem(Node node) {

        if (node == null) {
            return 0;
        } else {
            node.data = node.data + TreeModificationProblem(node.left) + TreeModificationProblem(node.right);
        }

        return node.data;
    }

    /* Balanced Tree */
    Node BalanceSortedTree(int[] arr, int start, int end) {
        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);

        /* Recursively construct the left subtree and make it
        left child of root */
        node.left = BalanceSortedTree(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it
        right child of root */
        node.right = BalanceSortedTree(arr, mid + 1, end);
        
        return node;
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

        // tree.root.right = new Node(7);
        // tree.root.right.left = new Node(3);
        // tree.root.right.right = new Node(9);
        
        // System.out.println("\nPre-order traversal : ");
        // tree.preOrderDFS(tree.root);
        
        // System.out.println("\nIn-order traversal : ");
        // tree.inOrderDFS(tree.root);
        
        // System.out.println("\nPost-order traversal : ");
        // tree.postOrderDFS(tree.root);
        
        // System.out.println("\nHeight of binary tree : " + tree.findHeight(tree.root));
        
        System.out.println("\nMirror tree : ");
        tree.mirror(tree.root);
        tree.preOrderDFS(tree.root);
        
        /* Total Leaf Count in a Tree */
        // int leaves = tree.findTotalLeaf(tree.root);
        // System.out.println("Total leaf on tree : " + leaves);
        
        /* Print Siblings in the Tree */
        // System.out.println("Siblings on tree : ");
        // tree.getSiblings(tree.root);
        
        /* Print path to leaf in a Tree */
        // System.out.println("Printing path to leaves : ");
        // LinkedList<Integer> path = new LinkedList<Integer>();
        // path.add(tree.root.data);
        // tree.printPathToLeaf(tree.root, path);
        
        // System.out.println("\nSpiral order traversal : ");
        // tree.spiralLevelOrderTraversal(tree.root);
        
        /* Binary Search Tree */
        BST bst = new BST();
        
        bst.root = new Node(5);
        
        bst.root.left = new Node(3);
        bst.root.right = new Node(7);
        
        bst.root.left.left = new Node(2);
        bst.root.left.right = new Node(4);
        
        bst.root.right.left = new Node(6);
        bst.root.right.right = new Node(8);

        
        /* Finding in BST */
        // System.out.println(BST.search(bst.node, 10));
        
        /* Insering in BST */
        
        // BST bst1 = new BST();
        // bst1.root = new Node(5);
        // bst1.root.left = new Node(2);
        // bst1.root.right = new Node(8);
        // bst1.root.left.left = new Node(1);
        // bst1.root.left.right = new Node(4);
        
        // bst1.inOrderDFS(bst1.root);
        
        // bst1.insert(bst1.root, 10);
        
        // bst1.inOrderDFS(bst1.root);
        
        /**
         * 
         * The lowest common ancestor of nodes n1 and n2 is the lowest possible node in the tree whose descendants 
         * include nodes n1 and n2.
         * Note:
         * Descendants of a node are all the nodes that are derived from that node.
         * Consider that the node is a descendant of itself.
         * 
         */
        
        // BST bst2 = new BST();
        // bst2.root = new Node(5);
        // bst2.insert(bst2.root, 2);
        // bst2.root = new Node(5);
        // bst2.root.left = new Node(2);
        // bst2.root.right = new Node(7);
        // bst2.root.left.left = new Node(1);
        // bst2.root.left.right = new Node(3);
        // bst2.root.left.right.right = new Node(4);
        
        // bst2.inOrderDFS(bst2.root);
        
        // int range1 = 6;
        // int range2 = 8;
        // Node lowestAncestorNode = bst.lca(bst.root, range1, range2);
        // System.out.print("\nLowest ancestor node of " + range1 + " and " + range2 + " is :");
        // System.out.print(lowestAncestorNode.data);
        
        /* TreeModificationProblem */
        // bst.TreeModificationProblem(bst.root);
        // bst.inOrderDFS(bst.root);
        
    }
    
}
