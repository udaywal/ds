package tree;

class NodeClass {
    int data;
    NodeClass left;
    NodeClass right;
    NodeClass(int value) {
        this.data = value;
        this.left = this.right = null;
    }
}

class TreeClass {
    NodeClass root;
    TreeClass() {
        this.root = null;
    }
}

public class BinaryTreeCode {

    public static void main(String[] args) {

        TreeClass tree = new TreeClass();

        tree.root = new NodeClass(1);

        tree.root.left = new NodeClass(2);
        tree.root.right = new NodeClass(3);

        tree.root.left.left = new NodeClass(4);
        tree.root.left.right = new NodeClass(5);

        tree.root.right.left = new NodeClass(6);
        tree.root.right.right = new NodeClass(7);
        
    }
    
}
