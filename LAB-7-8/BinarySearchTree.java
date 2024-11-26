/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binaryt;


// Node class represents each node in the binary search tree
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

// BinarySearchTree class contains methods to insert and delete nodes
class BinarySearchTree {
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // Function to insert a new node with the given key
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Helper function to insert a new key recursively
    Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        // return the (unchanged) node pointer
        return root;
    }

    // Function to delete a node with the given key
    void delete(int key) {
        root = deleteRec(root, key);
    }

    // Helper function to delete a node recursively
    Node deleteRec(Node root, int key) {
        // Base case: If the tree is empty
        if (root == null)
            return root;

        // Otherwise, recur down the tree
        if (key < root.data)
            root.left = deleteRec(root.left, key);
        else if (key > root.data)
            root.right = deleteRec(root.right, key);
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    // Function to get the node with the minimum value
    int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Function to print the tree in-order (for testing purposes)
    void inorder() {
        inorderRec(root);
    }

    // Helper function to do in-order traversal
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Main driver method to test the functionality
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Inserting nodes into the BST
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print the in-order traversal of the BST
        System.out.println("In-order traversal of the given tree:");
        tree.inorder();

        // Delete a node
        System.out.println("\n\nDelete 20:");
        tree.delete(20);
        tree.inorder();

        // Delete a node with one child
        System.out.println("\n\nDelete 30:");
        tree.delete(30);
        tree.inorder();

        // Delete a node with two children
        System.out.println("\n\nDelete 50:");
        tree.delete(50);
        tree.inorder();
    }
}
